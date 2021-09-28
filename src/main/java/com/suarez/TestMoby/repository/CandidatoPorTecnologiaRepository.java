package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoPorTecnologiaRepository extends JpaRepository<CandidatoXTecnologia, Integer> {


}
