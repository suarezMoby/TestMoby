package com.suarez.TestMoby.services;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.views.CandidatoDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CandidatoService {

    List<CandidatoDto> findByTecnologia(String tecnologia);
}
