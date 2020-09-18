package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.dto.AuthenticationResponse;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Usuario;
import org.una.tramites.services.IUsuarioService;
import org.una.tramites.utils.MapperUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Usuario>> result = usuarioService.findAll();
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un usuario de acuerdo al numero de cedula", response = UsuarioDTO.class, responseContainer = "Element", tags = "Usuarios")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Usuario> usuarioFound = usuarioService.findById(id);
            if (usuarioFound.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioFound.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuarioDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity("La información no esta bien formada o no coincide con el formato esperado", HttpStatus.BAD_REQUEST);
        }
        try {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            String token = usuarioService.login(authenticationRequest);
            if (!token.isBlank()) {
                authenticationResponse.setJwt(token);
                //TODO: Complete this   authenticationResponse.setUsuario(usuario);
                //TODO: Complete this    authenticationResponse.setPermisos(permisosOtorgados);
                return new ResponseEntity(authenticationResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Credenciales invalidos", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/cedula/{term}")
    @ApiOperation(value = "Obtiene una lista por aproximacion de acuerdo a un numero de cedula", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuario>> result = usuarioService.findByCedulaAproximate(term);
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de usuarios por aproximacion de acuerdo a un nombre completo", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuario>> result = usuarioService.findByNombreCompletoAproximateIgnoreCase(term);
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioCreated = usuarioService.create(usuario);
            UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioCreated, UsuarioDTO.class);
            return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar los datos de un usuario por ID", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Usuario usuarioModified) {
        try {
            Optional<Usuario> usuarioUpdated = usuarioService.update(usuarioModified, id);
            if (usuarioUpdated.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioUpdated.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar usuario por ID", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los usuarios", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> deleteAll() {
        try {
            usuarioService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/* @GetMapping("/cedula/{term}")
    @ApiOperation(value = "Obtiene una lista por aproximacion de acuerdo a un numero de cedula", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuario")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {*/
    @GetMapping("/departamento/{term}")
    @ApiOperation(value = "Obtiene el jefe de un departamento con el id", response = UsuarioDTO.class, responseContainer = "Element", tags = "Usuarios")
    public ResponseEntity<?> findJefesByDepartamento(@PathVariable(value = "term") Long term) {
        try {

            Optional<Usuario> usuarioFound = usuarioService.findJefesByDepartamento(term);
            if (usuarioFound.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioFound.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios_departamento/{term}")
    @ApiOperation(value = "Obtiene el usuarios por departamento segun el id", response = UsuarioDTO.class, responseContainer = "Element", tags = "Usuarios")
    public ResponseEntity<?> findByDepartamentoId(@PathVariable(value = "term") Long term) {
        try {

            Optional<List<Usuario>> result = usuarioService.findUsersByDepartamentoId(term);
            if (result.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
