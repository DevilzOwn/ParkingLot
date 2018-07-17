package main.Vehicle;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String color;
    protected int parkingSlot;
    protected boolean isEmployeeVehicle;

    public boolean isEmployeeVehicle() {
        return isEmployeeVehicle;
    }

    public void setEmployeeVehicle(boolean employeeVehicle) {
        isEmployeeVehicle = employeeVehicle;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

}
