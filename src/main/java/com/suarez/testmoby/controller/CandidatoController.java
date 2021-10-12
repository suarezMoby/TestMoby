package com.suarez.testmoby.controller;

import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CrearCandidatoDto;
import com.suarez.testmoby.services.CandidatoNuevoService;
import com.suarez.testmoby.services.CandidatoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


@RequestMapping(value = "/api/candidato")
@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private CandidatoNuevoService candidatoNuevoService;


    @PostMapping(value = "/crear")
    public ResponseEntity<Boolean> crearCandidato(@RequestBody CrearCandidatoDto dto) throws ParseException {
        return new ResponseEntity<>(candidatoNuevoService.guardar(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminarCandidato/{idCandidato}")
    public ResponseEntity<Integer> eliminarCandidato(@PathVariable @NonNull Integer idCandidato) {
        return new ResponseEntity<>(candidatoService.actualizarEstadoDeCandidato(idCandidato).getIdCandidato(), HttpStatus.OK);
    }

    @GetMapping(value = "/listarCandidatos/{tecnologia}")
    public ResponseEntity<List<CandidatoDto>> buscarCandidato(@RequestParam String tecnologia) {
        return new ResponseEntity<>(candidatoService.findByTecnologia(tecnologia),HttpStatus.OK);
    }

   
}
