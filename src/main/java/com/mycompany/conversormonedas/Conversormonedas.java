package com.mycompany.conversormonedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversormonedas {

    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Scanner sc = new Scanner(System.in);
        String result;
        int opcion;
        do {
            System.out.println("------------ MENÚ PRINCIPAL -----------");
            System.out.println("1. Convertir de Dolar a Peso Argentino");
            System.out.println("2. Convertir de Dolar a Sol Peruano");
            System.out.println("3. Convertir de Dolar a Peso Mexicano");
            System.out.println("4. Convertir de Dolar a Real Brasileño");
            System.out.println("5. Seleccionar las monedas a convertir");
            System.out.println("6. Salir");
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                opcion = 0;
                System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                sc.nextLine();
            } catch (Exception e) {
                opcion = 0;
                System.err.println("Ocurrio un error: " + e.getMessage());
            }
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Ingrese la cantidad a convertir( Ej: 20.50 o 20.5)");
                        Double quanty = sc.nextDouble();
                        result = apiService.getCoinExchange("USD", "ARS", quanty);
                        System.out.println("Su cambio de " + quanty + " USD a ARS es equivalente a: " + result + " ARS");
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Ingrese la cantidad a convertir( Ej: 20.50 o 20.5)");
                        Double quanty = sc.nextDouble();
                        result = apiService.getCoinExchange("USD", "PEN", quanty);
                        System.out.println("Su cambio de " + quanty + " USD a PEN es equivalente a: " + result + " PEN");
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Ingrese la cantidad a convertir( Ej: 20.50 o 20.5)");
                        Double quanty = sc.nextDouble();
                        result = apiService.getCoinExchange("USD", "MXN", quanty);
                        System.out.println("Su cambio de " + quanty + " USD a MXN es equivalente a: " + result + " MXN");
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Ingrese la cantidad a convertir( Ej: 20.50 o 20.5)");
                        Double quanty = sc.nextDouble();
                        result = apiService.getCoinExchange("USD", "BRL", quanty);
                        System.out.println("Su cambio de " + quanty + " USD a BRL es equivalente a: " + result + " MXN");
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Lista completa de monedas: ");
                        apiService.getFullList();
                        System.out.println("Ingrese la moneda base (origen)(Ej: PEN, USD, EUR, etc.)");
                        String fromCoin = sc.nextLine();
                        System.out.println("Ingrese la moneda a la que desea convertir (Ej: PEN, USD, EUR, etc.)");
                        String toCoin = sc.nextLine();
                        System.out.println("Ingrese la cantidad a convertir( Ej: 20.50 o 20.5)");
                        Double quanty = sc.nextDouble();
                        result = apiService.getCoinExchange(fromCoin.toUpperCase(), toCoin.toUpperCase(), quanty);
                        System.out.println("Su cambio de " + quanty + " " + fromCoin.toUpperCase() + " a " + toCoin.toUpperCase() + " es equivalente a: " + result + " " + toCoin.toUpperCase());
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido (use punto decimal si es necesario).");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.err.println("Ocurrio un error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el conversor de monedas!");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 6);
        sc.close();
    }
}
