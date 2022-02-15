package com.suarez.testmoby.repository;


import com.suarez.testmoby.model.entitys.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia, Integer> {

    @Query(value = "SELECT ct.id_candidato_x_tecnologia, ct.id_candidato, ct.id_tecnologia, ct.anios_experiencia"
            + " FROM candidato_x_tecnologia ct"
            + " INNER JOIN tecnologia ON ct.id_tecnologia = tecnologia.id_tecnologia"
            + " WHERE tecnologia.nombre LIKE ?1", nativeQuery = true)
    List<CandidatoPorTecnologia> buscarCandidatosXTecnologiaXTecnologia(String nombreTecnologia);
}
