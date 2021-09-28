package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.repository.CandidatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidatoServiceImplementTest {

    @InjectMocks
    private CandidatoServiceImplement candidatoServiceImplement;

    @Mock
    private CandidatoRepository candidatoRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCandidatosPorTecnologia(String tecno){
        List<Candidato>candidatosEsperados = mock(List.class);
        when(candidatoRepository.buscarTecnologia(tecno)).thenReturn(candidatosEsperados);
        List<Candidato> candidatoActual = candidatoServiceImplement.getCandidatosPorTecnologia(tecno);
        verify(candidatoRepository,times(1)).buscarTecnologia(tecno);
    }

}
