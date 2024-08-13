package com.filtro.practico.domain.services.farmacia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.FarmaciaRepository;
import com.filtro.practico.persistence.Farmacia;


@Service
public class FarmaciaImpl implements FarmaciaService {
    @Autowired
    private FarmaciaRepository repository;

    @Transactional
    @Override
    public List<Farmacia> findAll() {
        return(List<Farmacia>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Farmacia> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Farmacia save(Farmacia farmacia) {
        return repository.save(farmacia);
    }

    @Transactional
    @Override
    public Optional<Farmacia> update(Long id, Farmacia farmacia) {
       Optional<Farmacia> farmaciaOpt = repository.findById(id);
       if(farmaciaOpt.isPresent()){
            Farmacia farmaciaItem = farmaciaOpt.orElseThrow();
            farmaciaItem.setNombre(farmacia.getNombre());
            farmaciaItem.setDireccion(farmacia.getDireccion());
            farmaciaItem.setLon(farmacia.getLon());
            farmaciaItem.setLatfarmacia(farmacia.getLatfarmacia());
            farmaciaItem.setCiudad(farmacia.getCiudad());
            farmaciaItem.setLogo(farmacia.getLogo());
            return Optional.of(repository.save(farmaciaItem));
       }
       return farmaciaOpt;
    }

    @Transactional
    @Override
    public Optional<Farmacia> delete(Long id) {
        Optional<Farmacia> farmaciaOpt = repository.findById(id);
        farmaciaOpt.ifPresent(farmaciaItem ->{
            repository.delete(farmaciaItem);
        });
        return farmaciaOpt;
    }
}
