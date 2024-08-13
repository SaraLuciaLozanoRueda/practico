package com.filtro.practico.domain.services.laboratorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.LaboratorioRepository;
import com.filtro.practico.persistence.Laboratorio;


@Service
public class LaboratorioImpl implements LaboratorioService{
    @Autowired
    private LaboratorioRepository repository;

    @Transactional
    @Override
    public List<Laboratorio> findAll() {
        return(List<Laboratorio>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Laboratorio> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Laboratorio save(Laboratorio laboratorio) {
        return repository.save(laboratorio);
    }

    @Transactional
    @Override
    public Optional<Laboratorio> update(Long id, Laboratorio laboratorio) {
       Optional<Laboratorio> labOpt = repository.findById(id);
       if(labOpt.isPresent()){
            Laboratorio labItem = labOpt.orElseThrow();
            labItem.setNombre(laboratorio.getNombre());
            labItem.setCiudad(laboratorio.getCiudad());
            return Optional.of(repository.save(labItem));
       }
       return labOpt;
    }

    @Transactional
    @Override
    public Optional<Laboratorio> delete(Long id) {
        Optional<Laboratorio> labOpt = repository.findById(id);
        labOpt.ifPresent(labItem ->{
            repository.delete(labItem);
        });
        return labOpt;
    }

}
