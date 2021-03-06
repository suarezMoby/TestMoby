package com.suarez.testmoby.controller;

import com.suarez.testmoby.model.views.CandidatoDto;
import com.suarez.testmoby.model.views.CandidatoPorTecnologiaDto;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RequestMapping(value = "/api/candidato")
@RestController
@Api(tags = "candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;


    @PostMapping(value = "/crear")
    @ApiOperation(value = "Crear Candidato", notes = "Servicio para crear un candidato nuevo")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidato creado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida")})
    public ResponseEntity<CandidatoDto> guardar(@RequestBody CandidatoDto candidatoDto) {
        return new ResponseEntity<>(candidatoService.guardar(candidatoDto), HttpStatus.CREATED);
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
    public ResponseEntity<List<CandidatoPorTecnologiaDto>> buscarCandidato(@PathVariable String tecnologia) {
        return new ResponseEntity<>(candidatoService.findByTecnologia(tecnologia), HttpStatus.OK);
    }

    @PostMapping(value = "/editarCandidato")
    @ApiOperation(value = "Editar Candidato", notes = "Servicio para editar un candidato")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidatos editado correctamente"),
            @ApiResponse(code = 404, message = "Candidato no encontrado")})
    public ResponseEntity<CandidatoDto> modificarCandidato(@RequestBody CandidatoDto candidatoDTO) {
        return new ResponseEntity<>(candidatoService.editarCandidato(candidatoDTO), HttpStatus.OK);
    }

}
