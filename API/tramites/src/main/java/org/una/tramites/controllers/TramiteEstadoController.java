package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.TramiteEstadoDTO;
import org.una.tramites.entities.TramiteEstado;
import org.una.tramites.services.ITramiteEstadoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tramites estados")
@Api(tags = {"Tramites Estados"})
public class TramiteEstadoController {
    @Autowired
    private ITramiteEstadoService traService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los tramites estados", response = TramiteEstadoDTO.class, responseContainer = "List", tags = "Tramites Estados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TramiteEstado>> result = traService.findAll();
            if (result.isPresent()) {
                List<TramiteEstadoDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), TramiteEstadoDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un tipo de tramite a travez de su identificador unico", response = TramiteEstadoDTO.class, tags = "Tramites Estados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TramiteEstado> tramiteFound = traService.findById(id);
            if (tramiteFound.isPresent()) {
                TramiteEstadoDTO tramiteDTO = MapperUtils.DtoFromEntity(tramiteFound.get(), TramiteEstadoDTO.class);
                return new ResponseEntity<>(tramiteDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TramiteEstado tramite) {
        try {
            TramiteEstado usuarioCreated = traService.create(tramite);
            TramiteEstadoDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioCreated, TramiteEstadoDTO.class);
            return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TramiteEstado traModified) {
        try {
            Optional <TramiteEstado> traUpdated = traService.update(traModified, id);
            if (traUpdated.isPresent()) {
                TramiteEstadoDTO traDto = MapperUtils.DtoFromEntity(traUpdated.get(), TramiteEstadoDTO.class);
                return new ResponseEntity<>(traDto, HttpStatus.OK);

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
            traService.delete(id);
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
            traService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
