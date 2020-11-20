package model;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LogbookRecordTest {
    private LogbookEntry entryOne;
    private LogbookEntry entryTwo;
    private LogbookEntry entryThree;
    private LogbookEntry entryFour;
    private LogbookRecord record;

    @BeforeEach
    public void setUp() {
        entryOne = new LogbookEntry();
        entryOne.setEntryNumber(1);
        entryOne.setMonth("June");
        try {
            entryOne.setDay(8);
            entryOne.setAirplaneModel("C-172M");
            entryOne.setAirplaneName("GXWS");
            entryOne.setPic("JWei");
            entryOne.setFLightTime(1.0);
            entryOne.setDayOrNight("Day");
            entryOne.setDepartureAirport("CYNJ");
            entryOne.setArrivalAirport("CYVR");
            entryOne.setRemark("CheckRide");

            entryTwo = new LogbookEntry();
            entryTwo.setEntryNumber(2);
            entryTwo.setMonth("June");

            entryTwo.setDay(8);

            entryTwo.setAirplaneModel("C-172M");
            entryTwo.setAirplaneName("GXWS");
            entryTwo.setPic("JWei");
            entryTwo.setFLightTime(0.5);
            entryTwo.setDayOrNight("Night");
            entryTwo.setDepartureAirport("CYNJ");
            entryTwo.setArrivalAirport("CYVR");
            entryTwo.setRemark("Solo");

            entryThree = new LogbookEntry();
            entryThree.setEntryNumber(3);
            entryThree.setMonth("June");

            entryThree.setDay(10);

            entryThree.setAirplaneModel("C-172M");
            entryThree.setAirplaneName("GXWS");
            entryThree.setPic("JWei");
            entryThree.setFLightTime(0.1);
            entryThree.setDayOrNight("Night");
            entryThree.setDepartureAirport("CYYJ");
            entryThree.setArrivalAirport("CYCW");
            entryThree.setRemark("Solo");

            entryFour = new LogbookEntry();
            entryFour.setEntryNumber(3);
            entryFour.setMonth("June");
            entryFour.setDay(10);
            entryFour.setAirplaneModel("C-172M");
            entryFour.setAirplaneName("GXWS");
            entryFour.setPic("JWei");
            entryFour.setFLightTime(1.1);
            entryFour.setDepartureAirport("CYNJ");
            entryFour.setArrivalAirport("CYXX");
            entryFour.setRemark("Solo");

            record = new LogbookRecord("record for display");
            record.addAnEntry(entryOne);
            record.addAnEntry(entryTwo);
            record.addAnEntry(entryThree);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAddAnEntry() {
        record.addAnEntry(entryThree);
        assertEquals(4, record.countEntries());


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
        List<LogbookEntry> result = record.filterByFlightTime(0.5);
        assertEquals(2, result.size());
    }

    @Test
    public void testFilterByFlighttimeWithNoReminder() {
        List<LogbookEntry> result = record.filterByFlightTime(2.5);
        assertEquals(0, result.size());
    }

    @Test
    public void testFilterByFlighttimeRemoveNothing() {
        assertEquals(3, record.filterByFlightTime(0.1).size());
    }

    @Test
    public void testFilterByDayOrNight() {
        assertEquals(1, (record.filterByDayOrNight("Day")).size());
        assertEquals(2, (record.filterByDayOrNight("Night")).size());
    }

    @Test
    public void testDisplayAllEntries() {
        assertTrue(record.displayAllEntry().contains(entryOne));
    }

}