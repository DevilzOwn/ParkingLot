import ParkingService.ParkingService;
import Vehicle.Car;
import Vehicle.Vehicle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParkingLot {
    ParkingService service;
    static boolean inventoryNotNull = false;

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public void processLine(String line){

        String[] lineCommand = line.split(" ");
        int result = -1;
        String message="";

        switch(lineCommand[0]){
        case "create_parking_lot":
            if(lineCommand.length>2 && !isBlank(lineCommand[1]) && !isBlank(lineCommand[2])){
                this.service = new ParkingService(Integer.valueOf(lineCommand[1]),
                        Integer.valueOf(lineCommand[2]));
                message = "Created a parking lot with "+ Integer.valueOf(lineCommand[1]) +
                        Integer.valueOf(lineCommand[2])+" slots";
                inventoryNotNull = true;
            }
            else if(!isBlank(lineCommand[1])){
                this.service = new ParkingService(Integer.valueOf(lineCommand[1]));
                message = "Created a parking lot with "+ Integer.valueOf(lineCommand[1]) + " slots";
                inventoryNotNull = true;
            }

            break;
        case "park":
            if(inventoryNotNull) {
                Car car;
                if (lineCommand.length > 3 && !isBlank(lineCommand[1]) && !isBlank(lineCommand[2]) && !isBlank(
                        lineCommand[3])) {
                    car = new Car(lineCommand[1], lineCommand[2], Boolean.getBoolean(lineCommand[3]));
                } else if (!isBlank(lineCommand[1]) && !isBlank(lineCommand[2])) {
                    car = new Car(lineCommand[1], lineCommand[2]);
                } else
                    break;

                result = this.service.park(car);
                if (result != -1) {
                    message = "Allocated slot number: " + result;
                } else {
                    message = "Sorry, parking lot is full";
                }
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "leave":
            if(inventoryNotNull) {
                if (!isBlank(lineCommand[1])) {
                    result = this.service.remove(Integer.valueOf(lineCommand[1]));
                    if (result != -1) {
                        message = "Slot number " + result + " is free";
                    } else {
                        message = "Slot number " + result + "is not available or unoccupied.";
                    }
                } else {
                    message = "Slot number not available.";
                }
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "registration_numbers_for_cars_with_colour":
            if(inventoryNotNull) {
                if (!isBlank(lineCommand[1])) {
                    List<Vehicle> list = service.searchByColor(lineCommand[1]);
                    message = list.stream()
                            .map(vehicle -> vehicle.getRegistrationNumber())
                            .collect(Collectors.joining(", "));
                } else {
                    message = "No Colour was specified.";
                }
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "status":
            if(inventoryNotNull) {
                service.printAll();
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "slot_numbers_for_cars_with_colour":
            if(inventoryNotNull) {
                if (!isBlank(lineCommand[1])) {
                    List<Vehicle> list = service.searchByColor(lineCommand[1]);
                    message = list.stream()
                            .map(vehicle -> Integer.toString(vehicle.getParkingSlot()))
                            .collect(Collectors.joining(", "));
                } else {
                    message = "No Colour was specified.";
                }
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "slot_number_for_registration_number":
            if(inventoryNotNull) {
                if (!isBlank(lineCommand[1])) {
                    Vehicle vehicle = service.searchByRegistrationNumber(lineCommand[1]);
                    if (vehicle != null) {
                        message = Integer.toString(vehicle.getParkingSlot());
                    } else {
                        message = "Not found";
                    }
                } else {
                    message = "No Registration Number was specified.";
                }
            }
            else{
                message = "Please create the parking lot first.";
            }
            break;
        case "exit":
            System.exit(0);
            break;
        default:
            message = "Please provide a valid input.";
            break;
        }
        if(!isBlank(message))
            System.out.println(message);
    }

    private void readFromFile(String fileName){
        String line = null;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                processLine(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex){
            System.out.println("Unable read Lines from buffered Reader.");
        }
    }
    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        if(args.length>0){
            String fileName = args[0];
            parkingLot.readFromFile(fileName);
        }
        else{
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String command = scanner.nextLine();
                parkingLot.processLine(command);
            }
        }


    }
}
