package robinson_flores;
import java.util.Scanner;
import robinson_flores.VacationPackageCostEstimator;
//CHECKSTYLE:OFF
public class main {
    public static void main(String[] args) {
//CHECKSTYLE:ON
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el destino de la vacacion (Paris o New York City): ");
        String destination = scanner.nextLine();

        System.out.print("Ingrese el número de viajeros: ");
        int numTravelers = scanner.nextInt();

        System.out.print("Ingrese la duración de la vacación en dias: ");
        int duration = scanner.nextInt();

        VacationPackageCostEstimator vacationPackage = new VacationPackageCostEstimator(destination, numTravelers,
                duration);
        int totalCost = vacationPackage.calculateTotalCost();

        if (totalCost == -1) {
            System.out.println("Los datos ingresados no son validos.");
        } else {
            System.out.println("El costo total de la vacación es: $" + totalCost);
        }

        scanner.close();
    }
}