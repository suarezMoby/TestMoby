package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.repository.TecnologiaRepository;
import com.suarez.testmoby.services.TecnologiaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class TecnologiaServiceImplement implements TecnologiaService {

    @Override
    public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoPorTecnologia) {

    }

    @Autowired
    TecnologiaRepository tecnologiaRepository;

    @Override
    public Tecnologia findByName(String nombre){
        log.info("Este es el nombre de la tecnologia es" + nombre.toString());
        return  tecnologiaRepository.findByName(nombre);
    }
}
