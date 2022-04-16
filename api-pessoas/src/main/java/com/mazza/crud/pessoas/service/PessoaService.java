package com.mazza.crud.pessoas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.model.Pessoa;

public interface PessoaService {

   Optional<Pessoa> findByCpf(String cpf);
   
   Optional<Pessoa> findById(Long id);

   PessoaDTO cadastrarPessoa(PessoaDTO pessoaDto);
   
   PessoaDTO atualizarPessoa(PessoaDTO pessoaDto);

   void deletarPessoa(Long id);

   Page<PessoaDTO> findAll(PageRequest pageOptions);
}
