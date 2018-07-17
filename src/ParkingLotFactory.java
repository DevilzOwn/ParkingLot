import Parking.EmployeeParkingSlot;
import Parking.ParkingSlotList;
import Parking.VisitorParkingSlot;

public class ParkingLotFactory {

    int employeeSlots;
    int visitorSlots;

    public ParkingSlotInventory createParkingLot(int employeeSlots,int visitorSlots){
        ParkingSlotInventory inventory = new ParkingSlotInventory(new ParkingSlotList());
        if(visitorSlots>0){
            inventory.getParkingSlotList().addChild(new ParkingSlotList<VisitorParkingSlot>());
        }
        if(employeeSlots>0){
            inventory.getParkingSlotList().addChild(new ParkingSlotList<EmployeeParkingSlot>());
        }
        return inventory;
    }

    public ParkingSlotInventory createParkingLot(int visitorSlots){
        return createParkingLot(0,visitorSlots);
    }
}
