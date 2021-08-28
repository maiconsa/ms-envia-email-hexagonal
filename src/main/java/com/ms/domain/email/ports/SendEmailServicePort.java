package com.ms.domain.email.ports;
import com.ms.domain.email.Email;

public interface SendEmailServicePort {
	void sendEmailSmpt(Email email);
}
