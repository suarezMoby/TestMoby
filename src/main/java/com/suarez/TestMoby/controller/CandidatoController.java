package com.suarez.TestMoby.controller;

import com.suarez.TestMoby.model.entitys.Candidato;
import com.suarez.TestMoby.model.views.CandidatoDto;
import com.suarez.TestMoby.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/candidato")
@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping(value = "/listarCandidatos/{tecnologia}")
    public ResponseEntity<List<CandidatoDto>> buscarCandidato(@RequestParam String tecnologia) {
        return new ResponseEntity<>(candidatoService.findByTecnologia(tecnologia),HttpStatus.OK);
    }
}
