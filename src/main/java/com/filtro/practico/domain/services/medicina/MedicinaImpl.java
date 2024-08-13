package com.filtro.practico.domain.services.medicina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.MedicinaRepository;
import com.filtro.practico.persistence.Medicina;


@Service
public class MedicinaImpl implements MedicinaService{
    @Autowired
    private MedicinaRepository repository;

    @Transactional
    @Override
    public List<Medicina> findAll() {
        return(List<Medicina>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Medicina> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Medicina save(Medicina medicina) {
        return repository.save(medicina);
    }

    @Transactional
    @Override
    public Optional<Medicina> update(Long id, Medicina medicina) {
       Optional<Medicina> medicinaOpt = repository.findById(id);
       if(medicinaOpt.isPresent()){
            Medicina mediItem = medicinaOpt.orElseThrow();
            mediItem.setProcedimientos(medicina.getProcedimientos());
            mediItem.setNombre(medicina.getNombre());
            mediItem.setRegistro(medicina.getRegistro());
            mediItem.setDescripcion(medicina.getDescripcion());
            mediItem.setAdministracion(medicina.getAdministracion());
            mediItem.setActivo(medicina.getActivo());
            mediItem.setUnidad(medicina.getUnidad());
            mediItem.setRol(medicina.getRol());
            mediItem.setLaboratorio(medicina.getLaboratorio());
            return Optional.of(repository.save(mediItem));
       }
       return medicinaOpt;
    }

    @Transactional
    @Override
    public Optional<Medicina> delete(Long id) {
        Optional<Medicina> mediOpt = repository.findById(id);
        mediOpt.ifPresent(mediItem ->{
            repository.delete(mediItem);
        });
        return mediOpt;
    }
}
