package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.PermisoDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.services.IPermisoService;
import org.una.tramites.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisos")
@Api(tags = {"Permisos"})
public class PermisosController {
    @Autowired
    private IPermisoService permisoService;

    @GetMapping("/estado/{term}")
    @ApiOperation(value = "Obtiene una lista de todos los permisos por estado", response = PermisoDTO.class, responseContainer = "List", tags = "Permisos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") Boolean term) {
        try {
            Optional<List<Permiso>> result = permisoService.findByEstado(term);
            if (result.isPresent()) {
                List<PermisoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un permiso por id de permiso ", response = PermisoDTO.class, responseContainer = "Elemento", tags = "Permisos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Permiso> result = permisoService.findById(id);
            if (result.isPresent()) {
                PermisoDTO permisoDto = MapperUtils.DtoFromEntity(result.get(), PermisoDTO.class);
                return new ResponseEntity<>(result, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody Permiso permiso) {
        try {
            Permiso permisoCreated = permisoService.create(permiso);
            PermisoDTO permisoDto = MapperUtils.DtoFromEntity(permisoCreated, PermisoDTO.class);
            return new ResponseEntity<>(permisoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar los datos de un permiso por ID", response = PermisoDTO.class, tags = "Permisos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Permiso permisoModified) {
        try {
            Optional<Permiso> permisoUpdated = permisoService.update(permisoModified, id);
            if (permisoUpdated.isPresent()) {
                PermisoDTO permisoDto = MapperUtils.DtoFromEntity(permisoUpdated.get(), PermisoDTO.class);
                return new ResponseEntity<>(permisoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar permiso por ID", response = PermisoDTO.class, tags = "Permisos")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            permisoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Se eliminan todos los permisos", response = PermisoDTO.class, tags = "Permisos")
    public ResponseEntity<?> deleteAll() {
        try {
            permisoService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
