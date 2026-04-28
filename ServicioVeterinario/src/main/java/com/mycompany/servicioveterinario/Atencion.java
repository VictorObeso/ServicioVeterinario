package com.mycompany.servicioveterinario;

import java.util.ArrayList;

public class Atencion {

    private int numero;
    private ArrayList<DetalleAtencion> detalles;

    public Atencion(int numero) {
        this.numero = numero;
        this.detalles = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void agregarDetalle(DetalleAtencion detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        if (detalles.isEmpty()) {
            throw new IllegalStateException("No se puede calcular una atención vacía.");
        }

        double total = 0;
        for (DetalleAtencion d : detalles) {
            total += d.getCosto();
        }
        return total;
    }

    public void mostrarDetalles() {
        for (DetalleAtencion d : detalles) {
            System.out.println("Servicio: " + d.getServicio().getNombre() +
                               " - Costo: S/ " + d.getCosto());
        }
    }

    public boolean tieneDetalles() {
        return !detalles.isEmpty();
    }


    public boolean buscarServicioGlobal(String nombreBuscado) {
        boolean encontrado = false;

        for (DetalleAtencion d : detalles) {
            if (d.getServicio().getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Servicio: " + d.getServicio().getNombre() +
                                   " - Costo: S/ " + d.getCosto());
                encontrado = true;
            }
        }

        return encontrado;
    }
}