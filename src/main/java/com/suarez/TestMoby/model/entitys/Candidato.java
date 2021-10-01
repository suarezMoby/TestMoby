package com.suarez.TestMoby.model.entitys;

import com.suarez.TestMoby.model.enums.Tipo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="candidato")
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidato")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "tipo")
    private Tipo tipo;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "decha_nacimiento")
    private Date fechaNacimiento;

}
