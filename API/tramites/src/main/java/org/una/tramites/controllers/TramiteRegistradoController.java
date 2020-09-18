package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.TramiteRegistradoDTO;
import org.una.tramites.entities.TramiteRegistrado;
import org.una.tramites.services.ITramiteRegistradoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tramites_registrados")
@Api(tags = {"Tramites Registrados"})
public class TramiteRegistradoController {

    @Autowired
    private ITramiteRegistradoService TramiteRegistradoService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los tramites registrados", response = TramiteRegistradoDTO.class, responseContainer = "List", tags = "Tramites Registrados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TramiteRegistrado>> result = TramiteRegistradoService.findAll();
            if (result.isPresent()) {
                List<TramiteRegistradoDTO> tramitesDTO = MapperUtils.DtoListFromEntityList(result.get(), TramiteRegistradoDTO.class);
                return new ResponseEntity<>(tramitesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un tramite registrado a travez de su identificador unico", response = TramiteRegistradoDTO.class, tags = "Tramites Registrados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TramiteRegistrado> tramitesFound = TramiteRegistradoService.findById(id);
            if (tramitesFound.isPresent()) {
                TramiteRegistradoDTO tramitesDTO = MapperUtils.DtoFromEntity(tramitesFound.get(), TramiteRegistradoDTO.class);
                return new ResponseEntity<>(tramitesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TramiteRegistrado tramites) {
        try {
            TramiteRegistrado tramitesCreated = TramiteRegistradoService.create(tramites);
            TramiteRegistradoDTO tramitesDto = MapperUtils.DtoFromEntity(tramitesCreated, TramiteRegistradoDTO.class);
            return new ResponseEntity<>(tramitesDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TramiteRegistrado tramitesModified) {
        try {
            Optional<TramiteRegistrado> tramitesUpdated = TramiteRegistradoService.update(tramitesModified, id);
            if (tramitesUpdated.isPresent()) {
                TramiteRegistradoDTO tramitesDto = MapperUtils.DtoFromEntity(tramitesUpdated.get(), TramiteRegistradoDTO.class);
                return new ResponseEntity<>(tramitesDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            TramiteRegistradoService.delete(id);
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
            TramiteRegistradoService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
