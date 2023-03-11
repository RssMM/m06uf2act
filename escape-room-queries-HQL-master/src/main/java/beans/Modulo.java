package com.example.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo {

    @Id
    private long idModulo;

    @Column
    private String nombre;

    public Modulo(long idModulo, String nombre) {
        this.idModulo = idModulo;
        this.nombre = nombre;
    }

    public Modulo(){

    }

    public long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
