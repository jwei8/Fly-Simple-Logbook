package persistence;

import model.LogbookEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkEntry(Integer entryNumber, String month, Integer day, String airplaneModel,
                              String aircraftName, String pilotInCommand, Double flightTime, String dayOrNight,
                              String departureAirport, String arrivalAirport, String remark,
                              LogbookEntry entry) {
        assertEquals(entryNumber, entry.getEntryNumber());
        assertEquals(month, entry.getMonth());
        assertEquals(day, entry.getDay());
        assertEquals(airplaneModel, entry.getAirplaneModel());
        assertEquals(aircraftName, entry.getAirplaneName());
        assertEquals(pilotInCommand, entry.getPic());
        assertEquals(flightTime, entry.getFlightTime());
        assertEquals(dayOrNight, entry.getDayOrnight());
        assertEquals(departureAirport, entry.getDepartureAirport());
        assertEquals(arrivalAirport, entry.getArrivalAirport());
        assertEquals(remark, entry.getRemark());
    }
}
