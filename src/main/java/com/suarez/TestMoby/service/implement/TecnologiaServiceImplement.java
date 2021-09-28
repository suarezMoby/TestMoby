package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.views.CandidatoPorTecnologia;
import com.suarez.TestMoby.repository.CandidatoNuevoRepository;
import com.suarez.TestMoby.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaServiceImplement implements TecnologiaService {
    @Autowired
    CandidatoPorTecnologia candidatoPorTecnologia;

    @Override
    public void guardarTecnologiaPorCandidato(CandidatoPorTecnologia candidatoPorTecnologia){
        candidatoPorTecnologia.save(candidatoPorTecnologia);
    }
}
