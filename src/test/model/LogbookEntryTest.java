package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogbookEntryTest {
    private LogbookEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new LogbookEntry();
        entry.setEntryNumber(1);
        entry.setMonth("June");
        entry.setDay(8);
        entry.setAirplaneModel("C-172M");
        entry.setAirplaneName("GXWS");
        entry.setPic("JWei");
        entry.setFLightTime(1.4);
        entry.setDayOrnight("Day");
        entry.setDepartureAirport("CYNJ");
        entry.setArrivalAirport("CYVR");
        entry.setRemark("CheckRide");
    }

    @Test

    public void testLogbookEntry() {
        assertEquals(1, entry.getEntryNumber());
        assertEquals("June", entry.getMonth());
        assertEquals(8, entry.getDay());
        assertEquals("C-172M", entry.getAirplaneModel());
        assertEquals("GXWS", entry.getAirplaneName());
        assertEquals("JWei", entry.getPic());
        assertEquals(1.4, entry.getFlightTime());
        assertEquals("Day", entry.getDayOrnight());
        assertEquals("CYNJ", entry.getDepartureAirport());
        assertEquals("CYVR", entry.getArrivalAirport());
        assertEquals("CheckRide", entry.getRemark());
    }

}