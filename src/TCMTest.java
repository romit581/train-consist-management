import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class TCMTest {

    // Helper method to represent the Binary Search logic
    private boolean binarySearch(String[] array, String key) {
        // Ensure data is sorted before applying Binary Search
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = key.compareTo(array[mid]);

            if (res == 0) return true;
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        // Verifies identification of an existing bogie ID [cite: 960]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        // Verifies negative result when ID does not exist [cite: 963]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        // Verifies match at the first position [cite: 966]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        // Verifies match at the last position [cite: 969]
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(ids, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        // Verifies safe handling of empty lists [cite: 975]
        String[] ids = {};
        assertFalse(binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Verifies sorting occurs before searching [cite: 977]
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(ids, "BG205"));
    }
}