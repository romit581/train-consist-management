import java.util.Arrays;
public class TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("=====================================================");

        // 1. Create an array of bogie type names [cite: 148, 172]
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // 2. Display original order [cite: 186, 187]
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // 3. Use Arrays.sort() for optimized alphabetical sorting [cite: 149, 173]
        // This replaces the manual O(n^2) Bubble Sort with an O(n log n) algorithm
        Arrays.sort(bogieNames);

        // 4. Display sorted results using Arrays.toString() [cite: 150, 175]
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}