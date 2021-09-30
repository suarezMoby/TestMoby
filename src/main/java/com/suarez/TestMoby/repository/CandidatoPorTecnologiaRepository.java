package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoPorTecnologiaRepository extends JpaRepository<CandidatoXTecnologia, Integer> {


}
