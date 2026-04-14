public class TrainConsistMgmnt {

    /**
     * Searches for a bogie ID in the array with pre-validation.
     * @throws IllegalStateException if the bogie array is empty.
     */
    public static boolean searchBogie(String[] bogieIds, String searchId) {
        // 1. Validation: Fail-fast if the array is empty
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search failed: No bogies found in the train consist.");
        }

        // 2. Linear Search logic (only runs if validation passes)
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("=====================================================");

        // Scenario 1: Searching an empty array
        String[] emptyConsist = {};
        String searchId = "BG101";

        try {
            System.out.println("Attempting search on empty consist...");
            searchBogie(emptyConsist, searchId);
        } catch (IllegalStateException e) {
            // Catching the exception and displaying the error message
            System.err.println("Error: " + e.getMessage());
        }

        // Scenario 2: Searching a populated array
        String[] activeConsist = {"BG101", "BG205", "BG309"};
        try {
            System.out.println("\nAttempting search on active consist...");
            boolean found = searchBogie(activeConsist, searchId);
            System.out.println("Bogie " + searchId + (found ? " found." : " not found."));
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 search with exception handling completed...");
    }
}