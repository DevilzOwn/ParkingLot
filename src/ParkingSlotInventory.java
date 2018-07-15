import java.util.HashMap;
import java.util.Iterator;

public class ParkingSlotInventory {
    private HashMap<Integer,Car> inventory = new HashMap<Integer,Car>();

    public Iterator getCarsIterator(){
        return inventory.values().iterator();
    }

    public Iterator getSlotsIterator(){
        return inventory.keySet().iterator();
    }
}
