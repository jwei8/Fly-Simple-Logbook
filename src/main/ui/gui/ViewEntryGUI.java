package ui.gui;

import model.LogbookEntry;
import model.LogbookRecord;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewEntryGUI {
    private JFrame viewEntry;
    private JPanel displayEntry;
    private int frameWidth = 1000;
    private int frameHeight = 400;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/logbookRecord.json";
    private LogbookRecord record;
    private List<LogbookEntry> log;
    private JLabel entryNum;
    private JLabel month;
    private JLabel day;
    private JLabel airplaneModel;
    private  JLabel airplaneName;
    private JLabel pic;
    private JLabel flightTime;
    private JLabel dayOrnight;
    private JLabel departure;
    private JLabel arrival;
    private JLabel note;


    public ViewEntryGUI() {
        viewEntry = new JFrame("Log entries on file");
        displayEntry = new JPanel();
        viewEntry.setSize(frameWidth, frameHeight);
        viewEntry.setLocationRelativeTo(null);
        viewEntry.add(displayEntry);
        viewEntry.setVisible(true);
        record = new LogbookRecord("record");
        jsonReader = new JsonReader(JSON_STORE);
        loadLogbook();
        printLogbook();
        viewLogbook();
        printEntry();
    }

    private void setUpEntryPanel() {
        displayEntry = new JPanel();
    }

    //EFFECT: read the Json file to load existing entries
    private void loadLogbook() {
        try {
            record = jsonReader.read();
            System.out.println("Loaded " + record.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    private void printEntry() {
        List<LogbookEntry> allEntry = record.displayAllEntry();
        createColumnName();
        displayEntry.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        displayEntry.add(entryNum,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        displayEntry.add(month,gc);

        gc.gridx = 2;
        gc.gridy = 0;
        displayEntry.add(day,gc);

        gc.gridx = 3;
        gc.gridy = 0;
        displayEntry.add(airplaneModel,gc);

        gc.gridx = 4;
        gc.gridy = 0;
        displayEntry.add(airplaneName,gc);

        gc.gridx = 5;
        gc.gridy = 0;
        displayEntry.add(pic,gc);

        gc.gridx = 6;
        gc.gridy = 0;
        displayEntry.add(flightTime,gc);

        gc.gridx = 7;
        gc.gridy = 0;
        displayEntry.add(dayOrnight,gc);

        gc.gridx = 8;
        gc.gridy = 0;
        displayEntry.add(departure,gc);

        gc.gridx = 9;
        gc.gridy = 0;
        displayEntry.add(arrival,gc);

        gc.gridx = 10;
        gc.gridy = 0;
        gc.weightx = 10;
        displayEntry.add(note,gc);

        gc.insets = new Insets(5, 5, 5, 5);
        int i = 0;
        for (LogbookEntry e : allEntry) {
            System.out.println("yee");
        }
    }

    private void createColumnName() {
        entryNum = new JLabel("Entry Number");
        month = new JLabel("Month");
        day = new JLabel("Day");
        airplaneModel = new JLabel("Aircraft model");
        airplaneName = new JLabel("Registration");
        pic = new JLabel("Pilot in Command");
        flightTime = new JLabel("Flight time");
        dayOrnight = new JLabel("Day or Night");
        departure = new JLabel("Departure airport");
        arrival = new JLabel("Destination airport");
        note = new JLabel("Remark");
    }

    private void viewLogbook() {
        System.out.println("showing all entries");
        System.out.println(printLogbook());
    }

    //getter
    //modifies: this
    //effect: displays all entries

    private String printLogbook() {
        System.out.println("Showing logbook entries: ");
        String entries = "display entries";

        List<LogbookEntry> allEntry = record.displayAllEntry();

        if (allEntry.isEmpty()) {
            return "No flight has been entered";
        }

        for (LogbookEntry e : allEntry) {
            String entry = e.getEntryNumber() + "    " + e.getMonth() + " " + e.getDay() + "    " + e.getAirplaneModel()
                    + "     " + e.getAirplaneName() + "    " + e.getPic() + "    " + e.getFlightTime()
                    + "    " + e.getDayOrnight() + "    " + e.getDepartureAirport() + "    "
                    + e.getArrivalAirport() + "    " + e.getRemark();
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }


}
