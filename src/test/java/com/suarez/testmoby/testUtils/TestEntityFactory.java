package com.suarez.testmoby.testUtils;

import com.google.gson.Gson;
import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.enums.Tipo;
import com.suarez.testmoby.model.views.CandidatoDto;
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
                .nombreTecnologia("java")
                .version("8")
                .build();
    }

    /** TecnologiaDto con Id **/
    public static TecnologiaDto getTecnologiaDtoConId(){
        return TecnologiaDto.builder()
                .id(1)
                .nombre("java")
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

    /** TecnologiaDto con Id Json **/
    public static String getTecnologiaDtoConIdJson(){
        return new Gson().toJson(getTecnologiaDtoConId());
    }

    /** TecnologiaDto con Id modificado Json **/
    public static String getTecnologiaDTOConIdModificadoJson(){
        return new Gson().toJson(getTecnologiaDtoConIdModificado());
    }

    /** TecnologiaDto con Id modificado **/
    public static TecnologiaDto getTecnologiaDtoConIdModificado(){
        return TecnologiaDto.builder()
                .id(2)
                .nombre("Java")
                .version("9")
                .build();
    }

    /** CandidatoDto con Id **/
    public static CandidatoDto getCandidatoDtoConId(){
        return CandidatoDto.builder()
                .id(1)
                .nombre("Danilo")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .fechaNacimiento(null)
                .build();
    }

    /** Candidato con Id **/
    public static Candidato getCandidatoConId(){
        return Candidato.builder()
                .idCandidato(1)
                .nombre("Danilo")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .fechaNacimiento(null)
                .build();
    }
}
