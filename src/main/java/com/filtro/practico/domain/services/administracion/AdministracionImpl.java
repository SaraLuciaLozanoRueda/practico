package com.filtro.practico.domain.services.administracion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.AdministracionRepository;
import com.filtro.practico.persistence.Administracion;


@Service
public class AdministracionImpl implements AdministracionService {
    @Autowired
    private AdministracionRepository repository;

     @Transactional
    @Override
    public List<Administracion> findAll() {
        return(List<Administracion>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Administracion> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Administracion save(Administracion administracion) {
        return repository.save(administracion);
    }

    @Transactional
    @Override
    public Optional<Administracion> update(Long id, Administracion administracion) {
       Optional<Administracion> AdministracionOpt = repository.findById(id);
       if(AdministracionOpt.isPresent()){
            Administracion AdministracionItem = AdministracionOpt.orElseThrow();
            AdministracionItem.setDescripcipon(administracion.getDescripcion());
            return Optional.of(repository.save(AdministracionItem));
       }
       return AdministracionOpt;
    }

    @Transactional
    @Override
    public Optional<Administracion> delete(Long id) {
        Optional<Administracion> AdministracionOpt = repository.findById(id);
        AdministracionOpt.ifPresent(AdministracionItem ->{
            repository.delete(AdministracionItem);
        });
        return AdministracionOpt;
    }    
}
