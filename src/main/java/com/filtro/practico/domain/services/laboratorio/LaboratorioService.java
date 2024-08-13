package com.filtro.practico.domain.services.laboratorio;
import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.Laboratorio;

public interface LaboratorioService {
    List<Laboratorio> findAll();
    Optional<Laboratorio> findById(Long id);
    Laboratorio save(Laboratorio laboratorio);
    Optional<Laboratorio> update(Long id, Laboratorio laboratorio);
    Optional<Laboratorio> delete(Long id);
}
