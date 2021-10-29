package com.suarez.testmoby.repository;

import com.suarez.testmoby.model.entitys.CandidatoNuevo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoNuevoRepository extends JpaRepository<CandidatoNuevo, Integer> {




}
