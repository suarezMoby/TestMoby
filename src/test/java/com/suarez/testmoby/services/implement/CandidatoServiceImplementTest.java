package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CandidatoPorTecnologiaDto;
import com.suarez.testmoby.repository.CandidatoRepository;
import com.suarez.testmoby.repository.CandidatoXTecnologiaRepository;
import com.suarez.testmoby.services.CandidatoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.text.ParseException;
import java.util.List;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoDtoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoDtoSinId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoSinId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getListaCandidatosXTecnologia;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidatoServiceImplement.class)
class CandidatoServiceImplementTest {

    @InjectMocks
    CandidatoServiceImplement candidatoServiceImplement;

    @Mock
    CandidatoRepository candidatoRepository;

    @Mock
    CandidatoXTecnologiaRepository candidatoXTecnologiaRepository;

    @MockBean
    CandidatoService candidatoService;

    @Spy
    private ModelMapper modelMapper;
    
    @Test
    @WithMockUser
    void editarCandidato() {
        when(modelMapper.map(getCandidatoDtoConId(), Candidato.class)).thenReturn(getCandidatoConId());
        when(candidatoRepository.save(getCandidatoConId())).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDto.class)).thenReturn(getCandidatoDtoConId());

        CandidatoDto candidatoDTO = candidatoServiceImplement.editarCandidato(getCandidatoDtoConId());

        assertEquals(getCandidatoDtoConId(), candidatoDTO);
    }

    @Test
    @WithMockUser
    void guardar() throws ParseException {
        when(modelMapper.map(getCandidatoDtoSinId(), Candidato.class)).thenReturn(getCandidatoSinId());
        when(candidatoRepository.save(getCandidatoSinId())).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDto.class)).thenReturn(getCandidatoDtoConId());

        CandidatoDto candidatoDTO = candidatoServiceImplement.guardar(getCandidatoDtoSinId());

        assertEquals(getCandidatoDtoConId(), candidatoDTO);
    }

    @Test
    @WithMockUser
    void findByTecnologia() {
        when(candidatoXTecnologiaRepository.buscarCandidatosXTecnologia("java")).thenReturn(getListaCandidatosXTecnologia());

        List<CandidatoPorTecnologiaDto> lista = candidatoServiceImplement.findByTecnologia("java");

        Assertions.assertNotNull(lista);
    }
}