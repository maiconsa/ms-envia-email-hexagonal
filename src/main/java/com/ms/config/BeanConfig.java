package com.ms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.adapters.outbound.smtp.SmtpSendEmailService;
import com.ms.domain.email.ports.EmailRepositoryPort;
import com.ms.domain.email.services.EmailServiceImpl;

@Configuration
public class BeanConfig {
	@Bean
	EmailServiceImpl emailServiceImpl(EmailRepositoryPort emailRepository , SmtpSendEmailService smtpSendEmailService ) {
		return new EmailServiceImpl(emailRepository, smtpSendEmailService);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
