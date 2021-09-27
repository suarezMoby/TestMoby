package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoPorTecnologia extends JpaRepository<CandidatoPorTecnologia, Integer> {


}
