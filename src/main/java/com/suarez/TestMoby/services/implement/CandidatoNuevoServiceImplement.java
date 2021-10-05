package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.exception.ExisteDocException;
import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.entitys.CandidatoNuevo;
import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;
import com.suarez.TestMoby.model.views.CandidatoPorTecnologiaDto;
import com.suarez.TestMoby.model.views.CrearCandidatoDto;
import com.suarez.TestMoby.model.views.TecnologiaDto;
import com.suarez.TestMoby.repository.CandidatoNuevoRepository;
import com.suarez.TestMoby.repository.CandidatoXTecnologiaRepository;
import com.suarez.TestMoby.services.CandidatoNuevoService;
import com.suarez.TestMoby.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class CandidatoNuevoServiceImplement implements CandidatoNuevoService {

    @Autowired
    CandidatoNuevoRepository candidatoNuevoRepository;

    @Autowired
    CandidatoXTecnologiaRepository candidatoPorTecnologiaRepository;
    @Autowired
    Tecnologia tecnologia;
    @Autowired
    TecnologiaService tecnologiaService;
    @Autowired
    CandidatoPorTecnologiaDto candidatoPorTecnologia;

    @Override
    public Boolean guardar(CrearCandidatoDto candidatoDto) throws ParseException {
        Integer id = cargarCandidato(candidatoDto).getId();
        return candidatoNuevoRepository.existsById(id);
    }
    @Override
    public boolean existePorDocumento(String documento) {
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
                            .id(tecnologiaDto.getId())
                            .nombre(tecnologiaDto.getNombre())
                            .version(tecnologiaDto.getVersion())
                            .build())
                    .idCandidatoPorTecnologia(candidatoGuardado.getId())
                    .build()
            );
        }
    }
}
