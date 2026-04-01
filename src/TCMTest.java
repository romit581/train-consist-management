import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    @Test
    void testSafety_AllBogiesValid() {
        // All cylindrical bogies carry Petroleum - should be SAFE
        List<TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Open",        "Coal"));
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Box",         "Grain"));
        assertTrue(TrainConsistMgmnt.isSafeFormation(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        // Cylindrical bogie carrying Coal - should be UNSAFE
        List<TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));
        assertFalse(TrainConsistMgmnt.isSafeFormation(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        // Open and Box bogies with any cargo - should be SAFE
        List<TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Box",  "Grain"));
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Open", "Steel"));
        assertTrue(TrainConsistMgmnt.isSafeFormation(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        // One cylindrical bogie with Coal violates the rule - UNSAFE
        List<TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum")); // Valid
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Open",        "Coal"));      // Valid
        bogies.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));      // INVALID
        assertFalse(TrainConsistMgmnt.isSafeFormation(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        // Empty list - allMatch() returns true (no violations)
        List<TrainConsistMgmnt.GoodsBogie> emptyList = new ArrayList<>();
        assertTrue(TrainConsistMgmnt.isSafeFormation(emptyList));
    }
}
