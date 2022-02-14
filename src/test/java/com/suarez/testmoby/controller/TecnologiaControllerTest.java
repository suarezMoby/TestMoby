package com.suarez.testmoby.controller;

import com.suarez.testmoby.services.TecnologiaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getListaTecnologiasDto;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDTOConIdModificadoJson;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoConIdJson;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoConIdModificado;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getTecnologiaDtoSinId;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TecnologiaController.class)
class TecnologiaControllerTest {

    @MockBean
    TecnologiaService tecnologiaService;

    @Autowired
    private MockMvc mockMvc;

    @Disabled
    @Test
    @WithMockUser
    void guardarTecnologia() throws Exception {
        when(tecnologiaService.guardarTecnologia(getTecnologiaDtoSinId())).thenReturn(getTecnologiaDtoConId());
        mockMvc.perform(post("/api/tecnologia/guardarTecnologia", getTecnologiaDtoConIdJson())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getTecnologiaDtoConIdJson()))
                .andExpect(status().isCreated());
    }

    @Disabled
    @Test
    @WithMockUser
    void editarTecnologia() throws Exception {
        when(tecnologiaService.editarTecnologia(getTecnologiaDtoConId())).thenReturn(getTecnologiaDtoConIdModificado());
        mockMvc.perform(post("/api/tecnologia/editarTecnologia", getTecnologiaDTOConIdModificadoJson())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getTecnologiaDTOConIdModificadoJson()))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser
    void traerTecnologias() throws Exception {
        when(tecnologiaService.traerTecnologias()).thenReturn(getListaTecnologiasDto());
        mockMvc.perform(get("/api/tecnologia/traerTecnologias"))
                .andExpect(status().isOk());
    }
}