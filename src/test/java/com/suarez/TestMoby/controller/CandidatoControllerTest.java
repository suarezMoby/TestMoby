package com.suarez.TestMoby.controller;

import com.google.gson.Gson;
import com.suarez.TestMoby.model.enums.TipoDocumento;
import com.suarez.TestMoby.model.views.CrearCandidatoDto;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class CrearCandidatoTest {

        @Test
        @WithMockUser
        void crearCandidatoBadRequest() throws Exception {
            mockMvc.perform(post("/api/candidato/crear"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @WithMockUser
        void crearCandidatoSinTecnologiasTest() throws Exception {

            CrearCandidatoDto candidatoDto = CrearCandidatoDto.builder()
                    .nombre("Nombre")
                    .apellido("Apellido")
                    .tipo(TipoDocumento.DNI)
                    .dni("2222")
                    .tecnologias(Collections.emptyList())
                    .build();

            String candidatoJson = new Gson().toJson(candidatoDto);

            mockMvc.perform(post("/api/candidato/crear")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(candidatoJson))
                    .andExpect(status().isCreated());
        }

    }

}