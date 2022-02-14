package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.views.CandidatoDto;

import java.text.ParseException;
import java.util.List;

public interface CandidatoService {

    public CandidatoDto guardar(CandidatoDto candidatoDto) throws ParseException;

    Candidato actualizarEstadoDeCandidato(Integer id);

    List<CandidatoDto> findByTecnologia(String tecnologia);

    CandidatoDto editarCandidato(CandidatoDto candidatoDto);


}
