import java.util.ArrayList;
import java.util.List;


public class TrainConsistMgmnt {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // ---- Reusable aggregation method for testing ----
    // map() extracts capacity field from each Bogie object
    // reduce() sums all capacity values into one total
    public static int totalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("================================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogies ----
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper",     70));

        // ---- Display bogies ----
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- AGGREGATE USING REDUCE ----
        // map() extracts capacity field from Bogie object
        // reduce(0, Integer::sum) accumulates all values into total
        int total = totalSeatingCapacity(bogies);

        // ---- Display total seating capacity ----
        System.out.println("\nTotal Seating Capacity of Train: " + total);

        System.out.println("\nUC10 aggregation completed...");
    }
}