package com.suarez.TestMoby.repository;


import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import com.suarez.TestMoby.model.entitys.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia,Integer> {


    @Query(value = "SELECT * FROM candidatosPorTecnologia WHERE id_tecnologia = ?1",nativeQuery = true)
    List<CandidatoPorTecnologia>candidatosByTecnologia(Integer idTecnologia);
}
