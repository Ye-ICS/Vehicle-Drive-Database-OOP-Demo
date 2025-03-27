import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class CitizenManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Arrays for people's details:
        String[] names = new String[10];
        String[] sins = new String[names.length];
        String[] dobs = new String[names.length];
        String[] licenseNumbers = new String[names.length];

        // Arrays for vehicle details:
        String[] licensePlates = new String[4];
        String[] ownerLicenseNumbers = new String[licensePlates.length];
        String[] makes = new String[licensePlates.length];
        int[] modelYears = new int[licensePlates.length];
        String[] colours = new String[licensePlates.length];

        loadPersons("data/persons.txt", 10, names, sins, dobs, licenseNumbers);
        loadVehicles("data/vehicles.txt", 4, licensePlates, ownerLicenseNumbers, makes, modelYears, colours);

        // Interface for person or vehicle lookup
        while (true) {
            System.out.println("Enter license plate: ");
            String licensePlate = in.nextLine();
            int index;
            boolean found = false;

            // Linear search for matching vehicle
            for (index = 0; index < licensePlates.length; index++) {
                if (licensePlates[index].equalsIgnoreCase(licensePlate)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("License plate " + licensePlate + " not found.");
                continue;   // Skip to next iteration of WHILE-loop.
            }

            // Otherwise, linear search for owner:
            String ownerLicense = ownerLicenseNumbers[index];
            for (int i = 0; i < licenseNumbers.length; i++) {
                if (ownerLicense.equalsIgnoreCase(licenseNumbers[i])) {
                    System.out.println("Owner details:");
                    System.out.println("Name: " + names[i]);
                    System.out.println("SIN: " + sins[i]);
                    System.out.println("Date of birth: " + dobs[i]);
                    System.out.println("License: " + licenseNumbers[i]);
                    break;
                }
            }

            System.out.println();
        }
    }

    static void loadPersons(String filename, int count, String[] names, String[] sins, String[] dobs,
            String[] licenses) {
        try {
            Scanner fin = new Scanner(new FileReader(filename));
            for (int i = 0; i < count; i++) {
                names[i] = fin.nextLine();
                sins[i] = fin.nextLine();
                dobs[i] = fin.nextLine();
                licenses[i] = fin.nextLine();
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.err.println(filename + " not found!");
        }
    }

    static void loadVehicles(String filename, int count, String[] licensePlates, String[] ownerLicenses, String[] makes,
            int[] modelYears, String[] colours) {
        try {
            Scanner fin = new Scanner(new FileReader(filename));
            for (int i = 0; i < count; i++) {
                licensePlates[i] = fin.nextLine();
                ownerLicenses[i] = fin.nextLine();
                makes[i] = fin.nextLine();
                modelYears[i] = Integer.parseInt(fin.nextLine());
                colours[i] = fin.nextLine();
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.err.println(filename + " not found!");
        }
    }
}