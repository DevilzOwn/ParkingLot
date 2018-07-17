import Vehicle.Car;

public class ParkingLot {
    private final ParkingSlotInventory inventory = new ParkingSlotInventory(10);

    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        Car visitorCar1 = new Car("ka08msndf8723","blue");
        Car visitorCar2 = new Car("ka08utiwf8756","red");

        Car employeeCar1 = new Car("ka02hkjaf8734","pink", true);
        Car employeeCar2 = new Car("ka04jsdf8732","violet", true);
//        System.out.println(parkingLot.inventory.park(car));
//        System.out.println(parkingLot.inventory.remove(1));

        ParkingLotFactory factory = new ParkingLotFactory();
        ParkingSlotInventory inventory = factory.createParkingLot(5,5);
        inventory.park(visitorCar1);
        inventory.park(visitorCar2);
        inventory.park(employeeCar1);
        inventory.park(employeeCar2);

        inventory.remove(6);
        inventory.remove(7);

        inventory.printAll();
    }
}
