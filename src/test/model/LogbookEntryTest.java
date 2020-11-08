package model;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.InvalidDayOrNightException;
import exceptions.InvalidInputException;
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

    @Test
    public void testThrowInvalidInputExceptionDayTooSmall() {
        try {
            entry.setDay(0);
            entry.throwExceptionInvalidInput();
            fail("InvalidInpuException should be thrown");
        } catch (InvalidInputException e) {
            //expected
        }
    }

    @Test
    public void testThrowInvalidInputExceptionDayTooBig() {
        try {
            entry.setDay(32);
            entry.throwExceptionInvalidInput();
            fail("InvalidInputException should be thrown");
        } catch (InvalidInputException e) {
            //expected
        }
    }

    @Test
    public void testThrowInvalidInputExceptionDay() {
        try {
            entry.setDay(15);
            entry.throwExceptionInvalidInput();
        } catch (InvalidInputException e) {
            fail("InvalidInputException should not be thrown");
        }
    }

    @Test
    public void testThrowInvalidEntryNumberNoException() {
        try {
            entry.setEntryNumber(13);
            entry.throwExceptionInvalidInput();
        } catch (InvalidInputException e) {
            fail("InvalidInputException should not be thrown");
        }
    }

    @Test
    public void testThrowInvalidInputExceptionEntryNumber() {
        try {
            entry.setEntryNumber(-20);
            entry.throwExceptionInvalidInput();
            fail("InvalidInputException should be thrown");
        } catch (InvalidInputException e) {
            //expected
        }
    }

    @Test
    public void testThrowInvalidDayOrNightExceptionNotDay() {

        try {
            entry.setDayOrnight("neither");
            entry.throwExceptionDayOrNight();
            fail("InvalidDayOrNightException should be thrown");
        } catch (InvalidDayOrNightException e) {
            //expected
        }
    }

    @Test
    public void testThrowInvalidDayOrNightExceptionNight() {
        try {
            entry.setDayOrnight("night");
            entry.throwExceptionDayOrNight();
        } catch (InvalidDayOrNightException e) {
            fail("InvalidDayOrNightException should not be thrown");

        }
    }

    @Test
    public void testThrowInvalidDayOrNightExceptionNotNight() {

        try {
            entry.setDayOrnight("day");
            entry.throwExceptionDayOrNight();
        } catch (InvalidDayOrNightException e) {
            fail("InvalidDayOrNightException should not be thrown");
        }
    }


}