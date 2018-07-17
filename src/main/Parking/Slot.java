package main.Parking;

import java.util.Iterator;
import main.Vehicle.Vehicle;

public abstract class Slot {
    protected int parkingSlot;
    protected SizeEnum size;
    protected float rate;
    protected long endTime;
    protected long startTime;
    protected Vehicle vehicle;

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

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

    public abstract float findHourlyRate(SizeEnum size);
    public abstract Iterator createIterator();
}
