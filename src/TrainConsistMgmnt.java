import java.util.Arrays;
public class TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=====================================================");

        // 1. Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Precondition: Ensure data is sorted before binary search
        Arrays.sort(bogieIds);

        // 3. Define search key
        String key = "BG309";

        // Display sorted available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // BINARY SEARCH LOGIC
        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Compute mid index

            // Compare key with middle element using compareTo()
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                found = true;
                break; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        // 4. Display result
        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found in train consist.");
        }

        System.out.println("UC19 search completed...");
    }
}