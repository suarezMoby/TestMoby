package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.model.entitys.Tecnologia;
import com.suarez.TestMoby.repository.TecnologiaRepository;
import com.suarez.TestMoby.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaServiceImplement implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;

    @Override
    public Tecnologia findByName(String nombre){
        return  tecnologiaRepository.findByName(nombre);
    }
}
