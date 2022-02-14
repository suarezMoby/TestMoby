package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.repository.CandidatoRepository;
import com.suarez.testmoby.services.CandidatoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoDtoConId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidatoServiceImplement.class)
class CandidatoServiceImplementTest {

    @InjectMocks
    CandidatoServiceImplement candidatoServiceImplement;

    @Mock
    CandidatoRepository candidatoRepository;

    @MockBean
    CandidatoService candidatoService;

    @Spy
    private ModelMapper modelMapper;


    @Test
    void actualizarEstadoDeCandidato() {

    }

    @Test
    void findByTecnologia() {
    }

    @Test
    void editarCandidato() {
        when(modelMapper.map(getCandidatoDtoConId(), Candidato.class)).thenReturn(getCandidatoConId());
        when(candidatoRepository.save(getCandidatoConId())).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDto.class)).thenReturn(getCandidatoDtoConId());

        CandidatoDto candidatoDTO = candidatoServiceImplement.editarCandidato(getCandidatoDtoConId());

        assertEquals(getCandidatoDtoConId(), candidatoDTO);
    }
}