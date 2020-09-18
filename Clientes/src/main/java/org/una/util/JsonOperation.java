package org.una.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.una.dto.DepartamentoDTO;
import org.una.dto.PermisoOtorgadoDTO;
import org.una.dto.ParametroGeneralDTO;
import org.una.dto.UsuarioDTO;

import java.util.List;

public class JsonOperation {

    public List<DepartamentoDTO> convertirJsonToDepartamentos( String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        List<DepartamentoDTO> posts = mapper.readValue(json, new TypeReference<List<DepartamentoDTO>>() {});

        for(DepartamentoDTO departamentoDTO: posts){
            System.out.println(departamentoDTO.toString());
        }


        return posts;

    }

    public List<UsuarioDTO> convertirJsonToUsuarios(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        List<UsuarioDTO> posts = mapper.readValue(json, new TypeReference<List<UsuarioDTO>>() {});

        for(UsuarioDTO usuarioDTO: posts){
            System.out.println(usuarioDTO.toString());
        }


        return posts;

    }

    public List<PermisoOtorgadoDTO> convertirJsonToPermisos(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<PermisoOtorgadoDTO> posts = mapper.readValue(json, new TypeReference<List<PermisoOtorgadoDTO>>() {});
        for(PermisoOtorgadoDTO permisoOtorgadoDTO: posts){
            System.out.println(permisoOtorgadoDTO.toString());
        }




        return posts;
    }

    public List<ParametroGeneralDTO> convertirJsonToParametros(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<ParametroGeneralDTO> posts = mapper.readValue(json, new TypeReference<List<ParametroGeneralDTO>>() {});
        for(ParametroGeneralDTO parametrosgeneralesDTO: posts){
            System.out.println(parametrosgeneralesDTO.toString());
        }




        return posts;
    }
}
