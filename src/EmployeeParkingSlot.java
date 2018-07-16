import java.util.Iterator;

public class EmployeeParkingSlot extends Slot{
    private String employeeId;

    public EmployeeParkingSlot(String employeeId, float rate, SizeEnum size) {
        this.employeeId = employeeId;
        this.rate = findHourlyRate(size);
        this.size = size;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    protected float findHourlyRate(SizeEnum size) {
        return 0;
    }

    @Override protected Iterator createIterator() {
        return null;
    }

}
