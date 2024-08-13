package com.filtro.practico.domain.services.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.ClienteRepository;
import com.filtro.practico.persistence.Cliente;


@Service
public class ClienteImpl implements ClienteService{
    @Autowired
    private ClienteRepository repository;

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return(List<Cliente>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Cliente> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    @Override
    public Optional<Cliente> update(Long id, Cliente cliente) {
       Optional<Cliente> clienteOpt = repository.findById(id);
       if(clienteOpt.isPresent()){
            Cliente clienteItem = clienteOpt.orElseThrow();
            clienteItem.setNombre(cliente.getNombre());
            clienteItem.setApellido(cliente.getApellido());
            clienteItem.setCiudad(cliente.getCiudad());
            clienteItem.setEmail(cliente.getEmail());
            clienteItem.setCumpleaños(cliente.getCumpleaños());
            clienteItem.setLon(cliente.getLon());
            clienteItem.setLatitud(cliente.getLatitud());
            return Optional.of(repository.save(clienteItem));
       }
       return clienteOpt;
    }

    @Transactional
    @Override
    public Optional<Cliente> delete(Long id) {
        Optional<Cliente> CiudadOpt = repository.findById(id);
        CiudadOpt.ifPresent(ClienteItem ->{
            repository.delete(ClienteItem);
        });
        return CiudadOpt;
    }
}
