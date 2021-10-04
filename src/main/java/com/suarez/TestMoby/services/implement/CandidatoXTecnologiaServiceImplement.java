package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.repository.CandidatoXTecnologiaRepository;
import com.suarez.TestMoby.services.CandidatoXTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoXTecnologiaServiceImplement implements CandidatoXTecnologiaService {

    @Autowired
    CandidatoXTecnologiaRepository candidatoXTecnologiaRepository;

  /*  @Override
    public List<CandidatoPorTecnologia> candidatosByTecnologia(Integer idTecnologia) {

        return candidatoXTecnologiaRepository.candidatosByTecnologia(idTecnologia);
    }*/
}
