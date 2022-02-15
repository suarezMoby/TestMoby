package com.suarez.testmoby.model.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidatoPorTecnologiaDto {

    private Integer idCandidatoPorTecnologia;
    private CandidatoDto candidatoDto;
    private TecnologiaDto tecnologiaDto;
    private Integer aniosExperiencia;
}
