package com.mazza.crud.pessoas.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PessoaDTO {

	private Long id;

	private String nomeCompleto;

	private LocalDate dataNascimento;

	@Email
	private String email;

	private String celular;

	@CPF
	private String cpf;

	private LocalDate dataCriacao;
}
