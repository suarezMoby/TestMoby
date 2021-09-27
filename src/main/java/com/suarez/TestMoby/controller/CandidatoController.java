package com.suarez.TestMoby.controller;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.model.entities.Tecnologia;
import com.suarez.TestMoby.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/candidato")
@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping(value = "/crear")
    public ResponseEntity<Candidato>crearCandidato(@RequestBody Candidato candidato){

        candidatoService.guardar(candidato);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/listarCandidatos")
    public ResponseEntity<Candidato>buscarCandidato(@RequestBody String tecnologia){
        candidatoService.getCandidatosPorTecnologia(tecnologia);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
