import java.util.ArrayList;
import java.util.List;

/**
 * ========================================================
 * MAIN CLASS - UseCase2TrainConsistMgmnt
 * ========================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 *
 * At this stage, the application:
 * - Adds new bogies to the train
 * - Removes existing bogies
 * - Checks for bogie availability
 * - Displays the final consist
 *
 * This maps CRUD operations using ArrayList.
 *
 * @author Developer
 * @version 2.0
 */
public class TrainConsistMgmnt {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("========================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("========================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        // add() attaches a new bogie to the train
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // ---- READ (Display bogies after adding) ----
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // ---- DELETE (Remove a bogie) ----
        // remove() detaches a bogie from the train
        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // ---- contains() - Check if a bogie exists ----
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        // ---- Final consist display ----
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}

