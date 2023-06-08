// Copyright (C) 2020
// All rights reserved
package robinson_flores;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class VacationPackageCostEstimator {
    private String destination;
    private int numTravelers;
    private int duration;
    private int baseCost = 1000;
    private int vacationpackage;

    private static final List<String> popularTouristSpots = Arrays.asList("Paris", "New York City");
    private static final int additionalCostParis = 500;
    private static final int additionalCostNewYorkCity = 600;

	/**
	 * Crea un nuevo objeto VacationPackageCostEstimator con los parámetros especificados.
	 *
	 * @param destination  El destino de la vacación.
	 * @param numTravelers El número de viajeros.
	 * @param duration     La duración de la vacación en días.
	 */    
    public VacationPackageCostEstimator(String destination, int numTravelers, int duration, int vacationpackage) {
        this.destination = destination;
        this.numTravelers = numTravelers;
        this.duration = duration;
        this.vacationpackage = vacationpackage;
    }

	/**
	 * Calcula el costo total del paquete de vacaciones.
	 *
	 * @return El costo total del paquete de vacaciones si los datos de entrada son válidos,
	 *         de lo contrario, devuelve -1.
	 */
    public int calculateTotalCost() {
        if (!isValidInput()) {
            return -1;
        }

        int totalCost = baseCost;

        if (popularTouristSpots.contains(destination)) {
            if (destination.equals("Paris")) {
                totalCost += additionalCostParis;
            } else if (destination.equals("New York City")) {
                totalCost += additionalCostNewYorkCity;
            }
        }

        if (numTravelers > 4 && numTravelers < 10) {
            totalCost *= 0.9;
        } else if (numTravelers > 10) {
            totalCost *= 0.8;
        }

        if (duration < 7) {
            totalCost += 200;
        }

        if (duration > 30 || numTravelers == 2) {
            totalCost -= 200;
        }
        
        
        if (vacationpackage == 1) {
        	totalCost += numTravelers*200;
        }
        if (vacationpackage == 2) {
        	totalCost += numTravelers*150;
        }
        if (vacationpackage == 3) {
        	totalCost += numTravelers*100;
        }
        
        
        return totalCost;
    }
    
	/**
	 * Verifica si una cadena contiene solo letras.
	 *
	 * @param cadena La cadena a verificar.
	 * @return true si la cadena contiene solo letras, de lo contrario, false.
	 */
    static boolean containsOnlyLetters(String cadena) {
        return Pattern.matches("[a-zA-Z]+", cadena);
    }

  
    /**
     * Verifica si la entrada ingresada por el usuario es válida.
     *
     * @return true si la entrada es válida, de lo contrario, false.
     */
    private boolean isValidInput() {
    	
    	
        if (containsOnlyLetters(destination)) {
            return numTravelers > 0 && numTravelers <= 80 && duration > 0 && vacationpackage >= 0 && vacationpackage < 4;
        }
    
        return false;
    }
}