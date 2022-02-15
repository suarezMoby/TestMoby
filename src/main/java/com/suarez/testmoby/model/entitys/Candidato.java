package com.suarez.testmoby.model.entitys;

import com.suarez.testmoby.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidato")
public class Candidato implements Serializable {

  private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidato")
    private Integer idCandidato;

    @NotEmpty(message = "Debe ingresar Un nombre")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "Debe ingresar Un apellido")
    @Column(name = "apellido")
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Tipo tipo;

    @Size(min = 8, max = 8)
    @NotEmpty(message = "Es obligatorio ingresar el DNI")
    @Column(name = "dni")
    private String dni;

    @Past
    @NotEmpty(message = "Debe ingresar una fecha de nacimiento y debe ser menor a la fecha actual")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "estado")
    private int estado;

}
