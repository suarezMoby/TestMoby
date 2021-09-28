package com.suarez.TestMoby.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoNuevoRepository extends JpaRepository<CandidatoPorTecnologia, Integer> {

    boolean existsByDocumento(String documento);
}
