package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidatoServiceImplement implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public Candidato findByTecnologia(String tecnologia) {
        return null;
    }
}
