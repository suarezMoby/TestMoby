package com.suarez.TestMoby.services.implement;

import com.suarez.TestMoby.services.CandidatoService;
import org.springframework.stereotype.Service;

@Service
public class CandidatoServiceImplement implements CandidatoService {

  /*  @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    TecnologiaService tecnologiaService;

    @Autowired
    CandidatoXTecnologiaService candidatoXTecnologiaService;*/

    /*@Override
    public List<CandidatoDto> findByTecnologia(String tecnologia) {
       List<Candidato> listaCandidato = (List<Candidato>) candidatoRepository.findAll();
        List<CandidatoDto> listaCandidatoDto = new ArrayList<>();
        Tecnologia tecnologia1 = tecnologiaService.findByName(tecnologia);
        List<CandidatoPorTecnologia> candidatoPorTecnologiaList = candidatoXTecnologiaService.candidatosByTecnologia(tecnologia1.getId());

        for(Candidato candidato : listaCandidato){
            for(CandidatoPorTecnologia candidatoPorTecnologia : candidatoPorTecnologiaList ){
                if(candidatoPorTecnologia.getCandidato().getId()==candidato.getId()){
                    CandidatoDto candidatoDto = CandidatoDto.builder()
                            .id(candidato.getId())
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
    }*/
}
