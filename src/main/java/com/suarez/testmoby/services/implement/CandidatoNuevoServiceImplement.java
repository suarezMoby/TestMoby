package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.repository.CandidatoNuevoRepository;
import com.suarez.testmoby.services.CandidatoNuevoService;
import com.suarez.testmoby.services.TecnologiaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class CandidatoNuevoServiceImplement implements CandidatoNuevoService {

    @Autowired
    CandidatoNuevoRepository candidatoNuevoRepository;

    @Autowired
    CandidatoNuevoService candidatoNuevoService;

    @Autowired
    TecnologiaService tecnologiaService;


    @Override
    public boolean findByDocument(String document) {
        log.info("Este es el nombre del candidato" + document);
        return candidatoNuevoService.findByDocument(document);
    }
}
