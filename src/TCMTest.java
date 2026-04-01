import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    // Helper method to create a standard bogie list
    private List<TrainConsistMgmnt.Bogie> createBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     70));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    60));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Bogies with same name should be under the same key
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(createBogieList());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        // Sleeper appears twice - group should have 2 entries
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(createBogieList());
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        // Three distinct keys should exist: Sleeper, AC Chair, First Class
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(createBogieList());
        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Grouping an empty list should return an empty Map
        List<TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        // Only one type in the list - Map should have one key
        List<TrainConsistMgmnt.Bogie> singleType = new ArrayList<>();
        singleType.add(new TrainConsistMgmnt.Bogie("Sleeper", 72));
        singleType.add(new TrainConsistMgmnt.Bogie("Sleeper", 70));
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(singleType);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        // Verify all expected keys exist in the grouped Map
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(createBogieList());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        // Sleeper group = 2, AC Chair group = 2, First Class group = 1
        Map<String, List<TrainConsistMgmnt.Bogie>> result =
                TrainConsistMgmnt.groupByType(createBogieList());
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Original list must remain unchanged after grouping
        List<TrainConsistMgmnt.Bogie> original = createBogieList();
        int originalSize = original.size();
        TrainConsistMgmnt.groupByType(original);
        assertEquals(originalSize, original.size());
    }
}
