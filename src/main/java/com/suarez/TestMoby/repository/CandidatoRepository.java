package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.Candidato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

    @Query(value = "SELECT * FROM candidato JOIN candidato_x_tecnologia USING(id_candidato_x_tecnologia) " +
            "JOIN tecnologias USING(id_tecnologia)" +
            "where tecnologias.nombre =?1", nativeQuery = true)
    List<Candidato> findByTecnologia(String tecno);
}
