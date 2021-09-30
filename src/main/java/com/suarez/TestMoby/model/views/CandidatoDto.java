package com.suarez.TestMoby.model.views;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.suarez.TestMoby.model.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CandidatoDto {
    @Id
    @Column(name = "id_candidato", nullable = false)
    private Long idCandidato;

    private Integer id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipo;
    private String dni;
    private Date fechaDeNacimiento;
    private Integer aniosDeExperiencia;

    List<TecnologiaDto> tecnologias;




}
