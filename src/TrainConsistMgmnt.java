/**
 * Use Case 16: Sort Passenger Bogies by Capacity
 * Description: Demonstrates manual sorting of passenger bogie capacities
 * using the Bubble Sort algorithm instead of built-in sorting utilities.
 * * @author Developer
 * @version 26.0
 */
public class TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("=====================================================");

        // 1. Create array of passenger bogie capacities [cite: 39, 67]
        int[] capacities = {72, 56, 24, 70, 60};

        // 2. Display original order [cite: 40, 41]
        System.out.println("Original Capacities:");
        for (int capacity : capacities) {
            System.out.print(capacity + " ");
        }
        System.out.println();

        // BUBBLE SORT LOGIC [cite: 44]
        // Outer Loop controls the number of passes [cite: 45, 46, 62]
        for (int i = 0; i < capacities.length - 1; i++) {
            // Inner Loop compares adjacent values [cite: 54, 62, 68]
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                // Swap values if the left element is greater than the right element [cite: 55, 63, 69]
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic using a temporary variable [cite: 63]
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // 3. Display sorted result (Ascending) [cite: 47, 48, 57]
        System.out.println("\nSorted Capacities (Ascending):");
        for (int capacity : capacities) {
            System.out.print(capacity + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}