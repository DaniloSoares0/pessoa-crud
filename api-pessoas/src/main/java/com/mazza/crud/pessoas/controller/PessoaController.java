package com.mazza.crud.pessoas.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(value = "Pessoa")
@RequestMapping("/api/v1/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

	public PessoaService pessoaService;


	@PostMapping
	@ApiOperation(value = "Cadastra uma pessoa.")
	public ResponseEntity<?> cadastrarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
		pessoaService.cadastrarPessoa(pessoaDTO);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping
	@ApiOperation(value = "Atualiza uma pessoa.")
	public ResponseEntity<PessoaDTO> atualizarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizarPessoa(pessoaDTO));
	}

	@DeleteMapping(value = "/deletar/{id}")
	@ApiOperation(value = "Deleta uma pessoa.")
	public ResponseEntity<?> deletarPessoa(@PathVariable("id") Long id){
		pessoaService.deletarPessoa(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping
	@ApiOperation(value = "Lista pessoas com filtros e com paginação.")
	public Page<PessoaDTO> findPerson(
			@RequestParam(name = "pageIndex" , defaultValue = "0") Integer page,
			@RequestParam(name = "pageSize" , defaultValue = "10") Integer size,
			@RequestParam(name = "sortDirection" , defaultValue = "ASC") String sortDirection){

		return pessoaService.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), "id"));
	}
	
	@GetMapping("/buscar-por-cpf/{cpf}")
	@ApiOperation(value = "Lista pessoas com filtros e com paginação.")
	public Page<PessoaDTO> findPerson(
			@RequestParam(name = "pageIndex" , defaultValue = "0") Integer page,
			@RequestParam(name = "pageSize" , defaultValue = "10") Integer size,
			@RequestParam(name = "sortDirection" , defaultValue = "ASC") String sortDirection){

		return pessoaService.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), "id"));
	}
	
	
}
