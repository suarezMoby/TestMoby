package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {
}
