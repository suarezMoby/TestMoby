package com.suarez.TestMoby.model.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TecnologiaDto {

    private Integer idTecnologia;
    private String nombre;
    private String version;

}
