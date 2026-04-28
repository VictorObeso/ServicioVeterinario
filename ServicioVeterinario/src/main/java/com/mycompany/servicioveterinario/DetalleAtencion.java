package com.mycompany.servicioveterinario;

public class DetalleAtencion {

    private ServicioVeterinario servicio;
    private double costo;

    public DetalleAtencion(ServicioVeterinario servicio, double costo) {
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0.");
        }
        this.servicio = servicio;
        this.costo = costo;
    }

    public ServicioVeterinario getServicio() {
        return servicio;
    }

    public double getCosto() {
        return costo;
    }
}