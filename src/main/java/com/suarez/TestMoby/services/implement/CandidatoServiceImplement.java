package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;
import com.suarez.TestMoby.model.views.CandidatoDto;
import com.suarez.TestMoby.repository.CandidatoRepository;
import com.suarez.TestMoby.services.CandidatoService;
import com.suarez.TestMoby.services.CandidatoXTecnologiaService;
import com.suarez.TestMoby.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoServiceImplement implements CandidatoService {


    public static final int  DESHABILITADO = 0;
    public static final int HABILITADO = 1;


    @Autowired
    CandidatoRepository candidatoRepository;


   @Autowired
   TecnologiaService tecnologiaService;

    @Autowired
    CandidatoXTecnologiaService candidatoXTecnologiaService;

    @Override
    public Candidato createCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    @Override
    public Candidato actualizarEstadoDeCandidato(Integer id) {
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encontró el candidato - id: " + id));
        candidato.setEstado(DESHABILITADO);
        return candidatoRepository.save(candidato);
    }



    @Override
    public List<CandidatoDto> findByTecnologia(String tecnologia) {
       List<Candidato> listaCandidato = candidatoRepository.findAll();
        List<CandidatoDto> listaCandidatoDto = new ArrayList<>();
        Tecnologia tecnologia1 = tecnologiaService.findByName(tecnologia);
        List<CandidatoPorTecnologia> candidatoPorTecnologiaList = candidatoXTecnologiaService.candidatosByTecnologia(tecnologia1.getIdTecnologia());

        for(Candidato candidato : listaCandidato){
            for(CandidatoPorTecnologia candidatoPorTecnologia : candidatoPorTecnologiaList ){
                if(candidatoPorTecnologia.getCandidato().getIdCandidato()==candidato.getIdCandidato()){
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
}
