package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.exception.ExisteDocException;
import com.suarez.TestMoby.exception.TecnologiaException;
import com.suarez.TestMoby.model.entitys.CandidatoNuevo;
import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;
import com.suarez.TestMoby.model.views.CandidatoPorTecnologiaDto;
import com.suarez.TestMoby.model.views.CrearCandidatoDto;
import com.suarez.TestMoby.model.views.TecnologiaDto;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.repository.CandidatoXTecnologiaRepository;
import com.suarez.TestMoby.services.CandidatoNuevoService;
import com.suarez.TestMoby.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class CandidatoNuevoServiceImplement implements CandidatoNuevoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    CandidatoXTecnologiaRepository candidatoPorTecnologiaRepository;
    @Autowired
    Tecnologia tecnologia;
    @Autowired
    TecnologiaService tecnologiaService;
    @Autowired
    CandidatoPorTecnologiaDto candidatoPorTecnologia;

    @Override
    public Boolean guardar(CrearCandidatoDto dto) throws ParseException {
        Integer id = cargarCandidato(dto).getId();
        return candidatoRepository.existsById(id);
    }
    @Override
    public boolean existePorDocumento(String documento) {
        return candidatoRepository.existsByDocumento(documento);
    }
    @Override
    public CandidatoNuevo cargarCandidato(CrearCandidatoDto candidatoDto)  {
        if (existePorDocumento(candidatoDto.getDni()))
            throw new ExisteDocException();
        if (candidatoDto.getTecnologias().isEmpty())
            throw new TecnologiaException();
        CandidatoNuevo candidato = CandidatoNuevo.builder()
                .apellido(candidatoDto.getApellido())
                .numeroDoc(candidatoDto.getDni())
                .nombre(candidatoDto.getNombre())
                .tipo(candidatoDto.getTipo())
                .documento(candidatoDto.getDni())
                .build();
        CandidatoNuevo candidatoGuardado = candidatoRepository.save(candidato);
        guardarListaTecnologias(candidatoDto, candidatoGuardado);
        return candidatoGuardado;
    }
    public void guardarListaTecnologias(CrearCandidatoDto candidatoDto, CandidatoNuevo candidatoGuardado) {
        for (TecnologiaDto tecnologiaDto : candidatoDto.getTecnologias()) {

            tecnologiaService.guardarTecnologiaPorCandidato(CandidatoPorTecnologia.builder()
                    .tecnologia(Tecnologia.builder()
                            .id(tecnologiaDto.getId())
                            .version(tecnologiaDto.getVersion())
                            .build())
                    .candidato(candidatoGuardado)
                    .build()
            );
        }
    }
}
