package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.CandidatoNuevo;
import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.CrearCandidatoDto;
import com.suarez.testmoby.model.views.TecnologiaDto;
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

    public void guardarListaTecnologias(CrearCandidatoDto candidatoDto, CandidatoNuevo candidatoGuardado) {
        for (TecnologiaDto tecnologiaDto : candidatoDto.getTecnologias()) {

            tecnologiaService.guardarTecnologiaPorCandidato(CandidatoPorTecnologia.builder()
                    .tecnologia(Tecnologia.builder()
                            .idTecnologia(tecnologiaDto.getId())
                            .nombreTecnologia(tecnologiaDto.getNombre())
                            .version(tecnologiaDto.getVersion())
                            .build())
                    .idCandidatoPorTecnologia(candidatoGuardado.getIdCandidatoNuevo())
                    .build()
            );
        }
    }
}
