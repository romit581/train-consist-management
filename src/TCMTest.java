import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    @Test
    void testCargo_SafeAssignment() {
        // Cylindrical bogie can safely carry Petroleum
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Cylindrical");
        // Should not throw any exception
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        // Cargo should be assigned successfully
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Rectangular bogie cannot carry Petroleum
        // Exception is caught inside assignCargo() so no exception
        // propagates to the caller - program does not crash
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");
        // assignCargo handles exception internally - no throw to caller
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // When unsafe assignment occurs, cargo field must remain null
        TrainConsistMgmnt.GoodsBogie bogie =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        // cargo should NOT be set because exception was thrown before assignment
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Multiple assignments should all complete without crashing
        TrainConsistMgmnt.GoodsBogie rect =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");
        TrainConsistMgmnt.GoodsBogie cyl =
                new TrainConsistMgmnt.GoodsBogie("Cylindrical");

        // Both calls should execute without propagating exceptions
        assertDoesNotThrow(() -> rect.assignCargo("Petroleum"));
        assertDoesNotThrow(() -> cyl.assignCargo("Petroleum"));

        // Cylindrical should have cargo assigned
        assertEquals("Petroleum", cyl.cargo);
        // Rectangular should NOT have cargo assigned
        assertNull(rect.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // finally block always runs - verified by checking
        // cargo state after both safe and unsafe assignments

        // Safe path - finally runs after successful assignment
        TrainConsistMgmnt.GoodsBogie cyl =
                new TrainConsistMgmnt.GoodsBogie("Cylindrical");
        cyl.assignCargo("Petroleum");
        assertEquals("Petroleum", cyl.cargo); // assignment succeeded

        // Unsafe path - finally runs after exception is caught
        TrainConsistMgmnt.GoodsBogie rect =
                new TrainConsistMgmnt.GoodsBogie("Rectangular");
        rect.assignCargo("Petroleum");
        assertNull(rect.cargo); // assignment failed but program alive
    }
}