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
@AllArgsConstructor
@Table(name = "candidatos_nueva")
public class CandidatoNuevo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nombre;

    private String apellido;

    private Tipo tipo;

    private String numeroDoc;

    private Date fechaDeNacimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Builder
    public CandidatoNuevo(Integer id, String nombre, String apellido, Tipo tipo, String numeroDoc, String documento, Date fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.numeroDoc = numeroDoc;
        this.fechaDeNacimiento = fechaDeNacimiento;

    }
}