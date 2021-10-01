package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.entitys.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Integer> {
}
