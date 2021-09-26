package com.suarez.TestMoby.model.entities;

import com.suarez.TestMoby.model.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato")
public class Candidato {

    @Id
    @Column(name = "id_Candidato")
    private Integer idCandidato;

    private String nombre;

    private String apellido;

    private TipoDocumento tipo;

    @Column(name = "numero_doc")
    private String numeroDoc;

    @Column(name = "fecha_de_nacimiento")
    private Date FechaDeNacimiento;


}
