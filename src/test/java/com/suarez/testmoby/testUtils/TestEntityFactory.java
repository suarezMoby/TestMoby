package com.suarez.testmoby.testUtils;

import com.google.gson.Gson;
import com.suarez.testmoby.model.entitys.Candidato;
import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.testmoby.model.entitys.Tecnologia;
import com.suarez.testmoby.model.enums.Tipo;
import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CandidatoPorTecnologiaDto;
import com.suarez.testmoby.model.views.CrearCandidatoDto;
import com.suarez.testmoby.model.views.TecnologiaDto;

import java.util.Collections;
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

    /** Candidato con Id Json **/
    public static String getCandidatoConIdJson(){
        return new Gson().toJson(getCandidatoConId());
    }

    /** CandidatoDto con Id Json **/
    public static String getCandidatoDtoConIdJson(){
        return new Gson().toJson(getCandidatoDtoConId());
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
                .tipo(null)
                .fechaNacimiento(null)
                .dni("33102857")
                .estado(1)
                .build();
    }

    /** CandidatoDto con Id **/
    public static CandidatoDto getCandidatoDtoNuevo(){
        return CandidatoDto.builder()
                .id(1)
                .nombre("Carlos")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .fechaNacimiento(null)
                .build();
    }

    /** CandidatoDto sin Id **/
    public static CandidatoDto getCandidatoDtoSinId(){
        return CandidatoDto.builder()
                .nombre("Danilo")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .fechaNacimiento(null)
                .estado(1)
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
                .estado(1)
                .build();
    }

    /** Candidato sin Id **/
    public static Candidato getCandidatoSinId(){
        return Candidato.builder()
                .nombre("Danilo")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .fechaNacimiento(null)
                .estado(1)
                .build();
    }
    /** crearCandidatoDto sin Id **/
    public static CrearCandidatoDto getCrearCandidatoDtoSinId(){
        return CrearCandidatoDto.builder()
                .nombre("Danilo")
                .apellido("Suarez")
                .tipo(Tipo.DNI)
                .dni("33102867")
                .tecnologias(Collections.emptyList())
                .build();
    }



    public static CandidatoPorTecnologiaDto getCandidatoPorTecnologiaDto(){
        return CandidatoPorTecnologiaDto.builder()
                .idCandidatoPorTecnologia(1)
                .candidatoDto(getCandidatoDtoConId())
                .tecnologiaDto(getTecnologiaDtoConId())
                .aniosExperiencia(4)
                .build();
    }

    public static CandidatoDto getCandidatoDtoEditado(){
        return CandidatoDto.builder()
                .id(1)
                .nombre("Natan")
                .apellido("Suarez")
                .tipo(null)
                .fechaNacimiento(null)
                .dni("33102857")
                .build();

    }

    public static String getCandidatoDtoEditadoJson(){return new Gson().toJson(getCandidatoDtoEditado());}

    public static List<CandidatoDto> getListaCandidatosDto(){

        CandidatoDto candidatoDto = getCandidatoDtoConId();

        List<CandidatoDto> candidatoDtoList = new LinkedList<>();

        candidatoDtoList.add(candidatoDto);

        return candidatoDtoList;
    }

    public static List<CandidatoPorTecnologiaDto> getListaCandidatosXTecnologiaDto(){

        CandidatoPorTecnologiaDto candidatoPorTecnologiaDto = getCandidatoPorTecnologiaDto();

        List<CandidatoPorTecnologiaDto> listaCandidatosPorTecnologiaDto = new LinkedList<>();

        listaCandidatosPorTecnologiaDto.add(candidatoPorTecnologiaDto);

        return listaCandidatosPorTecnologiaDto;
    }

    public static CandidatoPorTecnologia getCandidatoXTecnologia(){
        return CandidatoPorTecnologia.builder()
                .idCandidatoPorTecnologia(1)
                .candidato(getCandidatoConId())
                .tecnologia(getTecnologiaConId())
                .build();
    }

    public static List<CandidatoPorTecnologia> getListaCandidatosXTecnologia(){

        CandidatoPorTecnologia candidatoPorTecnologia = getCandidatoXTecnologia();

        List<CandidatoPorTecnologia> listaCandidatosPorTecnologia = new LinkedList<>();

        listaCandidatosPorTecnologia.add(candidatoPorTecnologia);

        return listaCandidatosPorTecnologia;
    }

}
