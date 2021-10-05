package com.suarez.TestMoby.services;

import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;

import java.util.List;

public interface CandidatoXTecnologiaService {

    public List<CandidatoPorTecnologia> candidatosByTecnologia(Integer idTecnologia);
}
