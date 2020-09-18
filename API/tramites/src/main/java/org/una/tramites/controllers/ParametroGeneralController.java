package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.ParametroGeneralDTO;
import org.una.tramites.entities.ParametroGeneral;
import org.una.tramites.services.IParametroGeneralService;
import org.una.tramites.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros_generales")
@Api(tags = {"Parametros Generales"})
public class ParametroGeneralController {

    @Autowired
    private IParametroGeneralService paramGenService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Parametros Generales", response = ParametroGeneralDTO.class, responseContainer = "List", tags = "Parametros Generales")
    public @ResponseBody ResponseEntity<?> findAll() {
        try {
            Optional<List<ParametroGeneral>> result = paramGenService.findAll();
            if (result.isPresent()) {
                List<ParametroGeneralDTO> resultDTO = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(resultDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un parametro general  por id", response = ParametroGeneralDTO.class, responseContainer = "Elemento", tags = "Parametros generales")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<ParametroGeneral> result = paramGenService.findById(id);
            if (result.isPresent()) {
                ParametroGeneralDTO parametrogenrealDto = MapperUtils.DtoFromEntity(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{nombre}")
    @ApiOperation(value = "Obtiene los Paremetros Generales segun el nombre", response = ParametroGeneralDTO.class, responseContainer = "List", tags = "Parametros Generales")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre")String nombre) {
        try{
            Optional<List<ParametroGeneral>> result = paramGenService.findByNombre(nombre);
            if(result.isPresent()){
                List<ParametroGeneralDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{valor}")
    @ApiOperation(value = "Obtiene una lista de Parametros Generales segun el valor que guardan", response = ParametroGeneralDTO.class, responseContainer = "List", tags = "Parametros Generales")
    public ResponseEntity<?> findByValor(@PathVariable(value = "valor") String valor){
        try{
            Optional<List<ParametroGeneral>> result = paramGenService.findByValor(valor);
            if(result.isPresent()){
                List<ParametroGeneralDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{descripcion}")
    @ApiOperation(value = "Obtiene una lista de Parametros Generales segun su descripcion", response = ParametroGeneralDTO.class, responseContainer = "List", tags = "Parametros Generales")
    public ResponseEntity<?> findByDescripcion(@PathVariable(value = "descripcion")String descripcion){
        try{
            Optional<List<ParametroGeneral>> result = paramGenService.findByDescripcion(descripcion);
            if(result.isPresent()){
                List<ParametroGeneralDTO> resultDto = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(resultDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/startDate/{start}/endDate{end}")
    @ApiOperation(value = "Obtiene una lista de todos los parametros generales que esten entre fechas de registro", response = ParametroGeneralDTO.class, responseContainer = "List",  tags = "Parametros Generales")
    public ResponseEntity<?> findByEntreFechasDeRegistro(@PathVariable(value = "start") Date start, @PathVariable(value = "end") Date end) {
        try {
            Optional<List<ParametroGeneral>> result = paramGenService.findByFechaRegistroBetween(start,end);
            if (result.isPresent()) {
                List<ParametroGeneralDTO> parametrogeneralDto = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(parametrogeneralDto, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody ParametroGeneral parametrogeneral) {
        try {
            ParametroGeneral parametrogeneneralCreated = paramGenService.create(parametrogeneral);
            ParametroGeneralDTO parametrogeneralDto = MapperUtils.DtoFromEntity(parametrogeneneralCreated, ParametroGeneralDTO.class);
            return new ResponseEntity<>(parametrogeneralDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar los datos de un parametro por ID", response = ParametroGeneralDTO.class, tags = "Parametros generales")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroGeneral parametrogeneralModified) {
        try {
            Optional<ParametroGeneral> parametrogeneralUpdated = paramGenService.update(parametrogeneralModified, id);
            if (parametrogeneralUpdated.isPresent()) {
                ParametroGeneralDTO parametrogeneralDto = MapperUtils.DtoFromEntity(parametrogeneralUpdated.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(parametrogeneralDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar parametro por ID", response = ParametroGeneralDTO.class,  tags = "Parametros Generales")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            paramGenService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los parametros", response = ParametroGeneralDTO.class,  tags = "Parametros Generales")
    public ResponseEntity<?> deleteAll() {
        try {
            paramGenService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
