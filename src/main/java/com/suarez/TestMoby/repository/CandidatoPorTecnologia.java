package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoPorTecnologia extends JpaRepository<CandidatoPorTecnologia,Integer> {

    @Query(value = "SELECT " +
            "candidato.nombre" +
            "FROM candidato" +
            "JOIN candidato_x_tecnologia USING(id_candidato_x_tecnologia)" +
            "JOIN tecnologias USING(id_tecnologia)" +
            "where tecnologias.nombre = 'java'", nativeQuery = true)
    List<CandidatoXTecnologia> buscarTecnologia(String tecno);
}
