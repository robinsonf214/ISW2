package robinson_flores;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class VacationPackageCostEstimator {
    private String destination;
    private int numTravelers;
    private int duration;
    private int baseCost = 1000;

    private static final List<String> popularTouristSpots = Arrays.asList("Paris", "New York City");
    private static final int additionalCostParis = 500;
    private static final int additionalCostNewYorkCity = 600;

    public VacationPackageCostEstimator(String destination, int numTravelers, int duration) {
        this.destination = destination;
        this.numTravelers = numTravelers;
        this.duration = duration;
    }

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

        return totalCost;
    }
    
    ////
    static boolean isStrint(String cadena)
	{
	
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false; //Se ha encontrado un caracter que no es letra
		}
 
		//Terminado el bucle sin que se haya retornado false, es que todos los caracteres son letras
		return true;
	}
    
    static boolean containsOnlyLetters(String cadena) {
        return Pattern.matches("[a-zA-Z]+", cadena);
    }

    
    ////
    
    
    private boolean isValidInput() {
    	
    	
        if (containsOnlyLetters(destination)) {
            return numTravelers > 0 && numTravelers <= 80 && duration > 0;
        }
    
        return false;
    }
}