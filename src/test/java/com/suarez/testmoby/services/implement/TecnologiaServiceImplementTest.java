package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;
import com.suarez.testmoby.repository.TecnologiaRepository;
import com.suarez.testmoby.services.TecnologiaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;
import java.util.Optional;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getListaTecnologias;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getListaTecnologiasDto;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoSinId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaSinId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = TecnologiaServiceImplement.class)
class TecnologiaServiceImplementTest {

    @InjectMocks
    TecnologiaServiceImplement tecnologiaServiceImplement;

    @Mock
    TecnologiaRepository tecnologiaRepository;

    @MockBean
    TecnologiaService tecnologiaService;

    @Spy
    private ModelMapper modelMapper;

    @Test
    @WithMockUser
    void guardarTecnologia() {
        when(modelMapper.map(getTecnologiaDtoSinId(), Tecnologia.class)).thenReturn(getTecnologiaSinId());
        when(tecnologiaRepository.save(getTecnologiaSinId())).thenReturn(getTecnologiaConId());

        TecnologiaDto tecnologiaDTO = tecnologiaServiceImplement.guardarTecnologia(getTecnologiaDtoSinId());

        assertEquals(getTecnologiaDtoConId(), tecnologiaDTO);
    }

    @Test
    @WithMockUser
    void editarTecnologia() {
        when(modelMapper.map(getTecnologiaDtoConId(), Tecnologia.class)).thenReturn(getTecnologiaConId());
        when(tecnologiaRepository.save(getTecnologiaConId())).thenReturn(getTecnologiaConId());

        TecnologiaDto tecnologiaDTO = tecnologiaServiceImplement.editarTecnologia(getTecnologiaDtoConId());

        assertEquals(getTecnologiaDtoConId(), tecnologiaDTO);
    }

    @Test
    @WithMockUser
    void eliminarTecnologiaPorId() {
        Tecnologia tecnologiaEsperada = mock(Tecnologia.class);
        when(tecnologiaRepository.findById(1)).thenReturn(Optional.of(tecnologiaEsperada));
        tecnologiaServiceImplement.eliminarTecnologiaPorId(1);
        verify(tecnologiaRepository, times(1)).deleteById(1);
    }

    @Test
    @WithMockUser
    void traerTecnologias() {
        when(tecnologiaRepository.findAll()).thenReturn(getListaTecnologias());

        List<TecnologiaDto> lista = tecnologiaServiceImplement.traerTecnologias();

        assertEquals(getListaTecnologiasDto(), lista);
    }

}