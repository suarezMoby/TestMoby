package com.suarez.TestMoby.repository;

import com.suarez.TestMoby.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Tecnologia,Long> {
}
