package com.mazza.crud.pessoas.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.mapper.PessoaMapper;
import com.mazza.crud.pessoas.model.Pessoa;
import com.mazza.crud.pessoas.repository.PessoaRepository;
import com.mazza.crud.pessoas.service.PessoaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

	public PessoaRepository pessoaRepository;
	public PessoaMapper pessoaMapper;

	@Override
	public Optional<Pessoa> findByCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}

	@Override
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDto) {
		pessoaDto.setDataCriacao(LocalDate.now());
		return pessoaMapper.toDTO(pessoaRepository.save(pessoaMapper.toModel(pessoaDto)));
	}
	
	@Override
	public PessoaDTO atualizarPessoa(PessoaDTO pessoaDto) {
		if(pessoaRepository.findById(pessoaDto.getId()).isPresent()) 
			return  pessoaMapper.toDTO(pessoaRepository.save(pessoaMapper.toModel(pessoaDto)));
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado!");
	}

	@Override
	public void deletarPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}

	@Override
	public Page<PessoaDTO> findAll(PageRequest pageOptions) {
		return pessoaRepository.findAll(pageOptions).map(pessoaMapper::toDTO);
	}

	@Override
	public Page<PessoaDTO> findByExample(PessoaDTO pessoaDTO, PageRequest pageOptions) {
		return pessoaRepository.findAll(Example.of(pessoaMapper.toModel(pessoaDTO)) ,pageOptions).map(pessoaMapper::toDTO);
	}

	
}


