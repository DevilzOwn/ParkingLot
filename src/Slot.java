import java.util.Iterator;

public abstract class Slot {

    protected int parkingSlot;
    protected SizeEnum size;
    protected float rate;
    protected long endTime;
    protected long startTime;
    protected Vehicle vehicle;

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean addChild(Slot slot) {
        throw new UnsupportedOperationException();
    }

    public boolean removeChild(Slot slot) {
        throw new UnsupportedOperationException();
    }

    protected abstract float findHourlyRate(SizeEnum size);
    protected abstract Iterator createIterator();
}
