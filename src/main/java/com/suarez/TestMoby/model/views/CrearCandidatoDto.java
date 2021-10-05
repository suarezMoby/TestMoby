package com.suarez.TestMoby.model.views;


import com.suarez.TestMoby.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CrearCandidatoDto {

    private String nombre;
    private String apellido;
    private Tipo tipo;
    private String dni;
    private Date fechaDeNacimiento;

    List<TecnologiaDto> tecnologias;
}

