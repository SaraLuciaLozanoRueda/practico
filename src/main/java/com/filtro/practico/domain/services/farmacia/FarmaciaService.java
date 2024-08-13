package com.filtro.practico.domain.services.farmacia;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Farmacia;



public interface FarmaciaService {
    List<Farmacia> findAll();
    Optional<Farmacia> findById(Long id);
    Farmacia save(Farmacia farmacia);
    Optional<Farmacia> update(Long id, Farmacia farmacia);
    Optional<Farmacia> delete(Long id);
}
