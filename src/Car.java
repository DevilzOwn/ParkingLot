public class Car extends Vehicle{

    protected String size;
    private int numberOfSeats;
    private int numberOfWheels;

    public Car(String registrationNumber, String color){
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.size = "Medium";
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
