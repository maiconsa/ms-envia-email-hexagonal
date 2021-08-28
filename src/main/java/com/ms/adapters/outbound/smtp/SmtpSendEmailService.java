package com.ms.adapters.outbound.smtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.domain.email.Email;
import com.ms.domain.email.ports.SendEmailServicePort;

@Service
public class SmtpSendEmailService implements SendEmailServicePort {
	@Autowired
	private JavaMailSender emailSender;
	
	
	@Override
	public void sendEmailSmpt(Email email) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setFrom(email.getEmailOrigem());
		simpleMessage.setTo(email.getEmailDestino());
		simpleMessage.setSubject(email.getTitulo());
		simpleMessage.setText(email.getConteudo());
		
		emailSender.send(simpleMessage);

	};
}
