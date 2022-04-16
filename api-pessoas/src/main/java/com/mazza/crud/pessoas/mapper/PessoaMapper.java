package com.mazza.crud.pessoas.mapper;

import org.mapstruct.Mapper;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.model.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	PessoaDTO toDTO (Pessoa pessoa);
	
	Pessoa toModel(PessoaDTO pessoaDTO);
}
