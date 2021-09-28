package com.suarez.TestMoby.service;

import com.suarez.TestMoby.model.views.CrearCandidatoDto;

import java.text.ParseException;

public interface CandidatoNuevoService {

    Boolean guardar(CrearCandidatoDto dto) throws ParseException;

    public CandidatoNuevo cargarCandidato(CrearCandidatoDto dto);

    boolean existePorDocumento(String documento);
}
