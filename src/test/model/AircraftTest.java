package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AircraftTest {
    private Aircraft aircraft;

    @Test
    public void testgetAircraftInformation() {
        assertEquals("C-172M", aircraft.getAircraftType());
        assertEquals("C-GXWS", aircraft.getAircraftReg());
        assertEquals("Most popular single engine plane ever made by Cessna",
                aircraft.getAircraftDescription());
    }
}