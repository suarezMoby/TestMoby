package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.entitys.CandidatoNuevo;
import com.suarez.TestMoby.model.views.CandidatoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoNuevoRepository extends JpaRepository<CandidatoNuevo, Integer> {

    boolean existsByDocumento(String documento);


}
