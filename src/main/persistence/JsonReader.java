package persistence;

// Represents a reader that reads workroom from JSON data stored in file
// code adapted and re modeled based on the JsonSerializationDemo

import exceptions.InvalidInputException;
import model.LogbookEntry;
import model.LogbookRecord;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;


public class JsonReader {
    private String source;


    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;

    }

    // EFFECTS: reads logbookrecord from file and returns it;
    // throws IOException if an error occurs reading data from file
    public LogbookRecord read() throws IOException, InvalidInputException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLogbookRecord(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses logbook record from JSON object and returns it
    public LogbookRecord parseLogbookRecord(JSONObject jsonObject) throws InvalidInputException {
        String name = jsonObject.getString("name");
        LogbookRecord log = new LogbookRecord(name);
        addEntries(log, jsonObject);
        return log;
    }

    // MODIFIES: log
    // EFFECTS: parses logbook record  from JSON object and adds them to logbook record
    public void addEntries(LogbookRecord log, JSONObject jsonObject) throws InvalidInputException {
        JSONArray jsonArray = jsonObject.getJSONArray("entries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addEntry(log, nextEntry);
        }
    }

    // MODIFIES: log
    // EFFECTS: parses log entries from JSON object and adds it to logbookRecord
    public void addEntry(LogbookRecord log, JSONObject jsonObject) throws InvalidInputException {
        int entryNumber = jsonObject.getInt("entryNumber");
        String month = jsonObject.getString("month");
        int day = jsonObject.getInt("day");
        String airplaneModel = jsonObject.getString("airplaneModel");
        String aircraftName = jsonObject.getString("aircraftName");
        String pilotInCommand = jsonObject.getString("pilotInCommand");
        Double flightTime = jsonObject.getDouble("flightTime");
        String dayOrNight = jsonObject.getString("dayOrNight");
        String departureAirport = jsonObject.getString("departureAirport");
        String arrivalAirport = jsonObject.getString("arrivalAirport");
        String remark = jsonObject.getString("remark");

        LogbookEntry entry = new LogbookEntry();
        inputEntry(entryNumber, month, day, airplaneModel, aircraftName, pilotInCommand, flightTime,
                dayOrNight, departureAirport, arrivalAirport, remark, entry, log);
    }

    // MODIFIES: log
    // EFFECTS: set the user input for the entry in the logbookRecord
    public void inputEntry(int entryNumber, String month, Integer day, String airplaneModel,
                           String aircraftName, String pilotInCommand, Double flightTime,
                           String dayOrNight, String departureAirport, String arrivalAirport,
                           String remark, LogbookEntry entry, LogbookRecord log) throws InvalidInputException {

        entry.setEntryNumber(entryNumber);
        entry.setMonth(month);
        entry.setDay(day);
        entry.setAirplaneModel(airplaneModel);
        entry.setAirplaneName(aircraftName);
        entry.setPic(pilotInCommand);
        entry.setFlightTime(flightTime);
        entry.setDayOrNight(dayOrNight);
        entry.setDepartureAirport(departureAirport);
        entry.setArrivalAirport(arrivalAirport);
        entry.setRemark(remark);
        log.addAnEntry(entry);
    }
}
