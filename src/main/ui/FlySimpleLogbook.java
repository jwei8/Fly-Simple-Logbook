package ui;

import model.Aircraft;
import model.AircraftRecord;
import model.LogbookEntry;
import model.LogbookRecord;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FlySimpleLogbook {
    private LogbookEntry entryOne;
    private LogbookEntry entryTwo;
    private LogbookEntry entryThree;
    private LogbookEntry newEntry;
    private Aircraft newAirplane;
    private LogbookRecord record;
    private Scanner input;
    private Aircraft aircraftOne;
    private AircraftRecord aircraftRecord;
    private double searchByFlightTime;


    //effect: runs the FlySimpleLogbook application
    public FlySimpleLogbook() {
        runLogBook();
    }

    //modifies: this
    //effect: processes user input
    private void runLogBook() {
        boolean resume = true;
        String command = null;

        init();

        while (resume) {
            displayMenu();
            command = input.next();

            if (command.equals("q")) {
                resume = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye! Have a good flight");
    }

    //modifies: this
    //effect: initialize the logbook by creating some entries
    private void init() {
        input = new Scanner(System.in);
        record = new LogbookRecord();
        aircraftOne = new Aircraft();
        aircraftRecord = new AircraftRecord();
        createEntryOne();
        createEntryTwo();
        createEntryThree();
        record.addAnEntry(entryOne);
        record.addAnEntry(entryTwo);
        record.addAnEntry(entryThree);
        createAirplaneOne();
        aircraftRecord.addAirplane(aircraftOne);


    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to FLySimpleLogbook! Select from:");
        System.out.println("\ta -> Add a new entry");
        System.out.println("\tv -> View Logbook with all existing entries");
        System.out.println("\ts -> View the Fleet of aircraft");
        System.out.println("\tf -> Sort all flights by a specific filter item, such as DayOrNight or FlightTime");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addEntry();
        } else if (command.equals("v")) {
            viewLogbook();
        } else if (command.equals("s")) {
            showAircraft();
        } else if (command.equals("f")) {
            processFilterCommand();
        } else {
            System.out.println("Please enter a valid input");
        }
    }

    private void createEntryOne() {
        entryOne = new LogbookEntry();
        entryOne.setEntryNumber(1);
        entryOne.setMonth("June");
        entryOne.setDay(10);
        entryOne.setAirplaneModel("C-172M");
        entryOne.setCallSign("GXWS");
        entryOne.setPic("JWei");
        entryOne.setFLightTime(1.0);
        entryOne.setDayOrnight("Day");
        entryOne.setRemark("CheckRide");
    }

    private void createEntryTwo() {
        entryTwo = new LogbookEntry();
        entryTwo.setEntryNumber(2);
        entryTwo.setMonth("June");
        entryTwo.setDay(11);
        entryTwo.setAirplaneModel("C-172M");
        entryTwo.setCallSign("GXWS");
        entryTwo.setPic("JWei");
        entryTwo.setFLightTime(0.5);
        entryTwo.setDayOrnight("Day");
        entryTwo.setRemark("Solo");
    }

    private void createEntryThree() {
        entryThree = new LogbookEntry();
        entryThree.setEntryNumber(3);
        entryThree.setMonth("June");
        entryThree.setDay(13);
        entryThree.setAirplaneModel("C-172M");
        entryThree.setCallSign("GXWS");
        entryThree.setPic("JWei");
        entryThree.setFLightTime(0.1);
        entryThree.setDayOrnight("Night");
        entryThree.setRemark("Solo");
    }

    private void createAirplaneOne() {
        aircraftOne.setAircraftType("C-172M");
        aircraftOne.setAircraftReg("C-GXWS");
        aircraftOne.setAircraftDescription("Golf X-Ray Whiskey Sierra is smooth and always happy to go flying. "
                + "Equipped with a 150 HP Lycoming O-320 engine, "
                + "advanced avionics as a Garmin G430 WAAS enabled, "
                + "approved for precise GPS approaches, a wide VFR AvMap EKP V GPS, "
                + "modern radios and a polished panel, XWS is ideal for IFR work or backcountry flying!");
    }


    //modifies: this
    //effect: construct a new entry and add it to the logbook
    private void addEntry() {

        newEntry = new LogbookEntry();
        addEntryNumber();
        addEntryDate();
        addAircraftModel();
        addCallSign();
        addPic();
        addFlightTime();
        addDayOrNight();
        addRemark();
        record.addAnEntry(newEntry);
        System.out.println(newEntry.getFlightTime() + " " + " hour has been added successfully");
    }

    private void viewLogbook() {
        System.out.println("showing all entries");
        System.out.println(loadLogbook());
    }


    //getter
    //modifies: this
    //effect: displays all entries
    private String loadLogbook() {
        System.out.println("Showing logbook entries: ");
        String entries = "display entries";


        List<LogbookEntry> allEntry = record.displayAllEntry();

        if (allEntry.isEmpty()) {
            return "No flight has been entered";
        }

        for (LogbookEntry e : allEntry) {
            String entry = e.getEntryNumber() + "    " + e.getDate() + "    " + e.getAirplaneModel()
                    + "     " + e.getAirplaneName() + "    " + e.getPic() + "    " + e.getFlightTime()
                    + "    " + e.getDayOrnight() + "    " + "    " + e.getRemark();
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }


    private void filterMenuOption() {
        System.out.println("\nSelect filter method:");
        System.out.println("\td -> Day only");
        System.out.println("\tn -> Night only");
        System.out.println("\tl -> Show flights at least a certain length");
        System.out.println("\tu -> Use u to return to the previous menu");

    }

    private void processFilterCommand() {
        boolean keepGoing = true;
        while (keepGoing) {
            filterMenuOption();
            String command = input.next();
            if (command.equals("d")) {
                System.out.println(entryFilteredByDay());
            } else if (command.equals("n")) {
                System.out.println(entryFilteredByNight());
            } else if (command.equals("l")) {
                System.out.println("\n Enter flight time: ");
                double time = input.nextDouble();
                searchByFlightTime = time;
                System.out.println(entryFilteredByFlightTime());
            } else if (command.equals("u")) {
                if (command.equals("u")) {
                    keepGoing = false;
                } else {
                    System.out.println("Invalid entry, please try again");
                }
            }
        }
    }

    private void aircraftMenuOption() {
        System.out.println("\nSelect a option:");
        System.out.println("\tv -> View saved aircraft profiles");
        System.out.println("\ta -> Add a new airplane");
        System.out.println("\td -> Delete a saved airplane profile");
        System.out.println("\tu -> Use u to return to the previous menu");

    }


    private void showAircraft() {
        boolean keepGoing = true;
        while (keepGoing) {
            aircraftMenuOption();
            String command = input.next();
            if (command.equals("v")) {
                System.out.println(savedAircraft());
            } else if (command.equals("a")) {
                addAircraft();
            } else if (command.equals("d")) {
                removeAirplane();
            } else if (command.equals("u")) {
                if (command.equals("u")) {
                    keepGoing = false;
                }
            } else {
                System.out.println("Invalid entry, please try again");
            }
        }

    }




    //modifies: this
    //effect: filter the entries by Day
    private String savedAircraft() {
        System.out.println("Showing saved airplanes: ");
        String entries = "Showing all aircraft on file";


        List<Aircraft> allAircraft = aircraftRecord.displayAllAirplane();

        if (allAircraft.isEmpty()) {
            return "\nNo flight has been entered"
                    + "\n Enter r to choose a different item";
        }

        for (Aircraft a : allAircraft) {
            String entry = "\n" +  "Aircraft Type: " + a.getAircraftType()
                         + "\n" + "Aircraft Registration: " + a.getAircraftReg()
                         + "\n" + "Aircraft Description: " + "\n"
                         + addLinebreaks(a.getAircraftDescription(),70);
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }


    //reference: https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java
    //effect: add line breaks to long input descriptions.
    public String addLinebreaks(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken() + " ";

            if (lineLen + word.length() > maxLineLength) {
                output.append("\n");
                lineLen = 0;
            }
            output.append(word);
            lineLen += word.length();
        }
        return output.toString();
    }

    //modifies: this
    //effect: construct a new entry and add it to the logbook
    private void addAircraft() {

        newAirplane = new Aircraft();
        addAircraftType();
        addAircraftRegistration();
        addAircraftDescription();

        aircraftRecord.addAirplane(newAirplane);
        System.out.println("\n" + newAirplane.getAircraftReg() + " " + "has been added successfully");
    }

    private void removeAirplane() {
        System.out.println("Enter the registration of the aircraft wish to delete: ");
        String name = input.next();

        aircraftRecord.removeAnAircraftByReg(name);

        System.out.println("\n" + name + " has been removed");

    }



    //modifies: this
    //effect: filter the entries by Day
    private String entryFilteredByDay() {
        System.out.println("Showing logbook entries: ");
        String entries = "Showing all flight conducted during the day";


        List<LogbookEntry> allEntry = record.filterByDayOrNight("Day");

        if (allEntry.isEmpty()) {
            return "\nNo flight has been entered"
                    + "\n Enter r to choose a different item";
        }

        for (LogbookEntry e : allEntry) {
            String entry = e.getEntryNumber() + "    " + e.getDate() + "    " + e.getAirplaneModel()
                    + "     " + e.getAirplaneName() + "    " + e.getPic() + "    " + e.getFlightTime()
                    + "    " + e.getDayOrnight() + "    " + "    " + e.getRemark();
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }

    //modifies: this
    //effect: filter the entries by Night
    private String entryFilteredByNight() {
        System.out.println("Showing logbook entries: ");
        String entries = "Showing all flights at night";

        List<LogbookEntry> allEntry = record.filterByDayOrNight("Night");

        if (allEntry.isEmpty()) {
            return "\nNo flight has been entered"
                    + "\n Enter r to choose a different item";
        }

        for (LogbookEntry e : allEntry) {
            String entry = e.getEntryNumber() + "    " + e.getDate() + "    " + e.getAirplaneModel()
                    + "     " + e.getAirplaneName() + "    " + e.getPic() + "    " + e.getFlightTime()
                    + "    " + e.getDayOrnight() + "    " + "    " + e.getRemark();
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }

    //modifies: this
    //effect: filter the entries by flight time
    private String entryFilteredByFlightTime() {
        System.out.println("Showing logbook entries: ");
        String entries = "Showing all flights with at or above " + searchByFlightTime + "hour";


        List<LogbookEntry> allEntry = record.filterByFlightTime(searchByFlightTime);

        if (allEntry.isEmpty()) {
            return "\nThere is no such entry that qualifies the minimum flight time. ";
        }

        for (LogbookEntry e : allEntry) {
            String entry = e.getEntryNumber() + "    " + e.getDate() + "    " + e.getAirplaneModel()
                    + "     " + e.getAirplaneName() + "    " + e.getPic() + "    " + e.getFlightTime()
                    + "    " + e.getDayOrnight() + "    " + "    " + e.getRemark();
            entries = entries.concat("\n" + entry);
        }
        return entries;
    }

    //require: input is positive int
    //modifies: this
    //effect add entry number to the new entry
    private void addEntryNumber() {
        System.out.println("\nEnter entry number");
        int entryNumber = input.nextInt();
        newEntry.setEntryNumber(entryNumber);
        System.out.println("Entry Number is set to: " + entryNumber);
    }

    //require: input for month is non empty String, int for month
    //modifies: this
    //effect add entry number
    private void addEntryDate() {
        System.out.println("\nEnter Month");
        String month = input.next();
        newEntry.setMonth(month);
        System.out.println("\nEnter Day");
        int day = input.nextInt();

        while (day <=  1 || day > 31) {
            System.out.println("Day must be in the range between 1 to 31");
            day = input.nextInt();
        }


        newEntry.setDay(day);
        System.out.println("Date of the flight: " + month + " " + day);
    }

    //require: input for aircraft model is non-empty string
    //modifies: this
    //effect add aircraft model
    private void addAircraftModel() {
        System.out.println("\nEnter aircraft model");
        String make = input.next();
        newEntry.setAirplaneModel(make);
        System.out.println("Date of the flight: " + make);
    }

    //require: input for aircraft callsign is non-empty string
    //modifies: this
    //effect add callsign
    private void addCallSign() {
        System.out.println("\nEnter the last four letters of the registration maker, ex:GABC");
        String callSign = input.next();
        newEntry.setCallSign(callSign);
        System.out.println("Aircraft Name: " + callSign);
    }

    //require: input for pilot name is non empty string
    //modifies: this
    //effect add pilot name
    private void addPic() {
        System.out.println("\nEnter Pilot name");
        String pic = input.next();
        newEntry.setPic(pic);
        System.out.println("Pilot in Command is: " + pic);
    }

    //require: input for pilot name is a double
    //modifies: this
    //effect add flight time
    private void addFlightTime() {
        System.out.println("\nEnter the flight time, ex 1.0");
        double flightTime = input.nextDouble();
        while (flightTime <= 0) {
            System.out.println("flight time must be greater than 0");
            flightTime = input.nextDouble();
        }
        newEntry.setFLightTime(flightTime);
        System.out.println("Total flight time of this flight: " + flightTime);
    }

    //require: non empty string
    //modifies: this
    //effect assign day or night flight
    private void addDayOrNight() {
        System.out.print("\nEnter d for day flight or n for night flight");
        String key = input.nextLine();
        while (!key.equals("d") & !key.equals("n")) {
            System.out.println("please enter either d or n");
            key = input.nextLine();
        }
        if (key.equals("d")) {
            newEntry.setDayOrnight("Day");
            System.out.println("This flight was conducted during the day");

        } else if (key.equals("n")) {
            newEntry.setDayOrnight("Night");
            System.out.println("This flight was conducted during the hour of darkness");
        }
    }

    //require: input for remark is non empty string
    //modifies: this
    //effect add notes to flight
    private void addRemark() {
        System.out.print("\nRemark or notes for this flight");
        String note = input.nextLine();
        newEntry.setRemark(note);
        System.out.println("Note to this flight: " + note);
    }

    //require: input for aircraftType is non empty string
    //modifies: this
    //effect add aircraftType
    private void addAircraftType() {
        System.out.println("\nEnter aircraft type");
        String type = input.next();
        input.nextLine();
        newAirplane.setAircraftType(type);
        System.out.println("Airplane type/model: " + type);
    }


    //require: input for aircraftType is non empty string
    //modifies: this
    //effect add aircraftRegistration
    private void addAircraftRegistration() {
        System.out.println("\nEnter aircraft registration, ex C-GABC");
        String reg = input.nextLine();
        newAirplane.setAircraftReg(reg);
        System.out.println("Airplane registration: " + reg);
    }


    //require: input for aircraftDescription is non empty string
    //modifies: this
    //effect add aircraft description
    private void addAircraftDescription() {
        System.out.println("\nEnter aircraft description");
        String note = input.nextLine();
        newAirplane.setAircraftDescription(note);
        System.out.println("Airplane description: " + addLinebreaks(note,70));
    }
}
