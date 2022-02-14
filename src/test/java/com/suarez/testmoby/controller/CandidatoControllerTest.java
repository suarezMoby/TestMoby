package com.suarez.testmoby.controller;

import com.google.gson.Gson;
import com.suarez.testmoby.services.CandidatoNuevoService;
import com.suarez.testmoby.services.CandidatoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoConIdJson;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoDtoConId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCandidatoDtoEditado;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getCrearCandidatoDtoSinId;
import static com.suarez.testmoby.testUtils.TestEntityFactory.getListaCandidatosDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    @WithMockUser
    void eliminarCandidato() throws Exception {

        when(candidatoService.actualizarEstadoDeCandidato(getCandidatoConId().getIdCandidato())).thenReturn(getCandidatoConId());

        mockMvc.perform(delete("/api/candidato/eliminarCandidato/1"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    @WithMockUser
    void buscarCandidato() throws Exception {
        when(candidatoService.findByTecnologia("java")).thenReturn(getListaCandidatosDto());
        mockMvc.perform(get("/api/candidato/listarCandidatos/{tecnologia}", "java"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void modificarCandidato() throws Exception {

        when(candidatoService.editarCandidato(getCandidatoDtoConId())).thenReturn(getCandidatoDtoEditado());
        mockMvc.perform(post("/api/candidato/editarCandidato", getCandidatoDtoEditado())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getCandidatoConIdJson()))
                .andExpect(status().isOk());
    }
}