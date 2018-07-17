package main;

import main.Parking.EmployeeParkingSlot;
import main.Parking.ParkingListType;
import main.Parking.ParkingSlotList;
import main.Parking.VisitorParkingSlot;

public class ParkingLotFactory {

    int employeeSlots;
    int visitorSlots;

    public ParkingSlotInventory createParkingLot(int employeeSlots,int visitorSlots){
        ParkingSlotInventory inventory = new ParkingSlotInventory(new ParkingSlotList(null));
        if(visitorSlots>0){
            inventory.getParkingSlotList().addChild(new ParkingSlotList<VisitorParkingSlot>(1, visitorSlots,
                    ParkingListType.VISITOR));
        }
        if(employeeSlots>0){
            inventory.getParkingSlotList().addChild(new ParkingSlotList<EmployeeParkingSlot>(visitorSlots+1,
                    visitorSlots + employeeSlots, ParkingListType.EMPLOYEE));
        }
        return inventory;
    }

    public ParkingSlotInventory createParkingLot(int visitorSlots){
        return createParkingLot(0,visitorSlots);
    }
}
