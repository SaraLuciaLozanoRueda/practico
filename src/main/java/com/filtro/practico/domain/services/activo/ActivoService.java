package com.filtro.practico.domain.services.activo;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Activo;

public interface ActivoService {
    List<Activo> findAll();
    Optional<Activo> findById(Long id);
    Activo save(Activo Activo);
    Optional<Activo> update(Long id, Activo Activo);
    Optional<Activo> delete(Long id);
}
