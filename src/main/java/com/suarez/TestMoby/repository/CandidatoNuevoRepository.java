package com.suarez.TestMoby.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoNuevoRepository extends JpaRepository<CandidatoPorTecnologiaRepository, Integer> {

    boolean existsByDocumento(String documento);
}
