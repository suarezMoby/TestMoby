package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.service.CandidatoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class CandidatoServiceImplement implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public void guardar(Candidato candidato) {
     candidatoRepository.save(candidato);
    }
}
