package com.suarez.TestMoby.services;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.views.CandidatoDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CandidatoService {

    public Candidato createCandidato(Candidato candidato);

    List<CandidatoDto> findByTecnologia(String tecnologia);
}
