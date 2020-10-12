package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogbookRecordTest {
    private LogbookEntry entryOne;
    private LogbookEntry entryTwo;
    private LogbookEntry entryThree;
    private Aircraft aircraft;
    public String callSign;
    private LogbookRecord record;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft("C-172M", callSign, "Made by Cessna");
        entryOne = new LogbookEntry();
        entryOne.setEntryNumber(1);
        entryOne.setMonth("June");
        entryOne.setDay(8);
        entryOne.setAirplaneModel("C-172M");
        entryOne.setCallSign("GXWS");
        entryOne.setPic("JWei");
        entryOne.setFLightTime(1.0);
        entryOne.setDayOrnight("Day");
        entryOne.setRemark("CheckRide");

        entryTwo = new LogbookEntry();
        entryTwo.setEntryNumber(2);
        entryTwo.setMonth("June");
        entryTwo.setDay(8);
        entryTwo.setAirplaneModel("C-172M");
        entryTwo.setCallSign("GXWS");
        entryTwo.setPic("JWei");
        entryTwo.setFLightTime(0.5);
        entryTwo.setDayOrnight("Night");
        entryTwo.setRemark("Solo");

        entryThree = new LogbookEntry();
        entryThree.setEntryNumber(3);
        entryThree.setMonth("June");
        entryThree.setDay(10);
        entryThree.setAirplaneModel("C-172M");
        entryThree.setCallSign("GXWS");
        entryThree.setPic("JWei");
        entryThree.setFLightTime(0.1);
        entryThree.setDayOrnight("Night");
        entryThree.setRemark("Solo");

        record = new LogbookRecord();
        record.addAnEntry(entryOne);
        record.addAnEntry(entryTwo);
        record.addAnEntry(entryThree);
    }

    @Test
    public void testAddAnEntry() {
        assertEquals("June 8", entryOne.getDate());
        assertEquals("JWei", entryOne.getPic());
        assertEquals(3, record.countEntries());


    }

    @Test
    public void testRemoveAnEntryExist() {
        assertEquals(3, record.countEntries());
        record.removeAnEntryByFlightNum(2);
        assertEquals(2, record.countEntries());
    }

    @Test
    public void testRemoveAnEntryDoesNotExist() {
        assertEquals(3, record.countEntries());
        record.removeAnEntryByFlightNum(4);
        assertEquals(3, record.countEntries());
    }


    @Test
    public void testFilterByFlighttimeWithReminder() {
        record.filterByFlightTime(0.5);
        assertEquals(2, record.countEntries());
    }

    @Test
    public void testFilterByFlighttimeWithNoReminder() {
        record.filterByFlightTime(2.5);
        assertEquals(0, record.countEntries());
    }

    @Test
    public void testFilterByFlighttimeRemoveNothing() {
        record.filterByFlightTime(0.1);
        assertEquals(3, record.countEntries());
    }

    @Test
    public void testFilterByDayOrNight() {
        assertEquals(1, (record.filterByDayOrNight("Day")).size());
        assertEquals(2, (record.filterByDayOrNight("Night")).size());
    }

}