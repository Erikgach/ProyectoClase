package org.una.services;



import org.una.dto.DepartamentoDTO;

import java.io.IOException;
import java.util.List;

public interface IDepartamentoService {

    List<DepartamentoDTO> cargarDepartamentos();
    DepartamentoDTO findById(Long id);
    List<DepartamentoDTO> findByEstado(Boolean estado);
    List<DepartamentoDTO> finByNombre(String nombre);
    int deleteById(Long id) throws IOException, InterruptedException;
    List<DepartamentoDTO> getDepartamentos();
    DepartamentoDTO update(DepartamentoDTO departamentoDTO, long id) throws IOException, InterruptedException;
    DepartamentoDTO create(DepartamentoDTO departamentoDTO) throws IOException, InterruptedException;





}
