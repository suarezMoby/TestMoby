package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.CandidatoNuevo;
import com.suarez.testmoby.model.views.CrearCandidatoDto;

import java.text.ParseException;

public interface CandidatoNuevoService {

    Boolean guardar(CrearCandidatoDto dto) throws ParseException;

    CandidatoNuevo cargarCandidato(CrearCandidatoDto dto);

    boolean existePorDocumento(String documento);
}
