package com.mazza.crud.pessoas.utils;

import java.time.LocalDate;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.model.Pessoa;

public class PessoaUtils {

    private static final String NOME_COMPLETO = "Carlos da Silva Santos";
    private static final String CPF = "369.333.878-79";
    private static final String CELULAR = "(31) 99999-9999";
    private static final String EMAIL = "example@example.com.br";

    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(2010, 10, 1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .nomeCompleto(NOME_COMPLETO)
                .dataNascimento(DATA_NASCIMENTO)
                .cpf(CPF)
                .celular(CELULAR)
                .email(EMAIL)
                .dataCriacao(LocalDate.now())
                .build();
    }

    public static Pessoa createFakeEntity() {
    	   return Pessoa.builder()
                   .nomeCompleto(NOME_COMPLETO)
                   .dataNascimento(DATA_NASCIMENTO)
                   .cpf(CPF)
                   .celular(CELULAR)
                   .email(EMAIL)
                   .dataCriacao(LocalDate.now())
                   .build();
    }
}