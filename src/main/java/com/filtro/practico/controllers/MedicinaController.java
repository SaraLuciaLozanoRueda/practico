package com.filtro.practico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.practico.domain.services.medicina.MedicinaService;
import com.filtro.practico.persistence.Medicina;

@RestController
@RequestMapping("/medicina")
public class MedicinaController {
    @Autowired
    private MedicinaService service;

    @GetMapping
    public List<Medicina> listaMedicina(){
        return service.findAll();
    }

    
}
