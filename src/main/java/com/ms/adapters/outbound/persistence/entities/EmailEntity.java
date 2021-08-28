package com.ms.adapters.outbound.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ms.domain.email.enums.SituacaoEmail;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailEntity {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private UUID codigo;
		
		
		@Column
		private String codigoProprietario;

		@Column
		private String emailOrigem;

		@Column
		private String emailDestino;
		
		@Column
		private String titulo;
		
		@Column(columnDefinition = "TEXT")
		private String conteudo;
		
		@Enumerated
		private SituacaoEmail situacao;
		
		@Column
		private LocalDateTime dataEnvio;
		
}
