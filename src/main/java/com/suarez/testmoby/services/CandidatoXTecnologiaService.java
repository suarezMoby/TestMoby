package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;

import java.util.List;

public interface CandidatoXTecnologiaService {

    public List<CandidatoPorTecnologia> findByIdTecnologia(Integer idTecnologia);
}
