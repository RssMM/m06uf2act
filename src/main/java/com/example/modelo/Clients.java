package com.example.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clients")
public class Clients {
    @Id
    private String dni;

    @Column
    private String nombre;

    @Column
    private String correo;

    @Column
    private String pais;

    @OneToMany(mappedBy = "clientsByIdClients")
    private List<Comptes> compteByIdCompte = new ArrayList<>();

    public Clients() {}

    public Clients(String dni, String nombre, String correo, String pais) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Comptes> getCompteByIdCompte() {
        return compteByIdCompte;
    }

    public void setCompteByIdCompte(List<Comptes> compteByIdCompte) {
        this.compteByIdCompte = compteByIdCompte;
    }

}
