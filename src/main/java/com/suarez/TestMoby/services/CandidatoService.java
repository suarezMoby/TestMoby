package com.suarez.TestMoby.services;

import com.suarez.TestMoby.model.entitys.Candidato;

public interface CandidatoService {

    Candidato findByTecnologia(String tecnologia);
}
