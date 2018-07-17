package tst;

import ParkingService.ParkingService;
import Vehicle.Car;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingServiceTest {

    static ParkingService parkingService = new ParkingService(5);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Running unit tests for Parking Service.");
    }

    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class");
    }


    @Before
    public void before() {
        parkingService = new ParkingService(5);
    }

    @After
    public void after() {
        parkingService = null;
    }

    private Vehicle getVehicle(){
        Vehicle vehicle = new Car("KA89PI1234","Red");
        return vehicle;
    }

    private Vehicle getVehicle(String registrationNumber,String color){
        Vehicle vehicle = new Car(registrationNumber ,color);
        return vehicle;
    }

    private List<Integer> parkingSetup(){
        List<Integer> slots = new ArrayList<Integer>();
        Vehicle vehicleA=getVehicle("A","Red");
        Vehicle vehicleB=getVehicle("B","Blue");
        Vehicle vehicleC=getVehicle("C","Cyan");
        Vehicle vehicleD=getVehicle("D","Blue");
        Vehicle vehicleE=getVehicle("F","Magenta");
        slots.add(parkingService.park(vehicleA));
        slots.add(parkingService.park(vehicleB));
        slots.add(parkingService.park(vehicleC));
        slots.add(parkingService.park(vehicleD));
        slots.add(parkingService.park(vehicleE));
        return slots;
    }

    @Test
    public void testParkHappyCase() {
        int result = parkingService.park(getVehicle());
        assertThat(result, not(equalTo(-1)));
    }

    @Test
    public void testParkUnHappyCase() {
        for(int i=0;i<5;i++)
            parkingService.park(getVehicle());
        int result = parkingService.park(getVehicle());

        assertThat(result, equalTo(-1));
    }

    @Test
    public void testRemoveHappyCase() {
        List<Integer> slots = parkingSetup();

        //removing at random:
        int result = parkingService.remove(slots.get(4));
        assertThat(result,equalTo(slots.get(4)));
    }

    @Test
    public void testRemoveUnHappyCase() {
        List<Integer> slots = parkingSetup();

        //removing at random:
        int result = parkingService.remove(7);
        assertThat(result,equalTo(-1));
    }

    @Test
    public void testSearchByColorHappyCase() {
        List<Integer> slots = parkingSetup();

        List<Vehicle> list = parkingService.searchByColor("Blue");
        assertNotNull(list);
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testSearchByColorUnHappyCase() {
        List<Integer> slots = parkingSetup();

        List<Vehicle> list = parkingService.searchByColor("Black");
        assertEquals(list.size(),0);
    }

    @Test
    public void testSearchByRegistrationHappyCase() {
        List<Integer> slots = parkingSetup();
        parkingService.remove(1);
        parkingService.park(new Car("Z","Black"));

        Vehicle vehicle = parkingService.searchByRegistrationNumber("Z");
        assertNotNull(vehicle);
        assertEquals(vehicle.getColor(),"Black");
    }

    @Test
    public void testSearchByRegistrationUnHappyCase() {
        List<Integer> slots = parkingSetup();

        Vehicle vehicle = parkingService.searchByRegistrationNumber("Z");
        assertNull(vehicle);
    }
}