package com.suarez.testmoby.services;

import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;

import java.util.List;

public interface TecnologiaService {
    
   Tecnologia findByName(String name);

    public TecnologiaDto guardarTecnologia(TecnologiaDto tecnologiaDto);

    public TecnologiaDto editarTecnologia(TecnologiaDto tecnologiaDTO);

    public void eliminarTecnologiaPorId(Integer idTecnologia);

    List<TecnologiaDto> traerTecnologias();
}
