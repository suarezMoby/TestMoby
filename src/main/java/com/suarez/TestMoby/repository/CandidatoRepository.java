package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
}
