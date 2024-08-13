package com.filtro.practico.domain.services.farmaciamedicina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.FarmaciaMedicinaRepository;
import com.filtro.practico.persistence.FarmaciaMedicina;

@Service
public class FarmaciaMedinaImpl implements FarmaciaMedicinaService{

    @Autowired
    private FarmaciaMedicinaRepository repository;

    @Transactional
    @Override
    public List<FarmaciaMedicina> findAll() {
        return(List<FarmaciaMedicina>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<FarmaciaMedicina> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public FarmaciaMedicina save(FarmaciaMedicina farmedi) {
        return repository.save(farmedi);
    }

    @Transactional
    @Override
    public Optional<FarmaciaMedicina> update(Long id, FarmaciaMedicina farmedi) {
       Optional<FarmaciaMedicina> farmediOpt = repository.findById(id);
       if(farmediOpt.isPresent()){
            FarmaciaMedicina farmedItem = farmediOpt.orElseThrow();
            farmedItem.setFarmacia(farmedi.getFarmacia());
            farmedItem.setMedicina(farmedi.getMedicina());
            farmedItem.setPrecio(farmedi.getPrecio());
            return Optional.of(repository.save(farmedItem));
       }
       return farmediOpt;
    }

    @Transactional
    @Override
    public Optional<FarmaciaMedicina> delete(Long id) {
        Optional<FarmaciaMedicina> farmediOpt = repository.findById(id);
        farmediOpt.ifPresent(CiudadItem ->{
            repository.delete(CiudadItem);
        });
        return farmediOpt;
    }
}
