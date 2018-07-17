package Parking;

import java.util.Iterator;
import Iterator.NullIterator;

public class VisitorParkingSlot extends Slot {
    public VisitorParkingSlot(SizeEnum size) {
        this.rate = findHourlyRate(size);
        this.size = size;
        this.startTime = System.currentTimeMillis();
    }

    public VisitorParkingSlot() {
        this.rate = findHourlyRate(size);
        this.size = SizeEnum.MEDIUM;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public float findHourlyRate(SizeEnum size) {
        float rate=0;

        switch (size){
        case SMALL: rate = 5;
            break;
        case LARGE: rate = 15;
            break;
        case MEDIUM: rate = 20;
            break;
        case HANDICAPPED: rate = 5;
            break;
        }
        return rate;
    }

    @Override public Iterator createIterator() {
        return new NullIterator();
    }
}