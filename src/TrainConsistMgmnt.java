import java.util.ArrayList;
import java.util.List;


public class TrainConsistMgmnt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type  = type;
            this.cargo = cargo;
        }
    }

    // ---- Reusable safety validation method for testing ----
    // Safety Rule:
    // Cylindrical bogies → ONLY Petroleum allowed
    // All other bogie types → any cargo allowed
    public static boolean isSafeFormation(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("================================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // ---- ADD goods bogies ----
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // Valid
        goodsBogies.add(new GoodsBogie("Open",        "Coal"));      // Valid
        goodsBogies.add(new GoodsBogie("Box",         "Grain"));     // Valid
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));      // INVALID

        // ---- Display all goods bogies ----
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        // ---- SAFETY VALIDATION USING allMatch() ----
        // allMatch() checks every bogie against the safety rule
        // Short-circuits and stops at first violation
        boolean isSafe = isSafeFormation(goodsBogies);

        // ---- Display safety compliance status ----
        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}