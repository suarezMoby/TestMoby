package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoPorTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia,Integer> {
}
