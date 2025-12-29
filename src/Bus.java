public class Bus  extends Vehicle {

    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    public int passengerCapacity() {
        return passengerCapacity;
    }

    public double calculateInsuranceFee() {
        return basePrice * 0.05;
    }

    public void performService() {
        System.out.println("Bus " + model + " is being serviced");
    }

    public int getServiceIntervalKm() {
        return 10000;
    }

    public String toString() {
        return super.toString() +
                ", Doors: " + passengerCapacity +
                ", Type: Car";
    }
}
