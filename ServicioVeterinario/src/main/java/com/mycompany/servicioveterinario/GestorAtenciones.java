package com.mycompany.servicioveterinario;

import java.util.ArrayList;

public class GestorAtenciones {

    private ArrayList<Atencion> atenciones;

    public GestorAtenciones() {
        atenciones = new ArrayList<>();
    }

    public void crearAtencion(int numero) {

        for (Atencion a : atenciones) {
            if (a.getNumero() == numero) {
                throw new IllegalArgumentException("Ya existe una atención con ese número.");
            }
        }

        atenciones.add(new Atencion(numero));
        System.out.println("Atención creada correctamente.");
    }

    private Atencion buscarAtencion(int numero) {
        for (Atencion a : atenciones) {
            if (a.getNumero() == numero) {
                return a;
            }
        }
        return null;
    }

    public void agregarServicio(int numero, String nombreServicio, double costo) {

        Atencion a = buscarAtencion(numero);

        if (a == null) {
            throw new IllegalArgumentException("Atención no encontrada.");
        }

        ServicioVeterinario servicio = new ServicioVeterinario(nombreServicio);
        DetalleAtencion detalle = new DetalleAtencion(servicio, costo);

        a.agregarDetalle(detalle);
        System.out.println("Servicio agregado correctamente.");
    }

    public void listarAtenciones() {

        if (atenciones.isEmpty()) {
            System.out.println("No hay atenciones.");
            return;
        }

        for (Atencion a : atenciones) {
            System.out.println("\nAtención N° " + a.getNumero());

            if (a.tieneDetalles()) {
                a.mostrarDetalles();
                System.out.println("Total: S/ " + a.calcularTotal());
            } else {
                System.out.println("Sin servicios.");
            }
        }
    }


    public void buscarServicioPorNombre(String nombre) {

        boolean encontrado = false;

        for (Atencion a : atenciones) {

            if (a.tieneDetalles()) {

                boolean encontradoEnEsta = a.buscarServicioGlobal(nombre);

                if (encontradoEnEsta) {
                    System.out.println("↑ Encontrado en atención N° " + a.getNumero());
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Servicio no encontrado en ninguna atención.");
        }
    }


    public double calcularTotalGeneral() {
        double totalGeneral = 0;

        for (Atencion a : atenciones) {
            if (a.tieneDetalles()) {
                totalGeneral += a.calcularTotal();
            }
        }

        return totalGeneral;
    }
}