import Parking.EmployeeParkingSlot;
import Parking.ParkingListType;
import Parking.ParkingSlotList;
import Parking.Slot;
import Parking.VisitorParkingSlot;
import Vehicle.Vehicle;
import java.util.Iterator;

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
            Iterator<Slot> iterator = parkingSlotList.createIterator();
            slot = new EmployeeParkingSlot("8723");
            slot.setVehicle(vehicle);
            Slot employeeList=null;
            while(iterator.hasNext()){
                employeeList = iterator.next();
                if(employeeList instanceof ParkingSlotList &&
                        ((ParkingSlotList) employeeList).getType() == ParkingListType.EMPLOYEE){
                    if(((ParkingSlotList) employeeList).addChild(slot)){
                        slotId = slot.getParkingSlot();
                        break;
                    }
                    else {
                        slotId =-1;
                        break;
                    }
                }
            }
            slotId=-1;
        }
        else{
            Iterator<Slot> iterator = parkingSlotList.createIterator();
            slot = new VisitorParkingSlot();
            slot.setVehicle(vehicle);
            Slot visitorList = null;
            while(iterator.hasNext()){
                visitorList = iterator.next();
                if(visitorList instanceof ParkingSlotList && ((ParkingSlotList) visitorList).getType() == ParkingListType.VISITOR){
                    if(((ParkingSlotList)visitorList).addChild(slot)){
                        slotId = slot.getParkingSlot();
                        break;
                    }
                    else {
                        slotId=-1;
                        break;
                    }
                }
            }
        }
        return slotId;
    }

    public boolean remove(int parkingSlot){
//        Vehicle vehicle = parkingSlots[parkingSlot];
////        Vehicle.setParkingSlot(0);
//        parkingSlots[parkingSlot] = null;
//        return vehicle;
        Iterator<Slot> iterator = parkingSlotList.createIterator();
        ParkingSlotList list = null;

        while(iterator.hasNext()) {
            Slot parkingElement = iterator.next();
            if (parkingElement instanceof ParkingSlotList) {
                list = (ParkingSlotList) parkingElement;
                Iterator<Slot> listIterator = list.createIterator();
                while (listIterator.hasNext()) {
                    Slot slot = listIterator.next();
                    if (slot.getParkingSlot() == parkingSlot) {
                        return list.removeChild(slot);
                    }
                }
            }
        }
//            if(parkingElement instanceof VisitorParkingSlot || parkingElement instanceof EmployeeParkingSlot){
//                if(parkingElement.getParkingSlot() == parkingSlot){
//
//                }
//            }
//            Iterator listIterator = parkingList.createIterator();
//            while(listIterator.hasNext()){
//                Slot slot = (Slot)listIterator.next();
//                if(slot.getParkingSlot() == parkingSlot){
//                    parkingList.removeChild(slot);
//                }
//            }
//        }
    return false;
    }

    public void printAll(){
        Iterator<Slot> iterator = parkingSlotList.createIterator();
        while(iterator.hasNext()){
            Slot slot = iterator.next();
            if(slot.getSize()!= null){
                System.out.println(slot.getParkingSlot() + ":" +
                        slot.getVehicle().getRegistrationNumber() + ":" +
                        slot.getVehicle().getColor());
            }
        }
    }
}
