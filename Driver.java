/**
 * Data class for driver registration details
 */
class Driver {
    // Instance variables (aka non-static fields):
    String name;
    String sin;
    String dob;
    String license;
    
    
    // Instance methods (aka non-static methods):

    /**
     * Prints details to terminal in human-readable format
     */
    void prettyPrint() {
        System.out.println("Driver Name: " + name);
        System.out.println("SIN: " + sin);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Driver License: " + license);
    }
}
