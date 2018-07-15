public class ParkingSlotInventory {
//    private Map<Integer,Car> inventory = new HashMap<Integer ,Car>();

    private Vehicle[] parkingSlots;

    public ParkingSlotInventory(int n){
        parkingSlots = new Vehicle[n];
    }

//    public Iterator getCarsIterator(){
//        return inventory.values().iterator();
//    }
//
//    public Iterator getSlotsIterator(){
//        return inventory.keySet().iterator();
//    }

    public int park(Vehicle vehicle){
        int i;
        for(i=1;i<parkingSlots.length;i++){
            if(parkingSlots[i] == null){
                vehicle.setParkingSlot(i);
                parkingSlots[i]=vehicle;
                return i;
            }
        }
        return -1;
    }

    public Vehicle remove(int parkingSlot){
        Vehicle vehicle = parkingSlots[parkingSlot];
//        Vehicle.setParkingSlot(0);
        parkingSlots[parkingSlot] = null;
        return vehicle;
    }
}
