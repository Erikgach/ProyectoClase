package org.una.tramites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.repositories.IPermisoOtorgadoRepository;
import org.una.tramites.services.IDataInitializerService;

@Service
public class DataInitializerServiceImplementation implements IDataInitializerService {
    @Autowired


    @Override
    @Transactional
    public void initDevelopData() {

    }

    @Override
    @Transactional
    public void deleteAllData() {

    }
}
