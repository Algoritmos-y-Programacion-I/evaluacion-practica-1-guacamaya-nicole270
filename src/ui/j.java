package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner escaner;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {
        escaner = new Scanner(System.in); // Inicializar escáner directamente en main()
        
        System.out.println("Bienvenido a Guacamaya!");
        solicitarDatos();

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el día");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el día");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el día");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el día");
            System.out.println("5. Consultar el número de referencias de productos que han superado un límite mínimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opción a ejecutar:");
            int opcion = escaner.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el día fue: " + calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el día fue: " + calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el día fueron: " + calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el límite mínimo de ventas a analizar:");
                    double limite = escaner.nextDouble();
                    System.out.println("\nDe las " + precios.length + " referencias vendidas en el día, " + consultarReferenciasSobreLimite(limite) + " superaron el límite mínimo de ventas de $" + limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    escaner.close();
                    break;
                default:
                    System.out.println("\nOpción inválida, intenta nuevamente.");
                    break;
            }
        }
    }

    public static void solicitarDatos() {
        System.out.println("\nDigite el número de referencias de producto diferentes vendidas en el día:");
        int referencias = escaner.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

        for (int i = 0; i < referencias; i++) {
            System.out.println("\nIngrese el precio de la referencia " + (i + 1) + ":");
            precios[i] = escaner.nextDouble();

            System.out.println("Ingrese la cantidad de unidades vendidas de la referencia " + (i + 1) + ":");
            unidades[i] = escaner.nextInt();
        }
    }

    public static int calcularTotalUnidadesVendidas() {
        int vendidas = 0;
        for (int unidad : unidades) {
            vendidas += unidad;
        }
        return vendidas;
    }

    public static double calcularPrecioPromedio() {
        double suma = 0;
        for (double precio : precios) {
            suma += precio;
        }
        return suma / precios.length;
    }

    public static double calcularVentasTotales() {
        double ventas = 0;
        for (int i = 0; i < precios.length; i++) {
            ventas += precios[i] * unidades[i];
        }
        return ventas;
    }

    public static int consultarReferenciasSobreLimite(double limite) {
        int contador = 0;
        for (int i = 0; i < precios.length; i++) {
            if ((precios[i] * unidades[i]) > limite) {
                contador++;
            }
        }
        return contador;
    }
}