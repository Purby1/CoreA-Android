package com.example.coreandroid;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellidos;
    private int numero;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
