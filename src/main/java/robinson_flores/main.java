// Copyright (C) 2020
// All rights reserved
package robinson_flores;
import java.util.Scanner;
//import robinson_flores.VacationPackageCostEstimator;
//CHECKSTYLE:OFF

@SuppressWarnings("PMD.UseUtilityClass")
public class Main { //NOPMD 
	/**
	 * Método principal del programa.
	 *
	 * @param args Los argumentos de línea de comandos.
	 */
    public static void main(String[] args) {
//CHECKSTYLE:ON
        Scanner scanner = new Scanner(System.in); //NOPMD

        System.out.print("Ingrese el destino de la vacacion (Paris o New York City have aditional cost): "); //NOPMD 
        String destination = scanner.nextLine();

        System.out.print("Ingrese el número de viajeros: ");//NOPMD 
        int numTravelers = scanner.nextInt();

        System.out.print("Ingrese la duración de la vacación en dias: "); //NOPMD 
        int duration = scanner.nextInt();
        
        System.out.print("Ingrese paquete vacacional: \n 1.- All-Inclusive Package - $200 per traveler" //NOPMD 
        		+ "\n 2.-  Adventure Activities Package - $150 per traveler"
        		+ "\n 3.-  Spa and Wellness Package - $100 per traveler"
        		+ "\n 0.- no aditional package");
        
        int vacationpackage = scanner.nextInt();

        VacationPackageCostEstimator vacationPackage = new VacationPackageCostEstimator(destination, numTravelers,
                duration, vacationpackage);
        int totalCost = vacationPackage.calculateTotalCost();

        if (totalCost == -1) {
            System.out.println("Los datos ingresados no son validos."); //NOPMD 
        } else {
            System.out.println("El costo total de la vacación es: $" + totalCost); //NOPMD 
        }

        scanner.close();
    }
}