package com.filtro.practico.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.filtro.practico.persistence.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
