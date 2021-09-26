package com.suarez.TestMoby.model;

import com.suarez.TestMoby.model.enums.TipoDocumento;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Candidato {

    @Id
    @Column(name = "id_Candidato")
    private Integer idCandidato;

    @Column(name = "nombre")
    private String nombre;

    @Column
    private String apellido;

    @Column(name = "tipo")
    private TipoDocumento tipo;

    @Column(name = "numero_doc")
    private String numeroDoc;

    @Column(name = "fecha_de_nacimiento")
    private Date FechaDeNacimiento;

    public Candidato() {
    }
}
