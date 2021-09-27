package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import com.suarez.TestMoby.repository.CandidatoPorTecnologia;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.service.CandidatoService;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CandidatoServiceImplement implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    CandidatoPorTecnologia candidatoPorTecnologia;



    @Override
    public List<Candidato> getCandidatosPorTecnologia(String tecno) {
        return candidatoRepository.buscarTecnologia(tecno);
    }


}
