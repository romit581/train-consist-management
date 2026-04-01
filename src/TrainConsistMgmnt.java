import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TrainConsistMgmnt {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // ---- Loop-based filtering method ----
    // Traditional for loop approach
    public static List<Bogie> filterByLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // ---- Stream-based filtering method ----
    // Declarative stream pipeline approach
    public static List<Bogie> filterByStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // ---- Measure loop execution time ----
    public static long measureLoopTime(List<Bogie> bogies, int threshold) {
        long startTime = System.nanoTime();
        filterByLoop(bogies, threshold);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // ---- Measure stream execution time ----
    public static long measureStreamTime(List<Bogie> bogies, int threshold) {
        long startTime = System.nanoTime();
        filterByStream(bogies, threshold);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("================================================\n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();

        // Populate with 100,000 bogies for meaningful benchmark
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper",     72));
            bogies.add(new Bogie("AC Chair",    56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("General",     90));
        }

        // ---- MEASURE LOOP EXECUTION TIME ----
        // System.nanoTime() captures high-resolution timestamp
        long loopTime = measureLoopTime(bogies, 60);

        // ---- MEASURE STREAM EXECUTION TIME ----
        long streamTime = measureStreamTime(bogies, 60);

        // ---- Display performance results ----
        System.out.println("Loop Execution Time (ns):   " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}