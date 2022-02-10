package com.suarez.testmoby.controller;

import com.google.gson.Gson;
import com.suarez.testmoby.services.CandidatoNuevoService;
import com.suarez.testmoby.services.CandidatoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoConIdJson;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCrearCandidatoDtoSinId;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidatoController.class)
class CandidatoControllerTest {

    @MockBean
    CandidatoService candidatoService;

    @MockBean
    CandidatoNuevoService candidatoNuevoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void crearCandidato() throws Exception {
        when(candidatoNuevoService.guardar(getCrearCandidatoDtoSinId())).thenReturn(true);
        String candidatoJson = new Gson().toJson(getCrearCandidatoDtoSinId());

        mockMvc.perform(post("/api/candidato/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getCandidatoConIdJson()))
                .andExpect(status().isCreated());
    }

    @Test
    void eliminarCandidato() {
    }

    @Test
    void buscarCandidato() {
    }

    @Test
    void modificarCandidato() {
    }
}