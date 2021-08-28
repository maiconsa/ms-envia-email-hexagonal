package com.ms.adapters.outbound.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ms.adapters.outbound.persistence.entities.EmailEntity;
import com.ms.domain.email.Email;
import com.ms.domain.email.PageInfo;
import com.ms.domain.email.PaginaEmail;
import com.ms.domain.email.ports.EmailRepositoryPort;

@Component
@Primary
public class EmailRepositoryImpl implements EmailRepositoryPort {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final SpringDataEmailRepository springEmailRepository;
	public EmailRepositoryImpl(final SpringDataEmailRepository springDataEmailRepository) {
		this.springEmailRepository = springDataEmailRepository;
	}

	@Override
	public Email save(Email emailModel) {
		EmailEntity emailEntity  = modelMapper.map(emailModel, EmailEntity.class);
		emailEntity =  this.springEmailRepository.save(emailEntity);
		
		return  modelMapper.map(emailEntity, Email.class);
	}

	@Override
	public PaginaEmail findAll(PageInfo pageInfo) {
		Pageable pageable = PageRequest.of(pageInfo.getPageNumber()	, pageInfo.getPageSize());
		List<Email> emails =  this.springEmailRepository.findAll(pageable).stream().map(entity -> modelMapper.map(entity , Email.class)).collect(Collectors.toList());
		return PaginaEmail.builder()
				.emails(emails)
				.pagina(pageInfo)
				.build();
	}

	@Override
	public Optional<Email> findById(UUID emailId) {

		Optional<EmailEntity> optional =  this.springEmailRepository.findById(emailId);
		if(optional.isPresent()) {
			return  Optional.of(modelMapper.map(optional.get(), Email.class));
		}else {
			return Optional.empty();
		}
	}

}
