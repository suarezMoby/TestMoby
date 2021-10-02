
package com.suarez.TestMoby.model.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_por_tecnologia")
public class CandidatoPorTecnologia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato_por_tecnologia")
    private Integer idCandidatoPorTecnologia;

    @JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name = "id_tecnologia", referencedColumnName = "id_tecnologia")
    @ManyToOne
    private Tecnologia tecnologia;

    @Column(name = "anios_experiencia")
    private Integer aniosExperiencia;

}
