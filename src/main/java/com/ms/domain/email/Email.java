package com.ms.domain.email;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;

import com.ms.domain.email.enums.SituacaoEmail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
		private UUID codigo;
		private String codigoProprietario;
		private String emailOrigem;
		private String emailDestino;	
		private String titulo;	
		private String conteudo;		
		private SituacaoEmail situacao;
		private LocalDateTime dataEnvio;
		
}
