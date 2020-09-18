package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.entities.Usuario;
import org.una.tramites.services.ITransaccionService;
import org.una.tramites.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})
public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionService;

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Obtiene una lista de transacciones de acuerdo al permiso", response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findByPermisosOtorgadosId(@PathVariable(value = "id") Long id ) {
        try {
            Optional<List<Transaccion>> result = transaccionService.findByPermisoOtorgadoId(id);
            if (result.isPresent()) {
                List<TransaccionDTO> transaccionesDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una transaccion de acuerdo al id", response = TransaccionDTO.class, responseContainer = "Element", tags = "Transacciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Transaccion> transaccionFound = transaccionService.findById(id);
            if (transaccionFound.isPresent()) {
                TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("permiso/{id}/start{startDate}/end{endDate}")
    @ApiOperation(value = "Obtiene una lista de  transacciones con id de permiso y fecha de registro", response = TransaccionDTO.class, responseContainer = "Lista", tags = "Transacciones")
    public ResponseEntity<?> findByPermisoAndFechaRegistro(@PathVariable(value = "id") Long id, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> result = transaccionService.findByPermisoIdAndFechaRegistroBetween(id,startDate,endDate);
            if (result.isPresent()) {
                List<TransaccionDTO> transaccionesDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("objeto/{obj}/start{startDate}/end{endDate}")
    @ApiOperation(value = "Obtiene una lista de  transacciones de un objeto y su fecha de registro", response = TransaccionDTO.class, responseContainer = "Lista", tags = "Transacciones")
    public ResponseEntity<?> findByObjetoAndFechaRegistroBetween(@PathVariable(value = "obj") String obj, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> result = transaccionService.findByObjetoAndFechaRegistroBetween(obj,startDate,endDate);
            if (result.isPresent()) {
                List<TransaccionDTO> transaccionesDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/start{startDate}/end{endDate}")
    @ApiOperation(value = "Obtiene una lista de  transacciones entre fechas de registro", response = TransaccionDTO.class, responseContainer = "Lista", tags = "Transacciones")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> result = transaccionService.findByFechaRegistroBetween(startDate,endDate);
            if (result.isPresent()) {
                List<TransaccionDTO> transaccionesDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionesDTO, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody Transaccion transaccion) {
        try {
            Transaccion transaccionCreated = transaccionService.create(transaccion);
            TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
            return new ResponseEntity<>(transaccionDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
