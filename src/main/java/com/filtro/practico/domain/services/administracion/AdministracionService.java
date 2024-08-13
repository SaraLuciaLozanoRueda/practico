package com.filtro.practico.domain.services.administracion;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Administracion;

public interface AdministracionService {
    List<Administracion> findAll();
    Optional<Administracion> findById(Long id);
    Administracion save(Administracion Administracion);
    Optional<Administracion> update(Long id, Administracion Administracion);
    Optional<Administracion> delete(Long id);
}
