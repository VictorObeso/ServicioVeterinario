package com.mycompany.servicioveterinario;

public class ServicioVeterinario {

    private String nombre;

    public ServicioVeterinario(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}