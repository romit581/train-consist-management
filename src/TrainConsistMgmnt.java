import java.util.LinkedList;
import java.util.List;


public class TrainConsistMgmnt {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("========================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        LinkedList<String> trainConsist = new LinkedList<>();

        // ---- ADD bogies in sequence ----
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // ---- READ - Display initial consist ----
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // ---- INSERT at specific position ----
        // add(index, element) inserts 'Pantry Car' at position 2
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // ---- REMOVE first and last bogie ----
        // removeFirst() detaches the head (Engine)
        // removeLast() detaches the tail (Guard)
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}
