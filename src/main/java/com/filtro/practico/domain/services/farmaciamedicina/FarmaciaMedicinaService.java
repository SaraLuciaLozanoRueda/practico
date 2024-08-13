package com.filtro.practico.domain.services.farmaciamedicina;

import java.util.List;
import java.util.Optional;

import com.filtro.practico.persistence.FarmaciaMedicina;

public interface FarmaciaMedicinaService {
    List<FarmaciaMedicina> findAll();
    Optional<FarmaciaMedicina> findById(Long id);
    FarmaciaMedicina save(FarmaciaMedicina farmedi);
    Optional<FarmaciaMedicina> update(Long id, FarmaciaMedicina farmedi);
    Optional<FarmaciaMedicina> delete(Long id);
}
