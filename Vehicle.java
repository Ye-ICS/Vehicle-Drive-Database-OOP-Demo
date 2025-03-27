/**
 * Data class for vehicle registration details
 */
class Vehicle {
    // Instance variables (aka non-static fields):
    String licensePlate;
    String ownerLicense;
    String make;
    int modelYear;
    String colour;


    // Instance methods (aka non-static methods):

    /**
     * Prints details to terminal in human-readable format
     */
    void prettyPrint() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Owner License: " + ownerLicense);
        System.out.println("Brand and Model: " + make);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Colour: " + colour);
    }
}
