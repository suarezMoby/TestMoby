package com.suarez.testmoby.repository;

import com.suarez.testmoby.model.entitys.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

    @Query(value = "INSERT INTO candidato ('nombre', 'apellido', 'tipo', 'dni', 'fecha_nacimiento')" +
            "VALUE ?1%",nativeQuery = true)
    Candidato createCandidato(Candidato candidato);

    @Query(value ="UPDATE candidato  WHERE candidato.id_candidato LIKE ?1% ", nativeQuery = true)
    Candidato actualizarEstadoDeCandidato(Integer id);

    
}
