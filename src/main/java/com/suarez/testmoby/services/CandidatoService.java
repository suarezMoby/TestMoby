package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CandidatoPorTecnologiaDto;

import java.util.List;

public interface CandidatoService {

    public CandidatoDto guardar(CandidatoDto candidatoDto);

    Candidato actualizarEstadoDeCandidato(Integer id);

    public List<CandidatoPorTecnologiaDto> findByTecnologia(String tecnologia);

    CandidatoDto editarCandidato(CandidatoDto candidatoDto);


}
