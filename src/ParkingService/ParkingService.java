package ParkingService;

import Parking.EmployeeParkingSlot;
import Parking.ParkingListType;
import Parking.ParkingSlotList;
import Parking.Slot;
import Parking.VisitorParkingSlot;
import Vehicle.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingService {
    private ParkingSlotInventory inventory;

    public ParkingService(int visitorParkingSlots, int employeeParkingSlots){
        ParkingLotFactory factory = new ParkingLotFactory();
        this.inventory = factory.createParkingLot(visitorParkingSlots, employeeParkingSlots);
    }

    public ParkingService(int visitorParkingSlots){
        ParkingLotFactory factory = new ParkingLotFactory();
        this.inventory = factory.createParkingLot(visitorParkingSlots);
    }

    public int park(Vehicle vehicle){
        int slotId=-1, i=0;
        Slot slot = null;

        if(vehicle.isEmployeeVehicle()){
            Iterator<Slot> iterator = inventory.createIterator();
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
            Iterator<Slot> iterator = inventory.createIterator();
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

    public int remove(int parkingSlot){
        Iterator<Slot> iterator = inventory.createIterator();
        ParkingSlotList list = null;

        while(iterator.hasNext()) {
            Slot parkingElement = iterator.next();
            if (parkingElement instanceof ParkingSlotList) {
                list = (ParkingSlotList) parkingElement;
                Iterator<Slot> listIterator = list.createIterator();
                while (listIterator.hasNext()) {
                    Slot slot = listIterator.next();
                    if (slot.getParkingSlot() == parkingSlot) {
                        list.removeChild(slot);
                        return parkingSlot;
                    }
                }
            }
        }
        return -1;
    }

    public void printAll(){
        Iterator<Slot> iterator = inventory.createIterator();
        System.out.println("Slot No.\tRegistration No\t\tColour");
        while(iterator.hasNext()){
            Slot slot = iterator.next();
            if(slot.getSize()!= null){
                System.out.println(slot.getParkingSlot() + "\t\t\t" +
                        slot.getVehicle().getRegistrationNumber() + "\t\t" +
                        slot.getVehicle().getColor());
            }
        }
    }

    public Vehicle searchByRegistrationNumber(String regNo){
        Iterator<Slot> iterator = inventory.createIterator();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        while(iterator.hasNext()){
            Slot slot = iterator.next();
            if(slot.getVehicle()!=null && slot.getVehicle().getRegistrationNumber().equalsIgnoreCase(regNo)){
                return slot.getVehicle();
            }
        }
        return null;
    }

    public List<Vehicle> searchByColor(String color){
        Iterator<Slot> iterator = inventory.createIterator();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        while(iterator.hasNext()){
            Slot slot = iterator.next();
            if(slot.getVehicle()!=null && slot.getVehicle().getColor().equalsIgnoreCase(color)){
                vehicleList.add(slot.getVehicle());
            }
        }
        return vehicleList;
    }
}
