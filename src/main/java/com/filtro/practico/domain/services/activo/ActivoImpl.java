package com.filtro.practico.domain.services.activo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.ActivoRepository;
import com.filtro.practico.persistence.Activo;

@Service
public class ActivoImpl implements ActivoService {
    @Autowired
    private ActivoRepository repository;

    @Transactional
    @Override
    public List<Activo> findAll() {
        return(List<Activo>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Activo> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Activo save(Activo activo) {
        return repository.save(activo);
    }

    @Transactional
    @Override
    public Optional<Activo> update(Long id, Activo activo) {
       Optional<Activo> ActivoOpt = repository.findById(id);
       if(ActivoOpt.isPresent()){
            Activo ActivoItem = ActivoOpt.orElseThrow();
            ActivoItem.setNombre(activo.getNombre());
            return Optional.of(repository.save(ActivoItem));
       }
       return ActivoOpt;
    }

    @Transactional
    @Override
    public Optional<Activo> delete(Long id) {
        Optional<Activo> ActivoOpt = repository.findById(id);
        ActivoOpt.ifPresent(ActivoItem ->{
            repository.delete(ActivoItem);
        });
        return ActivoOpt;
    }

}
