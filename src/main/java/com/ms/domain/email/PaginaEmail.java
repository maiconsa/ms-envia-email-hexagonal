package com.ms.domain.email;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginaEmail {
	private List<Email> emails;
	private PageInfo pagina;
}
