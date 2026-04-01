
public class TrainConsistMgmnt {

    // ---- CUSTOM EXCEPTION ----
    // Extends Exception to create a checked custom exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie model with validation ----
    static class PassengerBogie {
        String type;
        int capacity;

        // Constructor validates capacity before creating the object
        // throws declares this constructor may raise InvalidCapacityException
        PassengerBogie(String type, int capacity)
                throws InvalidCapacityException {
            // ---- Fail-Fast Validation ----
            // throw raises the exception if business rule is violated
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                        "Capacity must be greater than zero"
                );
            }
            this.type     = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("================================================\n");

        // ---- Attempt 1: Valid bogie creation ----
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: "
                    + validBogie.type + " -> " + validBogie.capacity);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ---- Attempt 2: Invalid bogie creation (capacity = -10) ----
        try {
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", -10);
            System.out.println("Created Bogie: "
                    + invalidBogie.type + " -> " + invalidBogie.capacity);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}