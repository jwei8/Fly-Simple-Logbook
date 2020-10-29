package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.*;
//represents a list of logbook entries

public class LogbookRecord implements Writeable {

    private List<LogbookEntry> logBookEntries;
    private String name;



    //modifies this
    //construct a new empty list of LogBookEntry

    public LogbookRecord(String name) {
        this.name = name;
        logBookEntries = new ArrayList<>();
    }

    //effect: return the name of LogbookRecord
    public String getName() {
        return name;
    }

    // EFFECTS: returns an unmodifiable list of entries in this logbookRecord
    public List<LogbookEntry> getLogBookEntries() {
        return Collections.unmodifiableList(logBookEntries);
    }


    //requires:
    //modifies:this
    //effect: add a new entry to the bottom of the list and produce the new list

    public void addAnEntry(LogbookEntry entry) {
        logBookEntries.add(entry);
    }


    //requires:
    //modifies:this
    //effect: remove an entry by FlightNum and produce the new list
    public List<LogbookEntry> removeAnEntryByFlightNum(int num) {
        ArrayList<LogbookEntry> toRemove = new ArrayList<>();

        for (LogbookEntry log : logBookEntries) {
            if (log.entryNumber == num) {
                toRemove.add(log);
            }
        }
        logBookEntries.removeAll(toRemove);
        return logBookEntries;
    }

    //requires:
    //modifies: this
    //effect: count the number of entries in the list
    public int countEntries() {
        return logBookEntries.size();
    }


    //requires: hour > 0
    //modifies: this
    //effect: return a list of entries with flight time greater or equal to the given time
    public List<LogbookEntry> filterByFlightTime(double hour) {
        ArrayList<LogbookEntry> toKeep = new ArrayList<>();

        for (LogbookEntry entry : logBookEntries) {
            if (entry.flightTime >= hour) {
                toKeep.add(entry);
            }
        }
        return toKeep;
    }

    //requires:
    //modifies: this
    //effect: return a list of entries with day flight only, or night flight only.

    public ArrayList filterByDayOrNight(String dayOrnight) {
        ArrayList<LogbookEntry> toKeep = new ArrayList<>();

        for (LogbookEntry entry : logBookEntries) {
            if (entry.dayOrnight.equals(dayOrnight)) {
                toKeep.add(entry);
            }
        }
        return toKeep;
    }

    public List<LogbookEntry> displayAllEntry() {
        return logBookEntries;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("entries", entriesToJson());
        return json;
    }

    // EFFECTS: returns entries in this logbook record as a JSON array
    private JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (LogbookEntry l : logBookEntries) {
            jsonArray.put(l.toJson());
        }

        return jsonArray;
    }
}



