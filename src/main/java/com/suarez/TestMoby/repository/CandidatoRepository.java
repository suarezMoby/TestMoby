package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {

/*controlador
    servicio->implementaion
    repositoris*/


}
