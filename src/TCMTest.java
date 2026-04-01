import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    // Helper method to create standard bogie list
    private List<TrainConsistMgmnt.Bogie> createBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistMgmnt.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new TrainConsistMgmnt.Bogie("General",     90));
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        // Loop filter with threshold 60 should return
        // Sleeper(72) and General(90) only
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByLoop(createBogieList(), 60);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        // Stream filter with threshold 60 should return
        // Sleeper(72) and General(90) only
        List<TrainConsistMgmnt.Bogie> result =
                TrainConsistMgmnt.filterByStream(createBogieList(), 60);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Both approaches must produce identical result sizes
        List<TrainConsistMgmnt.Bogie> bogies = createBogieList();
        List<TrainConsistMgmnt.Bogie> loopResult =
                TrainConsistMgmnt.filterByLoop(bogies, 60);
        List<TrainConsistMgmnt.Bogie> streamResult =
                TrainConsistMgmnt.filterByStream(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Elapsed time must be a positive value (> 0)
        List<TrainConsistMgmnt.Bogie> bogies = createBogieList();
        long loopTime   = TrainConsistMgmnt.measureLoopTime(bogies, 60);
        long streamTime = TrainConsistMgmnt.measureStreamTime(bogies, 60);
        assertTrue(loopTime   > 0, "Loop execution time should be > 0");
        assertTrue(streamTime > 0, "Stream execution time should be > 0");
    }

    @Test
    void testLargeDatasetProcessing() {
        // Large dataset - filtering must complete and return correct results
        List<TrainConsistMgmnt.Bogie> largeBogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeBogies.add(new TrainConsistMgmnt.Bogie("Sleeper",  72));
            largeBogies.add(new TrainConsistMgmnt.Bogie("AC Chair", 56));
        }
        // Only Sleeper(72) passes threshold of 60 — 100,000 results expected
        List<TrainConsistMgmnt.Bogie> loopResult =
                TrainConsistMgmnt.filterByLoop(largeBogies, 60);
        List<TrainConsistMgmnt.Bogie> streamResult =
                TrainConsistMgmnt.filterByStream(largeBogies, 60);
        assertEquals(100000, loopResult.size());
        assertEquals(100000, streamResult.size());
        assertEquals(loopResult.size(), streamResult.size());
    }
}
