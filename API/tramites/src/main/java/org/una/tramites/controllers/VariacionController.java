package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.VariacionDTO;
import org.una.tramites.entities.Variacion;
import org.una.tramites.services.IVariacionService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/variaciones")
@Api(tags = {"Variaciones"})
public class VariacionController {
    @Autowired
    private IVariacionService variacionesService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las variaciones", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Variacion>> result = variacionesService.findAll();
            if (result.isPresent()) {
                List< VariacionDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(),VariacionDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene la lista de variaciones a travez de su identificador unico", response = VariacionDTO.class, tags = "Variaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Variacion> variacionesFound = variacionesService.findById(id);
            if (variacionesFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionesFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            variacionesService.delete(id);
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
            variacionesService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
