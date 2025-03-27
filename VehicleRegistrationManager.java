import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class CitizenManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Arrays for people's details:
        Driver[] drivers = new Driver[10];

        // Arrays for vehicle details:
        Vehicle[] vehicles = new Vehicle[4];

        loadPersons("data/persons.txt", 10, drivers);
        loadVehicles("data/vehicles.txt", 4, vehicles);

        // Interface for person or vehicle lookup
        while (true) {
            System.out.println("Enter license plate: ");
            String licensePlate = in.nextLine();
            int index;
            boolean found = false;

            // Linear search for matching vehicle
            for (index = 0; index < vehicles.length; index++) {
                if (vehicles[index].licensePlate.equalsIgnoreCase(licensePlate)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("License plate " + licensePlate + " not found.");
                continue;   // Skip to next iteration of WHILE-loop.
            }

            // Otherwise, linear search for owner:
            String ownerLicense = vehicles[index].ownerLicense;
            for (int i = 0; i < drivers.length; i++) {
                Driver driver = drivers[i];
                if (ownerLicense.equalsIgnoreCase(driver.license)) {
                    System.out.println("Owner details:");
                    System.out.println("Name: " + driver.name);
                    System.out.println("SIN: " + driver.sin);
                    System.out.println("Date of birth: " + driver.dob);
                    System.out.println("License: " + driver.license);
                    break;
                }
            }

            System.out.println();
        }
    }

    static void loadPersons(String filename, int count, Driver[] drivers) {
        try {
            Scanner fin = new Scanner(new FileReader(filename));
            for (int i = 0; i < count; i++) {
                drivers[i] = new Driver();      // Must create an empty Driver for at each index first!
                drivers[i].name = fin.nextLine();
                drivers[i].sin = fin.nextLine();
                drivers[i].dob = fin.nextLine();
                drivers[i].license = fin.nextLine();
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.err.println(filename + " not found!");
        }
    }

    static void loadVehicles(String filename, int count, Vehicle[] vehicles) {
        try {
            Scanner fin = new Scanner(new FileReader(filename));
            for (int i = 0; i < count; i++) {
                vehicles[i] = new Vehicle();
                vehicles[i].licensePlate = fin.nextLine();
                vehicles[i].ownerLicense = fin.nextLine();
                vehicles[i].make = fin.nextLine();
                vehicles[i].modelYear = Integer.parseInt(fin.nextLine());
                vehicles[i].colour = fin.nextLine();
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.err.println(filename + " not found!");
        }
    }
}