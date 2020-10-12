package ui;

import model.Aircraft;
import model.LogbookEntry;
import model.LogbookRecord;

import java.util.List;
import java.util.Scanner;

public class FlySimpleLogbook {
    private LogbookEntry entryOne;
    private LogbookEntry entryTwo;
    private LogbookEntry entryThree;
    private LogbookEntry newEntry;
    private LogbookRecord record;
    private Scanner input;
    private Aircraft aircraftOne;
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
        aircraftOne = new Aircraft("C-172M", "GXWS", "Made by Cessna");
        input = new Scanner(System.in);
        record = new LogbookRecord();
        createEntryOne();
        createEntryTwo();
        createEntryThree();
        record.addAnEntry(entryOne);
        record.addAnEntry(entryTwo);
        record.addAnEntry(entryThree);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to FLySimpleLogbook! Select from:");
        System.out.println("\ta -> Add a new entry");
        System.out.println("\tv -> View Logbook wiith all existing entries");
        System.out.println("\ts -> Show saved aircraft profiles on file");
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
                System.out.println("\n Enter flight time:");
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


    private void showAircraft() {
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


    private void addEntryNumber() {
        System.out.println("\nEnter entry number");
        int entryNumber = input.nextInt();
        newEntry.setEntryNumber(entryNumber);
        System.out.println("Entry Number is set to: " + entryNumber);
    }

    private void addEntryDate() {
        System.out.println("\nEnter Month");
        String month = input.next();
        newEntry.setMonth(month);
        System.out.println("Enter Day");
        int day = input.nextInt();

        while (day > 31 && day < 1) {
            System.out.println("\nday has to be between 1 or 31");
            day = input.nextInt();
        }
        newEntry.setDay(day);
        System.out.println("Date of the flight: " + month + " " + day);
    }

    private void addAircraftModel() {
        System.out.println("\nEnter aircraft model");
        String make = input.next();
        newEntry.setAirplaneModel(make);
        System.out.println("Date of the flight: " + make);
    }

    private void addCallSign() {
        System.out.println("\nEnter the last four letters of the registration maker, ex:GABC");
        String callSign = input.next();
        newEntry.setCallSign(callSign);
        System.out.println("Aircraft Name: " + callSign);
    }

    private void addPic() {
        System.out.println("\nEnter Pilot name");
        String pic = input.next();
        newEntry.setPic(pic);
        System.out.println("Pilot in Command is: " + pic);
    }

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

    private void addRemark() {
        System.out.print("\nRemark or notes for this flight");
        String note = input.nextLine();
        newEntry.setRemark(note);
        System.out.println("Note to this flight: " + note);
    }
}
