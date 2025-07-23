package src;

import src.conversor.ConversorMoneda;
import src.conversor.ExchangeRateAPI;
import src.conversor.Moneda;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateAPI clienteApi = new ExchangeRateAPI();

        List<Moneda> opciones = List.of(
                new Moneda("MXN", "USD", "Peso Mexicano -> Dólar"),
                new Moneda("USD", "MXN", "Dólar -> Peso Mexicano"),
                new Moneda("EUR", "KRW", "Euro -> Won Surcoreano"),
                new Moneda("KRW", "EUR", "Won Surcoreano -> Euro"),
                new Moneda("CAD", "BRL", "Dólar Canadiense -> Real Brasileño"),
                new Moneda("BRL", "CAD", "Real Brasileño -> Dólar Canadiense")
        );
        int opcion;
        do {
            System.out.println("\n ***************** \n CONVERSOR DE MONEDAS \n");
                for (int i = 0; i <opciones.size(); i++){
                    System.out.printf("%d) %s%n", i + 1, opciones.get(i).conversion());
                }
            System.out.println("7) Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6){
                Moneda seleccion = opciones.get(opcion - 1);
                ConversorMoneda.realizarConversion(scanner, clienteApi, seleccion);
            } else if (opcion != 7) {
                System.out.println("Por favor ingrese una opción válida.");
            }
        } while (opcion != 7);
        System.out.println("Programa finalizado. Hasta pronto!");
    }
}