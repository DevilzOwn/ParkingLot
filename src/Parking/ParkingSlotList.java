package Parking;

import Iterator.CompositeIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingSlotList<T> extends  Slot {
    List<Slot> slots;
    Queue<Integer> freeSlots;
    ParkingListType type;

    public ParkingListType getType() {
        return type;
    }

    public void setType(ParkingListType type) {
        this.type = type;
    }

    public ParkingSlotList(int startId, int endId, ParkingListType type) {
        this.slots = new ArrayList<Slot>();
        this.freeSlots = new PriorityQueue<Integer>();

        for(int i=startId;i<=endId;i++){
            freeSlots.offer(i);
        }
        this.rate = 0;
        this.size = null;
        this.parkingSlot = -1;
        this.type = type;
        this.setVehicle(null);
    }

    public ParkingSlotList(ParkingListType type){
        this.slots = new ArrayList<Slot>();
        this.rate = 0;
        this.size = null;
        this.parkingSlot = -1;
        this.type = type;
        this.setVehicle(null);
    }

    @Override
    public boolean addChild(Slot slot){
        if(freeSlots != null && !freeSlots.isEmpty()){
            slot.setParkingSlot(freeSlots.poll());
            slots.add(slot);
            return true;
        }
        else if(slot instanceof ParkingSlotList){
            slot.setParkingSlot(-1);
            slots.add(slot);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeChild(Slot slot){
        if(freeSlots != null){
            slots.remove(slot);
            freeSlots.offer(slot.getParkingSlot());
            slot = null;
            return true;
        }
        return false;
    }

    @Override public float findHourlyRate(SizeEnum size) {
        throw new UnsupportedOperationException();
    }

    @Override public Iterator createIterator() {
        return new CompositeIterator(slots.iterator());
    }
}
