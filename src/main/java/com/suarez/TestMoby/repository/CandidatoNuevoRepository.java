package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.CandidatoNuevo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoNuevoRepository extends JpaRepository<CandidatoNuevo, Integer> {

    boolean existsByDocumento(String documento);
}
