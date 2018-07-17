package main;

import main.Parking.Slot;
import java.util.Iterator;

public class ParkingSlotInventory {

    private Slot parkingSlotList;

    public Slot getParkingSlotList() {
        return parkingSlotList;
    }

    public ParkingSlotInventory(Slot list){
        this.parkingSlotList = list;
    }

    public Iterator createIterator(){
        return parkingSlotList.createIterator();
    }
}
