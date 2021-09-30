package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.repository.CandidatoPorTecnologiaRepository;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.service.CandidatoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidatoServiceImplement implements CandidatoService {

    /*@Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    CandidatoPorTecnologiaRepository candidatoPorTecnologia;

    @Override
    public Candidato crearCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }



    @Override
    public List<Candidato> getCandidatosPorTecnologia(String tecno) {
        return candidatoRepository.buscarTecnologia(tecno);
    }*/


}
