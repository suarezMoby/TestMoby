package com.suarez.TestMoby.model.entitys;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "version")
    private String version;

}
