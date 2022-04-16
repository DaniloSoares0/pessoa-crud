package com.mazza.crud.pessoas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
@EqualsAndHashCode(of = "id")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME_COMPLETO", columnDefinition = "VARCHAR(80)")
	private String nomeCompleto;
	
	@Column(name = "DATA_NASCIMENTO", columnDefinition = "DATETIME")
	private LocalDate dataNascimento;
	
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(50)")
	private String email;
	
	@Column(name = "CELULAR", columnDefinition = "VARCHAR(15)")
	private String celular;
	
	@Column(name = "CPF", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "DATA_CRIACAO", columnDefinition = "DATETIME", updatable = false)
	private LocalDate dataCriacao;
	
}
