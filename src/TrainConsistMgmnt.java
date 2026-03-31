import java.util.LinkedHashSet;
import java.util.Set;


public class TrainConsistMgmnt {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("========================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // ---- ATTACH bogies in sequence ----
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // ---- Intentional duplicate attachment ----
        // LinkedHashSet will silently ignore this
        formation.add("Sleeper"); // Duplicate entry - ignored automatically

        // ---- READ - Display final train formation ----
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        // ---- Note about LinkedHashSet behavior ----
        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}
