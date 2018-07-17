package Parking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingSlotList extends  Slot {
    List<Slot> slots;
    Queue<Integer> freeSlots;

    public ParkingSlotList(int startId, int endId) {
        this.slots = new ArrayList<Slot>();
        this.freeSlots = new PriorityQueue<Integer>();
        for(int i=startId;i<=endId;i++){
            freeSlots.offer(i);
        }
    }

    public ParkingSlotList(){
        this.slots = new ArrayList<Slot>();
    }

    @Override
    public boolean addChild(Slot slot){
        if(freeSlots != null && !freeSlots.isEmpty()){
            slot.setParkingSlot(freeSlots.poll());
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

    @Override protected float findHourlyRate(SizeEnum size) {
        throw new UnsupportedOperationException();
    }

    @Override protected Iterator createIterator() {
        return slots.iterator();
    }
}
