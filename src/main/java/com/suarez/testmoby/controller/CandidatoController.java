package com.suarez.testmoby.controller;

import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CrearCandidatoDto;
import com.suarez.testmoby.services.CandidatoNuevoService;
import com.suarez.testmoby.services.CandidatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.extern.java.Log;
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

@Log
@RequestMapping(value = "/api/candidato")
@RestController
@Api(tags = "candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private CandidatoNuevoService candidatoNuevoService;


    @PostMapping(value = "/candidato/crear")
    @ApiOperation(value = "Crear Candidato", notes = "Servicio para crear un candidato nuevo")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidato creado correctamente"),
    @ApiResponse(code = 400, message = "Solicitud invalida")})
    public ResponseEntity<Boolean> crearCandidato(@RequestBody CrearCandidatoDto dto) throws ParseException {
        return new ResponseEntity<>(candidatoNuevoService.guardar(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminarCandidato/{idCandidato}")
    @ApiOperation(value = "Eliminar Candidato", notes = "Servicio para eliminar un candidato")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidato eliminado correctamente"),
            @ApiResponse(code = 404, message = "Candidato no encontrado")})
    public ResponseEntity<Integer> eliminarCandidato(@PathVariable @NonNull Integer idCandidato) {
        return new ResponseEntity<>(candidatoService.actualizarEstadoDeCandidato(idCandidato).getIdCandidato(), HttpStatus.OK);
    }

    @GetMapping(value = "/listarCandidatos/{tecnologia}")
    @ApiOperation(value = "Listar Candidato", notes = "Servicio para listar candidatos segun determinada tecnologia")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidatos listados correctamente"),
            @ApiResponse(code = 404, message = "Candidatos no encontrados")})
    public ResponseEntity<List<CandidatoDto>> buscarCandidato(@RequestParam String tecnologia) {
        return new ResponseEntity<>(candidatoService.findByTecnologia(tecnologia),HttpStatus.OK);
    }

   
}
