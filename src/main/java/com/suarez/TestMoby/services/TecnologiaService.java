package com.suarez.TestMoby.services;

import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;

public interface TecnologiaService {

  /* Tecnologia findByName(String nombre);*/

  public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoXTecnologia);
}
