package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.views.CandidatoDto;

import java.util.List;

public interface CandidatoService {

    public Candidato createCandidato(Candidato candidato);

    Candidato actualizarEstadoDeCandidato(Integer id);

    List<CandidatoDto> findByTecnologia(String tecnologia);


}
