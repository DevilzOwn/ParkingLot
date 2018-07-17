import Parking.EmployeeParkingSlot;
import Parking.Slot;
import Parking.VisitorParkingSlot;
import java.util.Iterator;
import Vehicle.Vehicle;

public class ParkingSlotInventory {

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
        int slotId=-1, i=0;
        Slot slot = null;
        Iterator iterator = parkingSlotList.createIterator();
//        int i;
//        for(i=1;i<parkingSlots.length;i++){
//            if(parkingSlots[i] == null){
//                vehicle.setParkingSlot(i);
//                parkingSlots[i]=vehicle;
//                return i;
//            }
//        }
//        return -1;
        if(vehicle.isEmployeeVehicle()){
            slot = new EmployeeParkingSlot("8723");
            slot.setVehicle(vehicle);
            Slot employeeList=null;
            while(iterator.hasNext()){
                employeeList = (Slot)iterator.next();
                i++;
            }
            if(i==2 && employeeList!=null)
                employeeList.addChild(slot);
            else
                return -1;

            slotId=slot.getParkingSlot();
        }
        else{
            slot = new VisitorParkingSlot();
            slot.setVehicle(vehicle);
            if(iterator.hasNext()){
                Slot visitorList = (Slot)iterator.next();
                visitorList.addChild(slot);
            }
            slotId=slot.getParkingSlot();
        }
        return slotId;
    }

    public Vehicle remove(int parkingSlot){
//        Vehicle vehicle = parkingSlots[parkingSlot];
////        Vehicle.setParkingSlot(0);
//        parkingSlots[parkingSlot] = null;
//        return vehicle;
        Iterator iterator = parkingSlotList.createIterator();

        while(iterator.hasNext()){
            Slot parkingList= (Slot)iterator.next();
            Iterator listIterator = parkingList.createIterator();
            while(listIterator.hasNext()){
                Slot slot = (Slot)listIterator.next();
                if(slot.getParkingSlot() == parkingSlot){
                    parkingList.removeChild(slot);
                }
            }
        }


    }

    public boolean add(Slot slot){
        return parkingSlotList.addChild(slot);
    }
}
