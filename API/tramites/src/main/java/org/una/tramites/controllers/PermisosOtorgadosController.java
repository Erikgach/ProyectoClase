package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.PermisoDTO;
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.entities.Usuario;
import org.una.tramites.services.IPermisoOtorgadoService;
import org.una.tramites.services.IPermisoService;
import org.una.tramites.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisosOtorgados")
@Api(tags = {"Permisos Otorgados"})
public class PermisosOtorgadosController {
    @Autowired
    private IPermisoOtorgadoService permisoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un permiso otorgado por id", response = PermisoOtorgadoDTO.class, responseContainer = "Elemento", tags = "Permisos Otorgados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<PermisoOtorgado> result = permisoService.findById(id);
            if (result.isPresent()) {
                PermisoOtorgadoDTO permisoDto = MapperUtils.DtoFromEntity(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Obtiene una lista de todos los permisos permisos otorgados a un usuario", response = PermisoOtorgadoDTO.class, responseContainer = "List",  tags = "Permisos Otorgados")
    public ResponseEntity<?> findByUsuarioId(@PathVariable(value = "id") Long id) {
        try {
            Optional<List<PermisoOtorgado>> result = permisoService.findByUsuarioId(id);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/permiso/{id}")
    @ApiOperation(value = "Obtiene un permiso por el id", response = PermisoOtorgadoDTO.class, responseContainer = "List",  tags = "Permisos Otorgados")
    public ResponseEntity<?> findByPermisoId(@PathVariable(value = "id") Long id) {
        try {
            Optional<List<PermisoOtorgado>> result = permisoService.findByPermisoId(id);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{id}/estado{term}")
    @ApiOperation(value = "Obtiene una lista de todos los permisos activos otorgados a un usuario", response = PermisoOtorgadoDTO.class, responseContainer = "List",  tags = "Permisos Otorgados")
    public ResponseEntity<?> findByUsuarioIdAndEstado(@PathVariable(value = "id") Long id, @PathVariable(value = "term") Boolean term) {
        try {
            Optional<List<PermisoOtorgado>> result = permisoService.findByUsuarioIdAndEstado(id,term);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/permiso/{id}/estado{term}")
    @ApiOperation(value = "Obtiene una lista de todos los permisos por id que esten activos", response = PermisoOtorgadoDTO.class, responseContainer = "List",  tags = "Permisos Otorgados")
    public ResponseEntity<?> findByPermisoIdAndEstado(@PathVariable(value = "id") Long id, @PathVariable(value = "term") Boolean term) {
        try {
            Optional<List<PermisoOtorgado>> result = permisoService.findByPermisoIdAndEstado(id,term);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/startDate/{start}/endDate{end}")
    @ApiOperation(value = "Obtiene una lista de todos los permisos que esten entre fechas de registro", response = PermisoOtorgadoDTO.class, responseContainer = "List",  tags = "Permisos Otorgados")
    public ResponseEntity<?> findByEntreFechasDeRegistro(@PathVariable(value = "start") Date start, @PathVariable(value = "end") Date end) {
        try {
            Optional<List<PermisoOtorgado>> result = permisoService.findByFechaRegistroBetween(start,end);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar los datos de un permiso otorgado por ID", response = UsuarioDTO.class,  tags = "Permisos Otorgados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PermisoOtorgado permisoModified) {
        try {
            Optional<PermisoOtorgado> usuarioUpdated = permisoService.update(permisoModified, id);
            if (usuarioUpdated.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(usuarioUpdated.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar permiso otorgado por ID", response = PermisoOtorgadoDTO.class,  tags = "Permisos Otorgados")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            permisoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los permisos otorgados", response = PermisoOtorgadoDTO.class,  tags = "Permisos Otorgados")
    public ResponseEntity<?> deleteAll() {
        try {
            permisoService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
