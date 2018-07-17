import Vehicle.Car;
import Vehicle.Vehicle;
import java.util.List;

public class ParkingLot {
//    private final ParkingSlotInventory inventory = new ParkingSlotInventory(10);

    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        Car visitorCar1 = new Car("ka08msndf8723","blue");
        Car visitorCar2 = new Car("ka08utiwf8756","red");

        Car employeeCar1 = new Car("ka02hkjaf8734","pink", true);
        Car employeeCar2 = new Car("ka04jsdf8732","blue", true);
//        System.out.println(parkingLot.inventory.park(car));
//        System.out.println(parkingLot.inventory.remove(1));

        ParkingLotFactory factory = new ParkingLotFactory();
        ParkingService service = new ParkingService(5,5);
        service.park(visitorCar1);
        service.park(visitorCar2);
        service.park(employeeCar1);
        service.park(employeeCar2);

//        inventory.remove(6);
//        inventory.remove(7);


        service.printAll();
        List<Vehicle> list= service.searchByColor("blue");
        list.stream()
                .forEach(vehicle->System.out.println(vehicle.getRegistrationNumber() + "," + vehicle.getColor()));

        Vehicle vehicle = service.searchByRegistrationNumber("ka08utiwf8756");
        System.out.println(vehicle.getRegistrationNumber() + "," + vehicle.getColor());
    }
}
