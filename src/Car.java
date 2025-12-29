public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public double calculateInsuranceFee() {
        return basePrice * 0.05;
    }

    public void performService() {
        System.out.println("Car " + model + " is being serviced");
    }

    public int getServiceIntervalKm() {
        return 5000;
    }

    public String toString() {
        return super.toString() +
                ", Doors: " + numberOfDoors +
                ", Type: Car";
    }
}
