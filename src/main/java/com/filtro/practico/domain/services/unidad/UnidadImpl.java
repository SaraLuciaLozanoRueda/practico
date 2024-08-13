package com.filtro.practico.domain.services.unidad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.UnidadMedidaRepository;
import com.filtro.practico.persistence.UnidadMedida;

@Service
public class UnidadImpl implements UnidadService{
    @Autowired
    private UnidadMedidaRepository repository;

     @Transactional
    @Override
    public List<UnidadMedida> findAll() {
        return(List<UnidadMedida>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<UnidadMedida> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public UnidadMedida save(UnidadMedida unidad) {
        return repository.save(unidad);
    }

    @Transactional
    @Override
    public Optional<UnidadMedida> update(Long id, UnidadMedida unidad) {
       Optional<UnidadMedida> unidadOpt = repository.findById(id);
       if(unidadOpt.isPresent()){
            UnidadMedida unidadItem = unidadOpt.orElseThrow();
            unidadItem.setNombre(unidad.getNombre());
            return Optional.of(repository.save(unidadItem));
       }
       return unidadOpt;
    }

    @Transactional
    @Override
    public Optional<UnidadMedida> delete(Long id) {
        Optional<UnidadMedida> unidadOpt = repository.findById(id);
        unidadOpt.ifPresent(unidadItem ->{
            repository.delete(unidadItem);
        });
        return unidadOpt;
    }
}
