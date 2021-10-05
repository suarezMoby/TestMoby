package com.suarez.TestMoby.model.entitys;

import com.suarez.TestMoby.model.enums.Tipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "candidato_nuevo")
public class CandidatoNuevo implements Serializable {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato_nuevo", nullable = false)
    private Integer idCandidatoNuevo;

    private String nombre;

    private String apellido;

    private Tipo tipo;

    private String numeroDoc;

    private Date fechaDeNacimiento;


    @Builder
    public CandidatoNuevo(Integer idCandidatoNuevo, String nombre, String apellido, Tipo tipo, String numeroDoc,
                          Date fechaDeNacimiento) {
        this.idCandidatoNuevo = idCandidatoNuevo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.numeroDoc = numeroDoc;
        this.fechaDeNacimiento = fechaDeNacimiento;

    }
}