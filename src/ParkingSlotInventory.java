public class ParkingSlotInventory {
//    private Map<Integer,Car> inventory = new HashMap<Integer ,Car>();


    private Slot parkingSlotList;
    private Vehicle[] parkingSlots;

    public Slot getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(Slot parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public ParkingSlotInventory(int n){
        parkingSlots = new Vehicle[n];
    }
    public ParkingSlotInventory(Slot list){
        this.parkingSlotList = list;
    }

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

    public boolean add(Slot slot){
        return parkingSlotList.addChild(slot);
    }
}
