import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TrainConsistMgmnt {

    // ---- REGEX PATTERNS ----
    // Train ID : TRN- followed by exactly 4 digits
    private static final Pattern TRAIN_ID_PATTERN =
            Pattern.compile("TRN-\\d{4}");

    // Cargo Code : PET- followed by exactly 2 uppercase letters
    private static final Pattern CARGO_CODE_PATTERN =
            Pattern.compile("PET-[A-Z]{2}");

    // ---- Reusable validation methods for testing ----
    public static boolean isValidTrainId(String trainId) {
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("================================================\n");

        Scanner scanner = new Scanner(System.in);

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        // Validate Train ID and Cargo Code using Pattern and Matcher
        boolean trainIdValid  = isValidTrainId(trainId);
        boolean cargoCodeValid = isValidCargoCode(cargoCode);

        // ---- Display validation results ----
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: "    + trainIdValid);
        System.out.println("Cargo Code Valid: "  + cargoCodeValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}