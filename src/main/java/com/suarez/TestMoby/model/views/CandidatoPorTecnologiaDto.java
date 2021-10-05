package com.suarez.TestMoby.model.views;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.entitys.Tecnologia;
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
    private Candidato idCandidato;
    private Tecnologia idTecnologia;
    private Integer aniosExperiencia;
}
