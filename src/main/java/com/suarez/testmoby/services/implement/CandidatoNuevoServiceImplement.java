package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.exception.ExisteDocException;
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

import java.text.ParseException;

@Log
@Service
public class CandidatoNuevoServiceImplement implements CandidatoNuevoService {

    @Autowired
    CandidatoNuevoRepository candidatoNuevoRepository;

    @Autowired
    TecnologiaService tecnologiaService;

    @Override
    public Boolean guardar(CrearCandidatoDto candidatoDto) throws ParseException {
        Integer id = cargarCandidato(candidatoDto).getIdCandidatoNuevo();
        log.info("Este es el Id del candidato" + id.toString());
        return candidatoNuevoRepository.existsById(id);
    }
    @Override
    public boolean existePorDocumento(String documento) {
        log.info("Este es el nombre del candidato" + documento.toString());
        return candidatoNuevoRepository.existsByDocumento(documento);
    }
    @Override
    public CandidatoNuevo cargarCandidato(CrearCandidatoDto candidatoDto)  {
        if (existePorDocumento(candidatoDto.getDni()))
            throw new ExisteDocException();

        CandidatoNuevo candidato = CandidatoNuevo.builder()
                .apellido(candidatoDto.getApellido())
                .numeroDoc(candidatoDto.getDni())
                .nombre(candidatoDto.getNombre())
                .tipo(candidatoDto.getTipo())
                .fechaDeNacimiento(candidatoDto.getFechaDeNacimiento())
                .build();
        CandidatoNuevo candidatoGuardado = candidatoNuevoRepository.save(candidato);
        guardarListaTecnologias(candidatoDto, candidatoGuardado);
        return candidatoGuardado;
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
