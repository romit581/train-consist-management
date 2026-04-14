
public class TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=====================================================");

        // 1. Create array of bogie IDs [cite: 270]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Bogie ID to search [cite: 272]
        String searchId = "BG309";

        // Display all available bogies [cite: 274]
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // LINEAR SEARCH LOGIC [cite: 276]
        boolean found = false;

        // Traverse each element sequentially [cite: 277]
        for (String id : bogieIds) {
            // Equality Comparison using equals() for string safety [cite: 294, 301]
            if (id.equals(searchId)) {
                found = true;
                break; // Early Termination once match is found [cite: 295, 302]
            }
        }

        // 3. Display search result [cite: 280, 303]
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("UC18 search completed...");
    }
}