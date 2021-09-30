package com.suarez.TestMoby.controller;

import com.suarez.TestMoby.model.entities.Candidato;
import com.suarez.TestMoby.service.CandidatoNuevoService;
import com.suarez.TestMoby.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/api/candidato")
@RestController
public class CandidatoController {

   /* @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private CandidatoNuevoService candidatoNuevoService;

    @PostMapping(value = "/candidato/crear")
    public ResponseEntity<Boolean> crearCandidato(@RequestBody CrearCandidatoDto dto) throws ParseException {
        return new ResponseEntity<>(candidatoNuevoService.guardar(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/listarCandidatos/{tecnologia}")
    public ResponseEntity<Candidato>buscarCandidato(@RequestParam String tecnologia){
        candidatoService.getCandidatosPorTecnologia(tecnologia);
        return new ResponseEntity<>(HttpStatus.OK);
    }
*/
}
