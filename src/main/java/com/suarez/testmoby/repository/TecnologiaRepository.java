package com.suarez.testmoby.repository;

import com.suarez.testmoby.model.entitys.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Integer> {


    @Query(value ="SELECT * FROM tecnologia  where tecnologia.nombre LIKE '?1%' && tecnologia.nombre LIKE '%?1'",nativeQuery = true)
    Tecnologia findByName(String nombre);
}
