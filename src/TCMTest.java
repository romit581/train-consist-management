import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    @Test
    void testRegex_ValidTrainID() {
        // TRN-1234 is a valid Train ID format
        assertTrue(TrainConsistMgmnt.isValidTrainId("TRN-1234"));
        assertTrue(TrainConsistMgmnt.isValidTrainId("TRN-6524"));
        assertTrue(TrainConsistMgmnt.isValidTrainId("TRN-0001"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Wrong prefix, wrong format - all should be invalid
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("1234-TRN"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("trn-1234"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        // PET-AB is a valid Cargo Code format
        assertTrue(TrainConsistMgmnt.isValidCargoCode("PET-AB"));
        assertTrue(TrainConsistMgmnt.isValidCargoCode("PET-FH"));
        assertTrue(TrainConsistMgmnt.isValidCargoCode("PET-ZZ"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Lowercase, wrong format - all should be invalid
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET123"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("AB-PET"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("pet-AB"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Must have exactly 4 digits - 3 or 5 digits are invalid
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRN-12345"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRN-12"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Lowercase letters should be rejected
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET-Ab"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        // Empty strings should return invalid
        assertFalse(TrainConsistMgmnt.isValidTrainId(""));
        assertFalse(TrainConsistMgmnt.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Extra characters beyond pattern should be rejected
        assertFalse(TrainConsistMgmnt.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistMgmnt.isValidTrainId("XTRN-1234"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("PET-ABC"));
        assertFalse(TrainConsistMgmnt.isValidCargoCode("XPET-AB"));
    }
}
