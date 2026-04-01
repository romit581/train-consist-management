import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    // Helper method to create standard bogie list
    // Total = 72 + 56 + 24 + 70 = 222
    private List<TrainConsistMgmnt.Bogie> createBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     70));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        // 72 + 56 + 24 + 70 = 222
        int result = TrainConsistMgmnt.totalSeatingCapacity(createBogieList());
        assertEquals(222, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // All 4 bogies should contribute to the total
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",  50));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair", 50));
        bogies.add(new TrainConsistMgmnt.Bogie("General",  50));
        int result = TrainConsistMgmnt.totalSeatingCapacity(bogies);
        assertEquals(150, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Only one bogie - total should equal its capacity
        List<TrainConsistMgmnt.Bogie> single = new ArrayList<>();
        single.add(new TrainConsistMgmnt.Bogie("Sleeper", 72));
        int result = TrainConsistMgmnt.totalSeatingCapacity(single);
        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Empty list - reduce should return identity value 0
        List<TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();
        int result = TrainConsistMgmnt.totalSeatingCapacity(emptyList);
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // map() should extract correct capacity values before reduce
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     100));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class",  50));
        int result = TrainConsistMgmnt.totalSeatingCapacity(bogies);
        assertEquals(150, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        // Every bogie's capacity must be reflected in the total
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        int result = TrainConsistMgmnt.totalSeatingCapacity(bogies);
        assertEquals(152, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Original list must remain unchanged after aggregation
        List<TrainConsistMgmnt.Bogie> original = createBogieList();
        int originalSize = original.size();
        TrainConsistMgmnt.totalSeatingCapacity(original);
        assertEquals(originalSize, original.size());
        assertEquals(4, original.size());
    }
}
