package com.suarez.TestMoby.model.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CandidatoPorTecnologia {

    private Integer idCandidato;
    private Integer idTenologia;
    private Integer aniosDeExperiencia;
}
