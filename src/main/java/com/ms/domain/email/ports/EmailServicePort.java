package com.ms.domain.email.ports;

import com.ms.domain.email.Email;
import com.ms.dtos.EmailDto;

public interface EmailServicePort {

	Email envia(EmailDto email);

}