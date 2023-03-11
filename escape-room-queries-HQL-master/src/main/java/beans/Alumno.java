package com.example.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    private long idAlumno;

    @Column
    private String apellidos;

    @Column
    private int edad;

    @Column
    private String nombre;

    @Column
    private String repetidor;

    public Alumno(long idAlumno, String apellidos, int edad, String nombre, String repetidor) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nombre = nombre;
        this.repetidor = repetidor;
    }

    public Alumno(){

    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepetidor() {
        return repetidor;
    }

    public void setRepetidor(String repetidor) {
        this.repetidor = repetidor;
    }
}
