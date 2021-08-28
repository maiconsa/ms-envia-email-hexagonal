package com.ms.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
	
	@NotBlank
	private String codigoProprietario;

	@NotBlank @Email
	private String emailOrigem;

	@NotBlank @Email
	private String emailDestino;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String conteudo;
}
