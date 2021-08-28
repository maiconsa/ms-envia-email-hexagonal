package com.ms.adapters.inbound.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.domain.email.Email;
import com.ms.domain.email.ports.EmailServicePort;
import com.ms.dtos.EmailDto;

@RestController
@RequestMapping("/ms/envio-email")
public class EmailController {
	@Autowired
	private EmailServicePort emailService;

	@PostMapping
	public ResponseEntity<Email> envia(@RequestBody @Valid EmailDto payload) {
		Email emailEnviado = emailService.envia(payload);
		return ResponseEntity.status(HttpStatus.CREATED).body(emailEnviado);
	}
}
