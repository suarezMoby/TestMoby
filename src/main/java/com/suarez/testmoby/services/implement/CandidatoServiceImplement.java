package com.suarez.testmoby.services.implement;

import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.repository.CandidatoRepository;
import com.suarez.testmoby.services.CandidatoService;
import com.suarez.testmoby.services.CandidatoXTecnologiaService;
import com.suarez.testmoby.services.TecnologiaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class CandidatoServiceImplement implements CandidatoService {


    public static final int DESHABILITADO = 0;
    public static final int HABILITADO = 1;


    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    TecnologiaService tecnologiaService;

    @Autowired
    CandidatoXTecnologiaService candidatoXTecnologiaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CandidatoDto guardar(CandidatoDto candidatoDto) throws ParseException {
        if(candidatoDto.getDni() == null){
            log.error("Se debe incluir un dni");
        }
        Candidato nuevo = modelMapper.map(candidatoDto, Candidato.class);
        Candidato candidato = candidatoRepository.save(nuevo);
        log.info("El candidato se guardo correctamente");

        return modelMapper.map(candidato, CandidatoDto.class);
    }

    @Override
    public Candidato actualizarEstadoDeCandidato(Integer id) {
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encontró el candidato - id: " + id));
        candidato.setEstado(DESHABILITADO);
        log.info("El candidato se deshabilito " + candidato.getEstado());
        return candidatoRepository.save(candidato);    }


    @Override
    public List<CandidatoDto> findByTecnologia(String tecnologia) {
        List<Candidato> listaCandidato = candidatoRepository.findAll();
        List<CandidatoDto> listaCandidatoDto = new ArrayList<>();
        Tecnologia tecnologia1 = tecnologiaService.findByName(tecnologia);
        List<CandidatoPorTecnologia> candidatoPorTecnologiaList = candidatoXTecnologiaService.findByIdTecnologia(tecnologia1.getIdTecnologia());

        for (Candidato candidato : listaCandidato) {
            for (CandidatoPorTecnologia candidatoPorTecnologia : candidatoPorTecnologiaList) {
                if (candidatoPorTecnologia.getCandidato().getIdCandidato().equals(candidato.getIdCandidato())) {
                    CandidatoDto candidatoDto = CandidatoDto.builder()
                            .id(candidato.getIdCandidato())
                            .nombre(candidato.getNombre())
                            .apellido(candidato.getApellido())
                            .dni(candidato.getDni())
                            .tipo(candidato.getTipo())
                            .fechaNacimiento(candidato.getFechaNacimiento())
                            .candidatoPorTecnologia(candidatoPorTecnologia)
                            .build();
                    listaCandidatoDto.add(candidatoDto);
                }
            }
        }
        return listaCandidatoDto;
    }

    @Override
    public CandidatoDto editarCandidato(CandidatoDto candidatoDto) {
        if(candidatoDto.getId() == null){
            log.error("No se encontro el Id del candidato");
        }
        Candidato nuevo = modelMapper.map(candidatoDto, Candidato.class);

        Candidato candidato = candidatoRepository.save(nuevo);

        log.info("Se modifico el candidato correctamente.");

        return modelMapper.map(candidato, CandidatoDto.class);
    }
}
