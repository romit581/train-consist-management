import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    // Helper method to create a standard bogie list
    private List<TrainConsistMgmnt.Bogie> createBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new TrainConsistMgmnt.Bogie("General",     90));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Bogies with capacity > 70 should be Sleeper(72) and General(90)
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 70);
        assertEquals(2, result.size());
        assertEquals("Sleeper", result.get(0).name);
        assertEquals("General", result.get(1).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Bogies with capacity exactly 72 should NOT be included (> not >=)
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 72);
        assertFalse(result.stream().anyMatch(b -> b.name.equals("Sleeper")));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        // Bogies with capacity < 70 should NOT appear when threshold is 70
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 70);
        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        // Bogies with capacity > 50 should return Sleeper(72), AC Chair(56), General(90)
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 50);
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // No bogie has capacity > 100, result should be empty
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        // All bogies have capacity > 0, result should contain all 4
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(createBogieList(), 0);
        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Filtering an empty list should return empty without errors
        List<TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByCapacity(emptyList, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        // Original list must remain unchanged after filtering
        List<TrainConsistMgmnt.Bogie> original = createBogieList();
        int originalSize = original.size();
        TrainConsistMgmnt.filterByCapacity(original, 60);
        assertEquals(originalSize, original.size());
    }
}