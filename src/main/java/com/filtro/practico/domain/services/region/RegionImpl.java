package com.filtro.practico.domain.services.region;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filtro.practico.domain.repositories.RegionRepository;
import com.filtro.practico.persistence.Region;


@Service
public class RegionImpl implements RegionService {
    @Autowired
    private RegionRepository repository;

        @Transactional
    @Override
    public List<Region> findAll() {
        return(List<Region>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Region> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Transactional
    @Override
    public Optional<Region> update(Long id, Region region) {
       Optional<Region> regionOpt = repository.findById(id);
       if(regionOpt.isPresent()){
            Region regionItem = regionOpt.orElseThrow();
            regionItem.setNombre(region.getNombre());
            regionItem.setPais(region.getPais());
            return Optional.of(repository.save(regionItem));
       }
       return regionOpt;
    }

    @Transactional
    @Override
    public Optional<Region> delete(Long id) {
        Optional<Region> regionOpt = repository.findById(id);
        regionOpt.ifPresent(regionItem ->{
            repository.delete(regionItem);
        });
        return regionOpt;
    }
}
