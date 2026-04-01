import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TrainConsistMgmnt {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        // Constructor to initialize bogie name and capacity
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("================================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogie objects with name and capacity ----
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // ---- READ - Display bogies before sorting ----
        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- SORT using Comparator by capacity (ascending) ----
        // Comparator.comparingInt() applies custom ordering logic
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // ---- READ - Display bogies after sorting ----
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}
