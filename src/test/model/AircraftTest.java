package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AircraftTest {
    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft("C-172M","C-GXWS", "Made by Cessna");
    }

    @Test
    public void testgetAircraftTypeAndReg() {
        assertEquals("C-172M", aircraft.getAircraftType());
        assertEquals("C-GXWS", aircraft.getAircraftReg());
    }

    @Test
    public void testEditDescription() {
        String updatedDescription = "Cessna 172 is the most produced single engine plane ever built";
        assertEquals(updatedDescription, aircraft.editDescription(updatedDescription));
    }
}