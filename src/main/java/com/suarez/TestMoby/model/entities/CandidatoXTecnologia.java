package com.suarez.TestMoby.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_x_tecnologia")
public class CandidatoXTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato_x_tecnologia")
    private Integer id;

    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name = "id_tecnologia", referencedColumnName = "id_tecnologia")
    @ManyToOne
    private Tecnologia tecnologia;

    @Column(name = "años_de_experiencia")
    private Integer aniosDeExperiencia;


}
