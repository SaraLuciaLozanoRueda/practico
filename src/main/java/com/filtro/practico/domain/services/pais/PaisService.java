package com.filtro.practico.domain.services.pais;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Pais;

public interface PaisService {
    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais pais);
    Optional<Pais> update(Long id, Pais pais);
    Optional<Pais> delete(Long id);
}

