package com.suarez.TestMoby.model.entities;

import com.suarez.TestMoby.model.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Candidato")
    private Integer idCandidato;


    private String nombre;


    private String apellido;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo;

    @Column(name = "numero_doc")
    private String numeroDoc;

    @Column(name = "fecha_de_nacimiento")
    private Date fechaDeNacimiento;




}
