package com.filtro.practico.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicinas")
public class Medicina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String procedimientos;

    private String nombre;

    private String registro;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Administracion administracion;

    @ManyToOne
    @JoinColumn(name="activo_id")
    private Activo activo;

    @ManyToOne
    @JoinColumn(name="unidad_id")
    private UnidadMedida unidad;

    private String rol;

    @ManyToOne
    @JoinColumn(name="laboratorio_id")
    private Laboratorio laboratorio;

    public Medicina() {
    }

    public Medicina(String procedimientos, String nombre, String registro, String descripcion,
            Administracion administracion, Activo activo, UnidadMedida unidad, String rol, Laboratorio laboratorio) {
        this.procedimientos = procedimientos;
        this.nombre = nombre;
        this.registro = registro;
        this.descripcion = descripcion;
        this.administracion = administracion;
        this.activo = activo;
        this.unidad = unidad;
        this.rol = rol;
        this.laboratorio = laboratorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(String procedimientos) {
        this.procedimientos = procedimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Administracion getAdministracion() {
        return administracion;
    }

    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }


    
    

    
}
