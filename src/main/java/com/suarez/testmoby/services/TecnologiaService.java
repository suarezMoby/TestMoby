package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;

public interface TecnologiaService {
    
   Tecnologia findByName(String name);

  public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoXTecnologia);

    public TecnologiaDto guardarTecnologia(TecnologiaDto tecnologiaDto);
}
