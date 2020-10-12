package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AircraftTest {
    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft();
        aircraft.setAircraftType("C-172M");
        aircraft.setAircraftReg("C-GXWS");
        aircraft.setAircraftDescription("Most popular single engine plane ever made by Cessna");
    }

    @Test
    public void testgetAircraftInformation() {
        assertEquals("C-172M", aircraft.getAircraftType());
        assertEquals("C-GXWS", aircraft.getAircraftReg());
        assertEquals("Most popular single engine plane ever made by Cessna",
                aircraft.getAircraftDescription());
    }
}