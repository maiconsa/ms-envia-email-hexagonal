package com.ms.domain.email.ports;

import com.ms.adapters.dtos.EmailDto;
import com.ms.domain.email.Email;

public interface EmailServicePort {

	Email envia(EmailDto email);

}