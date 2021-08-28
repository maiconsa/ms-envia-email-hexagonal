package com.ms.domain.email.ports;

import java.util.Optional;
import java.util.UUID;

import com.ms.domain.email.Email;
import com.ms.domain.email.PageInfo;
import com.ms.domain.email.PaginaEmail;

public interface EmailRepositoryPort {
	Email save(Email Email);
	PaginaEmail findAll(PageInfo pageable);
	Optional<Email> findById(UUID emailId);
	
}
