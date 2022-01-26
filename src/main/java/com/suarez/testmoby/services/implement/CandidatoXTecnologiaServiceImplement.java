package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.services.CandidatoXTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoXTecnologiaServiceImplement implements CandidatoXTecnologiaService {

    @Autowired
    CandidatoXTecnologiaService candidatoXTecnologiaService;

    @Override
    public List<CandidatoPorTecnologia> findByIdTecnologia(Integer idTecnologia) {

        return candidatoXTecnologiaService.findByIdTecnologia(idTecnologia);
    }
}
