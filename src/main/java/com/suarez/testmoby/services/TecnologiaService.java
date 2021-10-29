package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;

public interface TecnologiaService {
    
   Tecnologia findByName(String name);

  public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoXTecnologia);
}
