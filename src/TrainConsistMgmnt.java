
public class TrainConsistMgmnt {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    // Extends RuntimeException - unchecked, no throws declaration needed
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ---- Goods Bogie model ----
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // ---- Assign cargo with safety validation ----
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry Petroleum
                if (this.shape.equals("Rectangular")
                        && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException(
                            "Unsafe cargo assignment!"
                    );
                }
                // Safe assignment
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                // ---- Catch unsafe cargo exception ----
                System.out.println("Error: " + e.getMessage());

            } finally {
                // ---- finally always executes ----
                // Runs whether assignment succeeded or failed
                System.out.println("Cargo validation completed for "
                        + this.shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("================================================\n");

        // ---- Attempt 1: Safe assignment ----
        // Cylindrical bogie CAN carry Petroleum
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        // ---- Attempt 2: Unsafe assignment ----
        // Rectangular bogie CANNOT carry Petroleum
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}