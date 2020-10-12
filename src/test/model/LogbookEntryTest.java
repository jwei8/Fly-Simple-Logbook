package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogbookEntryTest {
    private LogbookEntry entry;
    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft("C-172M","C-GXWS", "Made by Cessna");
        entry = new LogbookEntry();
        entry.setMonth("June");
        entry.setDay(8);
        entry.setAirplaneModel("C-172M");
        entry.setCallSign("GXWS");
        entry.setPic("JWei");
        entry.setFLightTime(1.4);
        entry.setDayOrnight("Day");
        entry.setRemark("CheckRide");
    }

    @Test

    public void testLogbookEntry() {
        assertEquals("June 8", entry.getDate());
        assertEquals("JWei", entry.getPic());
        assertEquals("Day", entry.dayOrnight);
    }

}