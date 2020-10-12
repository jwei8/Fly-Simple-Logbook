package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AircraftRecordTest {
    private AircraftRecord record;
    private Aircraft aircraftOne;
    private Aircraft aircraftTwo;

    @BeforeEach
    public void setUp() {
        record = new AircraftRecord();
        aircraftOne = new Aircraft();
        aircraftTwo = new Aircraft();
        aircraftOne.setAircraftType("C-172M");
        aircraftOne.setAircraftReg("C-GXWS");
        aircraftOne.setAircraftDescription("White with blue strips");
        aircraftTwo.setAircraftType("DA-40");
        aircraftTwo.setAircraftReg("C-GPPV");
        aircraftTwo.setAircraftDescription("white with red strips");
        record.addAirplane(aircraftOne);
        record.addAirplane(aircraftTwo);
    }

    @Test
    public void testRemoveAnAircraftByReg() {
        List<Aircraft> result = record.removeAnAircraftByReg("C-GXWS");
        assertEquals(2, record.countNumberOfAircraft());
        assertEquals(1,result.size());
    }

    @Test
    public void testDisplayAllAircraft() {
        assertTrue(record.displayAllAirplane().contains(aircraftOne));
    }


}
