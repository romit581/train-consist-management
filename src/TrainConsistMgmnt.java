import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TrainConsistMgmnt {

    // Reusing Bogie model from UC7 / UC8
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // ---- Reusable grouping method for testing ----
    public static Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("================================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogies including duplicates of same type ----
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper",     70));
        bogies.add(new Bogie("AC Chair",    60));

        // ---- Display all bogies before grouping ----
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- GROUP USING COLLECTORS.GROUPINGBY ----
        // Groups bogies into Map<String, List<Bogie>> by name
        Map<String, List<Bogie>> groupedBogies = groupByType(bogies);

        // ---- Display grouped structure ----
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}