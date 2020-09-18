package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.services.ITramiteTipoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tramites_tipos")
@Api(tags = {"Tramites Tipos"})
public class TramiteTipoController {
    @Autowired
    private ITramiteTipoService tramitestiposService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los tramites tipos", response = TramiteTipoDTO.class, responseContainer = "List", tags = "Tramites Tipos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TramiteTipo>> result = tramitestiposService.findAll();
            if (result.isPresent()) {
                List< TramiteTipoDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(),TramiteTipoDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene la lista de tramites tipos a travez de su identificador unico", response = TramiteTipoDTO.class, tags = "Tramites Tipos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TramiteTipo> tramitestiposFound = tramitestiposService.findById(id);
            if (tramitestiposFound.isPresent()) {
                TramiteTipoDTO tramitestiposDto = MapperUtils.DtoFromEntity(tramitestiposFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramitestiposDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            tramitestiposService.delete(id);
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
            tramitestiposService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
