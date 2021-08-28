package com.ms.domain.email.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;

import com.ms.adapters.dtos.EmailDto;
import com.ms.domain.email.Email;
import com.ms.domain.email.enums.SituacaoEmail;
import com.ms.domain.email.ports.EmailRepositoryPort;
import com.ms.domain.email.ports.EmailServicePort;
import com.ms.domain.email.ports.SendEmailServicePort;


public class EmailServiceImpl implements EmailServicePort {
	private EmailRepositoryPort emailRepository;
	
	private SendEmailServicePort sendEmailServicePort;
	
	
	private final  Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	public EmailServiceImpl(final EmailRepositoryPort emailRepository ,final SendEmailServicePort sendEmailServicePort) {
		this.emailRepository = emailRepository;
		this.sendEmailServicePort = sendEmailServicePort;
	}
	
	@Override
	@Transactional
	public Email envia(EmailDto email) {
		LOGGER.info("Enviando e-mail, aguarde...");
	
		Email emailDomain = Email.builder()
		.conteudo(email.getConteudo())
		.emailDestino(email.getEmailDestino())
		.titulo(email.getTitulo())
		.situacao(SituacaoEmail.ENVIADO)
		.codigoProprietario(email.getCodigoProprietario()).build();
		
		try {
			 this.sendEmailServicePort.sendEmailSmpt(emailDomain);
			LOGGER.info("Email enviado com sucesso.");
		}catch (MailException e) {
			LOGGER.info("Houve um erro ao enviar e-mail: " + e.getMessage());
			emailDomain.setSituacao(SituacaoEmail.ERRO_ENVIO);
		}finally {
			emailDomain.setDataEnvio(LocalDateTime.now());
			emailDomain =  emailRepository.save(emailDomain);
			return emailDomain;
		}

	}
	
	
}
