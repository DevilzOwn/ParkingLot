package Parking;

import java.util.Iterator;
import Iterator.NullIterator;

public class EmployeeParkingSlot extends Slot{
    private String employeeId;

    public EmployeeParkingSlot(String employeeId, SizeEnum size) {
        this.employeeId = employeeId;
        this.rate = findHourlyRate(size);
        this.size = size;
        this.startTime = System.currentTimeMillis();
    }

    public EmployeeParkingSlot(String employeeId){
        this.employeeId = employeeId;
        this.rate = findHourlyRate(size);
        this.size = SizeEnum.MEDIUM;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public float findHourlyRate(SizeEnum size) {
        return 0;
    }

    @Override public Iterator createIterator() {
        return new NullIterator();
    }
}
