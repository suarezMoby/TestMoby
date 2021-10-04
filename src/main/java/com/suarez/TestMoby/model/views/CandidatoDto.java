package com.suarez.TestMoby.model.views;

import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;
import com.suarez.TestMoby.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidatoDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private Tipo tipo;
    private Integer dni;
    private Date fechaNacimiento;
    private CandidatoPorTecnologia candidatoPorTecnologia;

    private List<Tecnologia> tecnologias;

}
