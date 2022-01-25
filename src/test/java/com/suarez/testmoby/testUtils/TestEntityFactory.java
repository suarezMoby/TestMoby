package com.suarez.testmoby.testUtils;

import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.views.TecnologiaDto;

import java.util.LinkedList;
import java.util.List;

public class TestEntityFactory {
    /** TecnologiaDto **/
    public static TecnologiaDto getTecnologiaDtoSinId(){
        return TecnologiaDto.builder()
                .nombre("Java")
                .version("8")
                .build();
    }
    /** Tecnologia sin Id **/
    public static Tecnologia getTecnologiaSinId(){
        return Tecnologia.builder()
                .nombreTecnologia("Java")
                .version("8")
                .build();
    }

    /** Tecnologia con Id **/
    public static Tecnologia getTecnologiaConId(){
        return Tecnologia.builder()
                .idTecnologia(1)
                .nombreTecnologia("Java")
                .version("8")
                .build();
    }

    /** TecnologiaDto con Id **/
    public static TecnologiaDto getTecnologiaDtoConId(){
        return TecnologiaDto.builder()
                .id(1)
                .nombre("Java")
                .version("8")
                .build();
    }

    /** Lista de Tecnologia **/
    public static List<Tecnologia> getListaTecnologias(){
        List<Tecnologia> listaTecnologias = new LinkedList<>();

        listaTecnologias.add(getTecnologiaConId());

        return listaTecnologias;
    }

    /** Lista de TecnologiaDto **/
    public static List<TecnologiaDto> getListaTecnologiasDto(){
        List<TecnologiaDto> listaTecnologiasDTO = new LinkedList<>();

        listaTecnologiasDTO.add(getTecnologiaDtoConId());

        return listaTecnologiasDTO;
    }
}
