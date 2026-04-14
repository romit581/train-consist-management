import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class TCMTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        // Verifies alphabetical sorting of a typical unsorted array [cite: 204]
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_UnsortedInput() {
        // Verifies rearrangement of random order names into alphabetical order [cite: 207]
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged [cite: 211]
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        // Verifies that duplicate names are retained and ordered correctly [cite: 214]
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element does not modify the array [cite: 216]
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }
}