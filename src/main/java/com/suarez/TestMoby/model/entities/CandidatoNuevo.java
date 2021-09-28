package com.suarez.TestMoby.model.entities;

import com.suarez.TestMoby.model.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatos_nueva")
public class CandidatoNuevo implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer idCandidato;

    private String nombre;

    private String apellido;

    private TipoDocumento tipo;

    private String numeroDoc;

    private Date fechaDeNacimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Builder
    public CandidatoNuevo(Integer id, String nombre, String apellido, TipoDocumento tipo,String numeroDoc, String documento,Date fechaDeNacimiento)
    {
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo=tipo;
        this.numeroDoc=numeroDoc;
        this.fechaDeNacimiento=fechaDeNacimiento;

    }

}
