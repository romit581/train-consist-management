import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TCMTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies that searching an empty array throws an IllegalStateException
        String[] emptyIds = {};
        assertThrows(IllegalStateException.class, () -> {
            TrainConsistMgmnt.searchBogie(emptyIds, "BG101");
        }, "Should throw IllegalStateException when searching an empty array");
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies that search executes normally when data is present
        String[] ids = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistMgmnt.searchBogie(ids, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies correct search result after passing validation
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistMgmnt.searchBogie(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies system returns false if key doesn't exist in a valid array
        String[] ids = {"BG101", "BG205", "BG309"};
        assertFalse(TrainConsistMgmnt.searchBogie(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        // Verifies correct behavior with one valid element
        String[] ids = {"BG101"};
        assertTrue(TrainConsistMgmnt.searchBogie(ids, "BG101"));
    }
}