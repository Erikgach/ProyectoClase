package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Cliente;
import org.una.tramites.repositories.IClienteRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImplementation implements IClienteService{


    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Cliente>> findAll() {
        return Optional.ofNullable(clienteRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Cliente>> findByCedulaAproximate(String cedula) {
        return Optional.ofNullable(clienteRepository.findByCedulaContaining(cedula));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Cliente>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return Optional.ofNullable(clienteRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto));
    }

    @Override
    @Transactional
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Optional<Cliente> update(Cliente cliente, Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            return Optional.ofNullable(clienteRepository.save(cliente));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        clienteRepository.deleteAll();
    }

    @Override
    public Optional<Cliente> findByCedula(String cedula) {
        return Optional.ofNullable(clienteRepository.findByCedula(cedula));
    }

}
