package Vehicle;

import Parking.SizeEnum;

public class Car extends Vehicle {

    protected SizeEnum size;
    private int numberOfSeats;
    private int numberOfWheels;

    public Car(String registrationNumber, String color){
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.size = SizeEnum.MEDIUM;
        this.isEmployeeVehicle = false;
    }

    public Car(String registrationNumber, String color, boolean isEmployeeVehicle){
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.size = SizeEnum.MEDIUM;
        this.isEmployeeVehicle = isEmployeeVehicle;
    }

}

