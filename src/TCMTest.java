import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class TCMTest {

    // Helper method to represent the Linear Search logic
    private boolean linearSearch(String[] array, String key) {
        for (String element : array) {
            if (element.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        // Verifies identification of an existing bogie ID [cite: 333]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(ids, "BG309")); // [cite: 334]
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies negative result when the bogie ID does not exist [cite: 336]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(linearSearch(ids, "BG999")); // [cite: 337]
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies correct match at the very first position [cite: 339]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(ids, "BG101")); // [cite: 340]
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies match at the final position after full traversal [cite: 342]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(ids, "BG550")); // [cite: 343]
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies search works when only one ID exists [cite: 345]
        String[] ids = {"BG101"};
        assertTrue(linearSearch(ids, "BG101")); // [cite: 346]
    }
}