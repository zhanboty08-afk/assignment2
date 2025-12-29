import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new FleetApp().run();
    }
    public void run() {
        while (true) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThan();
                case 6 -> serviceAll();
                case 7 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        vehicles.forEach(System.out::println);
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Base price: ");
        double price = scanner.nextDouble();
        System.out.print("Number of doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Car(model, year, price, doors));
        System.out.println("Car added");
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Base price: ");
        double price = scanner.nextDouble();
        System.out.print("Passenger capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Bus(model, year, price, capacity));
        System.out.println("Bus added");
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance fee: " + total);
    }
    private void showOlderThan() {
        System.out.print("Current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("N: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) {
            v.performService();
        }
    }
}
