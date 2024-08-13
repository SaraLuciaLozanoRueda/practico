package com.filtro.practico.domain.services.region;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Region;


public interface RegionService {
    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);
    Optional<Region> update(Long id, Region region);
    Optional<Region> delete(Long id);
}
