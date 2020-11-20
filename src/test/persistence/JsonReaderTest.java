package persistence;

import exceptions.InvalidInputException;
import model.LogbookEntry;
import model.LogbookRecord;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() throws InvalidInputException {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            LogbookRecord log = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLogbookRecord() throws InvalidInputException {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLogbookRecord.json");
        try {
            LogbookRecord log = reader.read();
            assertEquals("my logbook", log.getName());
            assertEquals(0, log.countEntries());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLogbookRecord() throws InvalidInputException {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLogbookRecord.json");
        try {
            LogbookRecord log = reader.read();
            assertEquals("my logbook", log.getName());
            List<LogbookEntry> entries = log.getLogBookEntries();
            assertEquals(2, entries.size());
            checkEntry(1, "August", 8, "C-172M", "GXWS",
                    "Jwei", 1.8, "day", "CYYJ", "CYNJ",
                    "good flight", entries.get(0));
            checkEntry(2, "September", 9, "C-172N", "GXPH",
                    "Wkim", 1.2, "night", "CYNJ", "CYVR",
                    " ", entries.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
