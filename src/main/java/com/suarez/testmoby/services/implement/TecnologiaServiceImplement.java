package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;
import com.suarez.testmoby.repository.TecnologiaRepository;
import com.suarez.testmoby.services.TecnologiaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Log
@Service
public class TecnologiaServiceImplement implements TecnologiaService {


    @Autowired
    TecnologiaRepository tecnologiaRepository;

    @Autowired
    TecnologiaService tecnologiaService;

    @Autowired
    ModelMapper modelMappper;


    @Override
    public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoPorTecnologia) {

    }

    @Override
    public TecnologiaDto guardarTecnologia(TecnologiaDto tecnologiaDto) {
        Tecnologia nuevo = modelMappper.map(tecnologiaDto, Tecnologia.class);

        Tecnologia tecnologia = tecnologiaRepository.save(nuevo);

        return modelMappper.map(tecnologia, TecnologiaDto.class);
    }

    @Override
    public Tecnologia findByName(String name) {
        log.info("Este es el nombre de la tecnologia es" + name);
        return tecnologiaService.findByName(name);
    }


}
