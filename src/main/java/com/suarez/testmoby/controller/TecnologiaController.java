package com.suarez.testmoby.controller;

import com.suarez.testmoby.model.views.TecnologiaDto;
import com.suarez.testmoby.services.TecnologiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

/*Para Acceder a Swagger hay que ingresar en http://localhost:8080/swagger-ui.htm con el proyecto corriendo*/

@RequestMapping(value = "/api/tecnologia")
@RestController
@Api(tags = "Tecnologia")
public class TecnologiaController {

    @Autowired
    TecnologiaService tecnologiaService;

    @PostMapping(value = "/guardarTecnologia")
    @ApiOperation(value = "Guardar Tecnologia", notes = "Servicio para guardar una tecnologia nueva")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tecnologia guardada correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida")})
    public ResponseEntity<TecnologiaDto> guardarTecnologia(@RequestBody TecnologiaDto tecnologiaDto) {
        return new ResponseEntity<>(tecnologiaService.guardarTecnologia(tecnologiaDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/editarTecnologia")
    @ApiOperation(value = "Editar Tecnologia", notes = "Servicio para editar una tecnologia")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tecnologia editada correctamente"),
            @ApiResponse(code = 404, message = "Tecnologia no encontrada")})
    public ResponseEntity<TecnologiaDto> editarTecnologia(@RequestBody TecnologiaDto tecnologiaDto) {
        return new ResponseEntity<>(tecnologiaService.editarTecnologia(tecnologiaDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarTecnologiaPorId/{idTecnologia}")
    @ApiOperation(value = "Eliminar Tecnologia", notes = "Servicio para eliminar una tecnologia")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Tecnologia eliminada correctamente"),
            @ApiResponse(code = 404, message = "Tecnologia no encontrada")})
    public ResponseEntity eliminarTecnologiaPorId(@PathVariable Integer idTecnologia) {
        tecnologiaService.eliminarTecnologiaPorId(idTecnologia);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/traerTecnologias")
    @ApiOperation(value = "Traer Tecnologias", notes = "Servicio para traer una lista de tecnologias")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Lista obtenida correctamente"),
            @ApiResponse(code = 404, message = "Tecnologia no encontrada")})
    public ResponseEntity<List<TecnologiaDto>> traerTecnologias(){
        return new ResponseEntity<>(tecnologiaService.traerTecnologias(), HttpStatus.OK);
    }
}
