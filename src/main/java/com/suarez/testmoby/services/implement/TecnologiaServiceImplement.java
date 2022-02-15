package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.exception.NoSeEncontroIdException;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;
import com.suarez.testmoby.repository.TecnologiaRepository;
import com.suarez.testmoby.services.TecnologiaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


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
    public TecnologiaDto guardarTecnologia(TecnologiaDto tecnologiaDto) {
        Tecnologia nuevo = modelMappper.map(tecnologiaDto, Tecnologia.class);

        Tecnologia tecnologia = tecnologiaRepository.save(nuevo);

        return modelMappper.map(tecnologia, TecnologiaDto.class);
    }

    @Override
    public TecnologiaDto editarTecnologia(TecnologiaDto tecnologiaDTO) {
        Tecnologia nuevo = modelMappper.map(tecnologiaDTO, Tecnologia.class);

        Tecnologia tecnologia = tecnologiaRepository.save(nuevo);

        return modelMappper.map(tecnologia, TecnologiaDto.class);

    }

    @Override
    public void eliminarTecnologiaPorId(Integer idTecnologia) {
        Tecnologia tecnologia = tecnologiaRepository.findById(idTecnologia).
                orElseThrow(()-> new NoSeEncontroIdException("No se encontro el Id"));

        if(tecnologia != null){
            tecnologiaRepository.deleteById(idTecnologia);
            log.info("Se elimino la tecnologia");
        }
    }

    @Override
    public List<TecnologiaDto> traerTecnologias() {
        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
        List<TecnologiaDto> tecnologiasDto = new LinkedList<>();

        for (Tecnologia tecnologia: tecnologias) {
            tecnologiasDto.add(modelMappper.map(tecnologia, TecnologiaDto.class));
        }

        return tecnologiasDto;
    }

    @Override
    public Tecnologia findByName(String name) {
        log.info("Este es el nombre de la tecnologia es" + name);
        return tecnologiaService.findByName(name);
    }


}
