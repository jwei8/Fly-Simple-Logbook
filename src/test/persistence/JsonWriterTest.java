package persistence;

import model.LogbookEntry;
import model.LogbookRecord;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            LogbookRecord log = new LogbookRecord("my logbook");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLogbookRecord() {
        try {
            LogbookRecord log = new LogbookRecord("my logbook");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLogbookRecord.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLogbookRecord.json");
            log = reader.read();
            assertEquals("my logbook", log.getName());
            assertEquals(0, log.countEntries());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralLogbookRecord() {
        try {
            LogbookEntry entryOne = new LogbookEntry();
            LogbookEntry entryTwo = new LogbookEntry();

            entryOne.setEntryNumber(1);
            entryOne.setMonth("August");
            entryOne.setDay(8);
            entryOne.setAirplaneModel("C-172M");
            entryOne.setAirplaneName("GXWS");
            entryOne.setPic("Jwei");
            entryOne.setFLightTime(1.8);
            entryOne.setDayOrnight("Day");
            entryOne.setDepartureAirport("CYYJ");
            entryOne.setArrivalAirport("CYNJ");
            entryOne.setRemark("good flight");

            entryTwo.setEntryNumber(2);
            entryTwo.setMonth("September");
            entryTwo.setDay(9);
            entryTwo.setAirplaneModel("C-172M");
            entryTwo.setAirplaneName("GXWS");
            entryTwo.setPic("Jwei");
            entryTwo.setFLightTime(1.2);
            entryTwo.setDayOrnight("Day");
            entryTwo.setDepartureAirport("CYNJ");
            entryTwo.setArrivalAirport("CYVR");
            entryTwo.setRemark("");
            LogbookRecord log = new LogbookRecord("my logbook");
            log.addAnEntry(entryOne);
            log.addAnEntry(entryTwo);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLogbookRecord.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLogbookRecord.json");
            log = reader.read();
            assertEquals("my logbook", log.getName());
            List<LogbookEntry> entries = log.getLogBookEntries();
            assertEquals(2, entries.size());
            checkEntry(1, "August", 8, "C-172M", "GXWS",
                    "Jwei", 1.8, "Day", "CYYJ", "CYNJ",
                    "good flight", entries.get(0));
            checkEntry(2, "September", 9, "C-172M", "GXWS",
                    "Jwei", 1.2, "Day", "CYNJ", "CYVR",
                    "", entries.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
