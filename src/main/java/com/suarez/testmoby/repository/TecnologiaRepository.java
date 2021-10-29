package com.suarez.testmoby.repository;

import com.suarez.testmoby.model.entitys.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TecnologiaRepository extends JpaRepository<Tecnologia,Integer> {


}
