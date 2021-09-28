package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.exception.ExisteDocException;
import com.suarez.TestMoby.exception.TecnologiaException;
import com.suarez.TestMoby.model.entities.CandidatoNuevo;
import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import com.suarez.TestMoby.model.entities.Tecnologia;
import com.suarez.TestMoby.model.views.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.views.CrearCandidatoDto;
import com.suarez.TestMoby.model.views.TecnologiaDto;
import com.suarez.TestMoby.repository.CandidatoNuevoRepository;
import com.suarez.TestMoby.repository.CandidatoPorTecnologiaRepository;
import com.suarez.TestMoby.service.CandidatoNuevoService;
import com.suarez.TestMoby.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

public class CandidatoNuevoServiceImplement  implements CandidatoNuevoService {

    @Autowired
    CandidatoNuevoRepository candidatoNuevoRepository;

    @Autowired
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    @Autowired
    Tecnologia tecnologia;

    @Autowired
    TecnologiaService tecnologiaService;

    @Autowired
    CandidatoPorTecnologia candidatoPorTecnologia;


    @Override
    public Boolean guardar(CrearCandidatoDto dto) throws ParseException {
        Integer id = cargarCandidato(dto).getIdCandidato();
        return candidatoNuevoRepository.existsById(id);
    }

    @Override
    public boolean existePorDocumento(String documento) {
        return candidatoNuevoRepository.existsByDocumento(documento);
    }

    @Override
    public CandidatoNuevo cargarCandidato(CrearCandidatoDto dto)  {

        if (existePorDocumento(dto.getDni()))
            throw new ExisteDocException();
        if (dto.getTecnologias().isEmpty())
            throw new TecnologiaException();

        CandidatoNuevo candidato = CandidatoNuevo.builder()

                .apellido(dto.getApellido())
                .numeroDoc(dto.getDni())
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .build();

        CandidatoNuevo candidatoGuardado = candidatoNuevoRepository.save(candidato);


        guardarListaTecnologias(dto, candidatoGuardado);


        return candidatoGuardado;
    }

    public void guardarListaTecnologias(CrearCandidatoDto dto, CandidatoNuevo candidatoGuardado) {

        for (TecnologiaDto tecnologiaDto : dto.getTecnologias()) {

            tecnologiaService.guardarTecnologiaPorCandidato(CandidatoXTecnologia.builder()
                    .tecnologia(Tecnologia.builder()
                            .idTecnologia(tecnologiaDto.getIdTecnologia())
                            .build())
                    .candidato(candidatoGuardado)
                    .build()
            );
        }

    }
}
