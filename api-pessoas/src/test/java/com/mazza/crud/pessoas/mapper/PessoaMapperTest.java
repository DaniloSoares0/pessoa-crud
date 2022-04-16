package com.mazza.crud.pessoas.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mazza.crud.pessoas.dto.PessoaDTO;
import com.mazza.crud.pessoas.model.Pessoa;
import com.mazza.crud.pessoas.utils.PessoaUtils;

@SpringBootTest
public class PessoaMapperTest {

    @Autowired
    private PessoaMapper personMapper;

    @Test
    void testGivenPessoaDTOThenReturnPessoaEntity() {
        PessoaDTO personDTO = PessoaUtils.createFakeDTO();
        Pessoa person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getNomeCompleto(), person.getNomeCompleto());
        assertEquals(personDTO.getCelular(), person.getCelular());
        assertEquals(personDTO.getCpf(), person.getCpf());

    }

    @Test
    void testGivenPessoaEntityThenReturnPessoaDTO() {
        Pessoa person = PessoaUtils.createFakeEntity();
        PessoaDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getNomeCompleto(), personDTO.getNomeCompleto());
        assertEquals(person.getCelular(), personDTO.getCelular());
        assertEquals(person.getCpf(), personDTO.getCpf());
        
    }
}