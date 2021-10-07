package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.repository.CandidatoXTecnologiaRepository;
import com.suarez.testmoby.services.CandidatoXTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoXTecnologiaServiceImplement implements CandidatoXTecnologiaService {

    @Autowired
    CandidatoXTecnologiaRepository candidatoXTecnologiaRepository;

    @Override
    public List<CandidatoPorTecnologia> candidatosByTecnologia(Integer idTecnologia) {

        return candidatoXTecnologiaRepository.candidatosByTecnologia(idTecnologia);
    }
}
