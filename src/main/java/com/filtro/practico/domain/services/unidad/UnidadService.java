package com.filtro.practico.domain.services.unidad;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.UnidadMedida;

public interface UnidadService {
    List<UnidadMedida> findAll();
    Optional<UnidadMedida> findById(Long id);
    UnidadMedida save(UnidadMedida unidad);
    Optional<UnidadMedida> update(Long id, UnidadMedida unidad);
    Optional<UnidadMedida> delete(Long id);
}
