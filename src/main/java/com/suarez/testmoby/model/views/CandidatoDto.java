package com.suarez.testmoby.model.views;

import com.suarez.testmoby.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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
    private String dni;
    private Date fechaNacimiento;
    private Integer estado;

}
