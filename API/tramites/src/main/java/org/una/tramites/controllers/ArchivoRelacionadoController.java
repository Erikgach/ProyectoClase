package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.ArchivoRelacionadoDTO;
import org.una.tramites.entities.ArchivoRelacionado;
import org.una.tramites.services.IArchivoRelacionadoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/archivos_relacionados")
@Api(tags = {"Archivos Relacionados"})
public class ArchivoRelacionadoController {
    @Autowired
    private IArchivoRelacionadoService archivosrelacionadosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las notas", response = ArchivoRelacionadoDTO.class, responseContainer = "List", tags = "Archivos Relacionados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<ArchivoRelacionado>> result = archivosrelacionadosService.findAll();
            if (result.isPresent()) {
                List<ArchivoRelacionadoDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), ArchivoRelacionadoDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene la lista de archivos relacionados a travez de su identificador unico", response = ArchivoRelacionadoDTO.class, tags = "Archivos Relacionados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<ArchivoRelacionado> archivorelacionaoFound = archivosrelacionadosService.findById(id);
            if (archivorelacionaoFound.isPresent()) {
                ArchivoRelacionadoDTO archivorelacionadoDTO = MapperUtils.DtoFromEntity(archivorelacionaoFound.get(),ArchivoRelacionadoDTO.class);
                return new ResponseEntity<>(archivorelacionadoDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            archivosrelacionadosService.delete(id);
            if (findById(id).getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
        try {
            archivosrelacionadosService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


