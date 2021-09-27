package com.suarez.TestMoby.service;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;

import java.util.List;

public interface CandidatoService {

    //void guardar(Candidato candidato);


    List<Candidato> getCandidatosPorTecnologia(String tecno);
}
