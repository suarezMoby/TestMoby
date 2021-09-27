package com.suarez.TestMoby.service;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.Tecnologia;

public interface CandidatoService {

    void guardar(Candidato candidato);
    void bucarXTecnologia(Tecnologia tecnologia);
}
