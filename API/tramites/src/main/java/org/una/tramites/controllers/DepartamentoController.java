package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.DepartamentoDTO;
import org.una.tramites.dto.NotaDTO;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.Nota;
import org.una.tramites.entities.Usuario;
import org.una.tramites.services.IDepartamentoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Departamentos"})
public class DepartamentoController {
    @Autowired
    private IDepartamentoService departamentoService;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Departamento departamento) {
        try {
            Departamento departamentoCreated = departamentoService.create(departamento);
            DepartamentoDTO departamentoDTO = MapperUtils.DtoFromEntity(departamentoCreated, DepartamentoDTO.class);
            return new ResponseEntity<>(departamentoDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar usuario por ID", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            departamentoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar los datos de un usuario por ID", response = UsuarioDTO.class, tags = "departamentos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Departamento departamentoModified) {
        try {
            Optional<Departamento> departamentoUpdated = departamentoService.update(departamentoModified, id);
            if (departamentoUpdated.isPresent()) {
                DepartamentoDTO departamentoDto = MapperUtils.DtoFromEntity(departamentoUpdated.get(), DepartamentoDTO.class);
                return new ResponseEntity<>(departamentoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los departamentos", response = NotaDTO.class, responseContainer = "List", tags = "Departamentos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Departamento>> result = departamentoService.findAll();
            if (result.isPresent()) {
                List<DepartamentoDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), DepartamentoDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/estado/{term}")
    @ApiOperation(value = "Obtiene una lista de todos los departamentos activos", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") Boolean term) {
        try {
            Optional<List<Departamento>> result = departamentoService.findByEstado(term);
            if (result.isPresent()) {
                List<DepartamentoDTO> departamentosDTO = MapperUtils.DtoListFromEntityList(result.get(), DepartamentoDTO.class);
                return new ResponseEntity<>(departamentosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
