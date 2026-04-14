import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
class TCMTest {

    // Method representing the core Bubble Sort logic to be tested
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    void testSort_BasicSorting() {
        // Verifies that the Bubble Sort algorithm correctly sorts a typical unsorted array [cite: 99]
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input, "The array should be sorted in ascending order [cite: 100]");
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged after sorting [cite: 102]
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input, "An already sorted array should remain the same [cite: 103]");
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies that duplicate capacities are handled correctly during sorting [cite: 104]
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input, "Duplicates should be retained and ordered correctly [cite: 105]");
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element array does not modify the array [cite: 106]
        int[] input = {50};
        int[] expected = {50};
        bubbleSort(input);
        assertArrayEquals(expected, input, "A single element array should remain unchanged [cite: 107]");
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies that arrays containing identical values remain unchanged [cite: 108]
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(input);
        assertArrayEquals(expected, input, "An array of identical values should remain the same [cite: 109]");
    }
}