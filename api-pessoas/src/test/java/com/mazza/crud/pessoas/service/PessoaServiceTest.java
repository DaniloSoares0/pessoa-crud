package com.mazza.crud.pessoas.service;

import static com.mazza.crud.pessoas.utils.PessoaUtils.createFakeDTO;
import static com.mazza.crud.pessoas.utils.PessoaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.mapper.PessoaMapper;
import com.mazza.crud.pessoas.model.Pessoa;
import com.mazza.crud.pessoas.repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPessoaDTOThenReturnPessoaSaved() throws Exception {
        PessoaDTO pessoaDTO = createFakeDTO();
        Pessoa pessoaSalvaEsperada = createFakeEntity();

        Pessoa pessoaSaved = pessoaMapper.toModel(pessoaService.cadastrarPessoa(pessoaDTO));

        when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoaSalvaEsperada);
        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(pessoaSalvaEsperada);


        assertEquals(pessoaSalvaEsperada, pessoaSaved);
    }
}