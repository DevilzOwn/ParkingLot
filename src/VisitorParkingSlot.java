import java.util.Iterator;

public class VisitorParkingSlot extends Slot {

    public VisitorParkingSlot(String employeeId, float rate, SizeEnum size) {
        this.rate = findHourlyRate(size);
        this.size = size;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    protected float findHourlyRate(SizeEnum size) {
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

    @Override protected Iterator createIterator() {
        return null;
    }


}
