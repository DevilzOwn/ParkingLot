public class ParkingLot {
    private final ParkingSlotInventory inventory = new ParkingSlotInventory(10);

    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ka08msndf8723","blue");
        System.out.println(parkingLot.inventory.park(car));
        System.out.println(parkingLot.inventory.remove(1));
    }
}
