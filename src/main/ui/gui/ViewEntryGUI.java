package ui.gui;

import model.LogbookEntry;
import model.LogbookRecord;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ViewEntryGUI {
    private JFrame viewEntry;
    private JPanel displayEntry;
    private int frameWidth = 1200;
    private int frameHeight = 400;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/logbookRecord.json";
    private LogbookRecord record;
    private List<LogbookEntry> log;
    private JLabel entryNumTitle;
    private JLabel monthTitle;
    private JLabel dayTitle;
    private JLabel airplaneModelTitle;
    private JLabel airplaneNameTitle;
    private JLabel picTitle;
    private JLabel flightTimeTitle;
    private JLabel dayOrnightTitle;
    private JLabel departureTitle;
    private JLabel arrivalTitle;
    private JLabel noteTitle;
    private JScrollPane panel;

    JLabel month;
    JLabel day;
    JLabel airplaneModel;
    JLabel airplaneName;
    JLabel pic;
    JLabel flightTime;
    JLabel dayOrNight;
    JLabel departure;
    JLabel arrival;
    JLabel note;


    public ViewEntryGUI() {
        viewEntry = new JFrame("Log entries on file");
        displayEntry = new JPanel();
        viewEntry.setLayout(new BorderLayout());
        viewEntry.setSize(frameWidth, frameHeight);
        viewEntry.setLocationRelativeTo(null);
        displayEntry.setBackground(Color.LIGHT_GRAY);
        record = new LogbookRecord("record");
        jsonReader = new JsonReader(JSON_STORE);
        loadLogbook();
        printLogbook();
        viewLogbook();
        printEntry();
        panel = new JScrollPane(displayEntry);
        viewEntry.add(panel);
        viewEntry.setVisible(true);

        //viewEntry.pack();
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
        entryNumberTitle(gc);

        titleForFlightInforPartOne();

        titleForFlightInfoPartTwo();

        for (LogbookEntry e : allEntry) {
            JLabel entryNum = new JLabel(Integer.toString(e.getEntryNumber()));
            JLabel month = new JLabel(e.getMonth());
            JLabel day = new JLabel(Integer.toString(e.getDay()));
            JLabel airplaneModel = new JLabel(e.getAirplaneModel());
            JLabel airplaneName = new JLabel(e.getAirplaneName());
            JLabel pic = new JLabel(e.getPic());
            JLabel flightTime = new JLabel(Double.toString(e.getFlightTime()));
            JLabel dayOrNight = new JLabel(e.getDayOrnight());
            JLabel departure = new JLabel(e.getDepartureAirport());
            JLabel arrival = new JLabel(e.getArrivalAirport());
            JLabel note = new JLabel(e.getRemark());
            int valueOfy = allEntry.indexOf(e) + 1;
            entryInformation(gc, entryNum, month, day, airplaneModel, airplaneName, pic,
                    flightTime, dayOrNight, departure, arrival, note, valueOfy);
        }
    }

    //REQUIRES: GridBagConstraints
    //MODIFIES: this
    //EFFECT: construct a title for entry number column
    private void entryNumberTitle(GridBagConstraints gc) {
        gc.weightx = 5;
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 0;
        displayEntry.add(entryNumTitle, gc);
    }

    private void entryInformation(GridBagConstraints gc, JLabel entryNum, JLabel month, JLabel day,
                                  JLabel airplaneModel, JLabel airplaneName, JLabel pic, JLabel flightTime,
                                  JLabel dayOrNight, JLabel departure, JLabel arrival, JLabel note, int valueOfy) {
        gc.gridx = 0;
        gc.gridy = valueOfy;
        displayEntry.add(entryNum, gc);
        entryDate(gc, month, day, valueOfy, 2, 4);
        entryAircraftInfo(gc, airplaneModel, airplaneName, valueOfy, 6, 8);
        gc.gridx = 10;
        gc.gridy = valueOfy;
        displayEntry.add(pic, gc);
        gc.gridx = 12;
        gc.gridy = valueOfy;
        displayEntry.add(flightTime, gc);
        gc.gridx = 14;
        gc.gridy = valueOfy;
        displayEntry.add(dayOrNight, gc);
        entryRouteInfo(gc, departure, arrival, valueOfy, 16, 18);
        gc.gridx = 20;
        gc.gridy = valueOfy;
        gc.weightx = 5;
        displayEntry.add(note, gc);
    }

    //REQUIRES: GridBagConstraints, JLabel departure, JLabel arrival, int
    //MODIFIES: this
    //EFFECT: position the departure and arrival airport information on the grid
    private void entryRouteInfo(GridBagConstraints gc, JLabel departure, JLabel arrival, int valueOfy, int i, int i2) {
        gc.gridx = i;
        gc.gridy = valueOfy;
        displayEntry.add(departure, gc);
        gc.gridx = i2;
        gc.gridy = valueOfy;
        displayEntry.add(arrival, gc);
    }

    //REQUIRES: GridBagConstraints, JLabel airplaneModel, JLabel airplaneName, int
    //MODIFIES: this
    //EFFECT: position aircraft model and name on the grid
    private void entryAircraftInfo(GridBagConstraints gc, JLabel airplaneModel, JLabel airplaneName,
                                   int valueOfy, int i, int i2) {
        gc.gridx = i;
        gc.gridy = valueOfy;
        displayEntry.add(airplaneModel, gc);
        gc.gridx = i2;
        gc.gridy = valueOfy;
        displayEntry.add(airplaneName, gc);
    }

    //REQUIRES: GridBagConstraints, JLabel month, JLabel day, int
    //MODIFIES: this
    //EFFECT: position the date information on the grid.
    private void entryDate(GridBagConstraints gc, JLabel month, JLabel day, int valueOfy, int i, int i2) {
        gc.gridx = i;
        gc.gridy = valueOfy;
        displayEntry.add(month, gc);
        gc.gridx = i2;
        gc.gridy = valueOfy;
        displayEntry.add(day, gc);
    }


    private void titleForFlightInforPartOne() {
        GridBagConstraints gc = new GridBagConstraints();
        entryDate(gc, monthTitle, dayTitle, 0, 2, 4);
        entryAircraftInfo(gc, airplaneModelTitle, airplaneNameTitle, 0, 6, 8);
    }

    private void titleForFlightInfoPartTwo() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 10;
        gc.gridy = 0;
        displayEntry.add(picTitle, gc);

        gc.gridx = 12;
        gc.gridy = 0;
        displayEntry.add(flightTimeTitle, gc);

        gc.gridx = 14;
        gc.gridy = 0;
        displayEntry.add(dayOrnightTitle, gc);

        entryRouteInfo(gc, departureTitle, arrivalTitle, 0, 16, 18);

        gc.gridx = 20;
        gc.gridy = 0;
        gc.weightx = 10;
        displayEntry.add(noteTitle, gc);

        gc.insets = new Insets(5, 10, 5, 10);
        viewEntry.add(displayEntry, BorderLayout.NORTH);

    }

    private void createColumnName() {
        entryNumTitle = new JLabel("Entry Number");
        monthTitle = new JLabel("Month");
        dayTitle = new JLabel("Day");
        airplaneModelTitle = new JLabel("Aircraft model");
        airplaneNameTitle = new JLabel("Registration");
        picTitle = new JLabel("Pilot in Command");
        flightTimeTitle = new JLabel("Flight time");
        dayOrnightTitle = new JLabel("Day or Night");
        departureTitle = new JLabel("Departure airport");
        arrivalTitle = new JLabel("Destination airport");
        noteTitle = new JLabel("Remark");
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
