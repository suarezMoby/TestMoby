package com.suarez.testmoby.repository;


import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia, Integer> {


}
