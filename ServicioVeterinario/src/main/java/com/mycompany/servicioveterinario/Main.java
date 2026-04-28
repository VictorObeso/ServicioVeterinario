package com.mycompany.servicioveterinario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorAtenciones gestor = new GestorAtenciones();
        int opcion;

        do {
            System.out.println("\nSISTEMA VETERINARIO");
            System.out.println("1. Crear atención");
            System.out.println("2. Agregar servicio");
            System.out.println("3. Listar atenciones");
            System.out.println("4. Buscar servicio por nombre");
            System.out.println("5. Total general");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese número de atención: ");
                        int num = sc.nextInt();
                        gestor.crearAtencion(num);
                        break;

                    case 2:
                        System.out.print("Número de atención: ");
                        int numAt = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre del servicio: ");
                        String nombre = sc.nextLine();

                        System.out.print("Costo: ");
                        double costo = sc.nextDouble();

                        gestor.agregarServicio(numAt, nombre, costo);
                        break;

                    case 3:
                        gestor.listarAtenciones();
                        break;

                    case 4:
                        System.out.print("Nombre del servicio a buscar: ");
                        String nombreBus = sc.nextLine();

                        gestor.buscarServicioPorNombre(nombreBus);
                        break;

                    case 5:
                        double total = gestor.calcularTotalGeneral();
                        System.out.println("Total general: S/ " + total);
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: dato inválido.");
            }

        } while (opcion != 0);
    }
}