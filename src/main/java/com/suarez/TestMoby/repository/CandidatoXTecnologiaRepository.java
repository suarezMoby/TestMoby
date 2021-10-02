package com.suarez.TestMoby.repository;


import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia,Integer> {
}
