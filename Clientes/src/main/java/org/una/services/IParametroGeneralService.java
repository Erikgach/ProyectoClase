package org.una.services;


import org.una.dto.ParametroGeneralDTO;

import java.io.IOException;
import java.util.List;
import java.util.Date;

public interface IParametroGeneralService {

    List<ParametroGeneralDTO> cargarParametros();
    ParametroGeneralDTO findById(Long id);
    List<ParametroGeneralDTO> finByNombre(String nombre);
    List<ParametroGeneralDTO> finByValor(String nombre);
    List<ParametroGeneralDTO> finByDescripcion(String nombre);
    List<ParametroGeneralDTO> findByFechaRegistroBetween(Date startDate, Date endDate);
    int deleteById(Long id) throws IOException, InterruptedException;
    List<ParametroGeneralDTO> getParametrosgenerales();
    ParametroGeneralDTO update(ParametroGeneralDTO parametrogeneralDTO, long id) throws IOException, InterruptedException;
    ParametroGeneralDTO create(ParametroGeneralDTO parametrogeneralDTO) throws IOException, InterruptedException;

    List<ParametroGeneralDTO> getParametros();
}
