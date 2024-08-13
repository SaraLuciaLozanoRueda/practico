package com.filtro.practico.domain.services.medicina;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Medicina;

public interface MedicinaService {
    List<Medicina> findAll();
    Optional<Medicina> findById(Long id);
    Medicina save(Medicina medicina);
    Optional<Medicina> update(Long id, Medicina medicina);
    Optional<Medicina> delete(Long id);
}
