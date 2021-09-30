package com.suarez.TestMoby.model.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CandidatoPorTecnologiaDto {


    private Integer idCandidato;
    private Integer idTenologia;
    private Integer aniosDeExperiencia;
}
