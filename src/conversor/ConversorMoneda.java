package src.conversor;

import java.io.IOException;
import java.util.Scanner;

public class ConversorMoneda {
    public static void realizarConversion(Scanner scanner, ExchangeRateAPI clienteAPI, Moneda moneda) {
        try {
            ExchangeRateResponse respuesta = clienteAPI.obtenerDivisa(moneda.original());
            Double tasa = respuesta.conversion_rates().get(moneda.destino());

            if (tasa != null){
                System.out.println("Ingrese la cantidad en " + moneda.original() + ": ");
                double cantidad = scanner.nextDouble();
                double resultado = cantidad * tasa;
                System.out.printf("%.2f %s = %.2f %s%n", cantidad, moneda.original(), resultado, moneda.destino());
            } else {
                System.out.println("No se encontro la tasa de cambio para " + moneda.destino());
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al consultar la API: " + e.getMessage());
        }
    }
}
