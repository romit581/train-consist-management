import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TCMTest {

    @Test
    void testException_ValidCapacityCreation()
            throws TrainConsistMgmnt.InvalidCapacityException {
        // Valid capacity > 0 should create bogie without exception
        TrainConsistMgmnt.PassengerBogie bogie =
                new TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Negative capacity should throw InvalidCapacityException
        assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("AC Chair", -10)
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Zero capacity should throw InvalidCapacityException
        assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("Sleeper", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Exception message must exactly match the defined business rule message
        TrainConsistMgmnt.InvalidCapacityException exception =
                assertThrows(
                        TrainConsistMgmnt.InvalidCapacityException.class,
                        () -> new TrainConsistMgmnt.PassengerBogie("Sleeper", -5)
                );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation()
            throws TrainConsistMgmnt.InvalidCapacityException {
        // Valid bogie must store correct type and capacity values
        TrainConsistMgmnt.PassengerBogie bogie =
                new TrainConsistMgmnt.PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.type);
        assertEquals(24, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation()
            throws TrainConsistMgmnt.InvalidCapacityException {
        // Multiple valid bogies should all be created without exceptions
        TrainConsistMgmnt.PassengerBogie b1 =
                new TrainConsistMgmnt.PassengerBogie("Sleeper",     72);
        TrainConsistMgmnt.PassengerBogie b2 =
                new TrainConsistMgmnt.PassengerBogie("AC Chair",    56);
        TrainConsistMgmnt.PassengerBogie b3 =
                new TrainConsistMgmnt.PassengerBogie("First Class", 24);
        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
        assertEquals(72, b1.capacity);
        assertEquals(56, b2.capacity);
        assertEquals(24, b3.capacity);
    }
}
