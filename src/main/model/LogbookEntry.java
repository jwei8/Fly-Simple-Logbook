package model;

//represent one logbook entry with flight information

import exceptions.InvalidInputException;
import org.json.JSONObject;
import persistence.Writeable;

public class LogbookEntry implements Writeable {

    public String month;
    public int day;
    public String pilotInCommand;
    public String airplaneModel;
    public String airplaneName;
    public String dayOrNight;
    public String remark;
    public int entryNumber;
    public double flightTime;
    public String departureAirport;
    public String arrivalAirport;


    //modifies this
    //construct a new LogBookEntry

    public LogbookEntry() {
        this.entryNumber = 0;
        this.month = "";
        this.day = 0;
        this.airplaneModel = "";
        this.airplaneName = "";
        this.pilotInCommand = "";
        this.flightTime = 0.0;
        this.dayOrNight = "";
        this.departureAirport = "";
        this.arrivalAirport = "";
        this.remark = "no remark entered";

    }

    //getter
    //effect: return the entry number in int
    public int getEntryNumber() {
        return entryNumber;
    }

    //getter
    //effect: return the date in string + int.
    public String getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    //getter
    //effect: return the airplaneModel
    public String getAirplaneModel() {
        return airplaneModel;
    }

    //getter
    //effect: return the aircraft callsign
    public String getAirplaneName() {
        return airplaneName;
    }

    //getter
    //effect: return the flight time
    public double getFlightTime() {
        return flightTime;
    }

    //getter
    //effect: return day or night flight
    public String getDayOrNight() {
        return dayOrNight;
    }

    //getter
    //effect: return the remark section
    public String getRemark() {
        return remark;
    }


    //getter
    //effect: return the pilot name in string.
    public String getPic() {
        return pilotInCommand;
    }

    //getter
    //effect: return the name of departure airport
    public String getDepartureAirport() {
        return departureAirport;
    }

    //getter
    //effect: return the name of departure airport
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    //requires: entry number > 0
    //modifies: this
    //effects: sets entry number
    public void setEntryNumber(int num) {
        this.entryNumber = num;
    }

    //requires: valid string for month
    //modifies: this
    //effects: sets entry month
    public void setMonth(String month) throws InvalidInputException {
        if (month.equals("")) {
            throw new InvalidInputException();
        }
        this.month = month;
    }

    //modifies: this
    //effects: sets entry date
    public void setDay(int day) throws InvalidInputException {
        if ((day > 31) || (day < 1)) {
            throw new InvalidInputException();
        }
        this.day = day;
    }

    //requires: non-empty string
    //modifies: this
    //effect: set airplane model
    public void setAirplaneModel(String make) throws InvalidInputException {
        if (make.isEmpty()) {
            throw new InvalidInputException();
        }
        this.airplaneModel = make;
    }

    //requires: non-empty string
    //modifies: this
    //effects: sets aircraft name
    public void setAirplaneName(String name) throws InvalidInputException {
        if (name.isEmpty()) {
            throw new InvalidInputException();
        }
        this.airplaneName = name;
    }

    //modifies: this
    //effects: sets pilot name
    public void setPic(String pic) throws InvalidInputException {
        if (pic.isEmpty()) {
            throw new InvalidInputException();
        }
        this.pilotInCommand = pic;
    }

    //modifies: this
    //effects: sets flight time
    public void setFlightTime(double time) throws InvalidInputException {
        if (time <= 0) {
            throw new InvalidInputException();
        }
        this.flightTime = time;
    }

    //modifies: this
    //effects: sets day or night
    public void setDayOrNight(String day) throws InvalidInputException {
        if (day.equals("")) {
            throw new InvalidInputException();
        }
        this.dayOrNight = day;
    }

    //modifies: this
    //effects: sets note
    public void setRemark(String note) {
        this.remark = note;
    }

    //modifies: this
    //effects: sets departure airport
    public void setDepartureAirport(String dep) throws InvalidInputException {
        if (dep.length() > 4 || dep.equals("")) {
            throw new InvalidInputException();
        }
        this.departureAirport = dep;
    }

    //modifies: this
    //effects: sets arrival airport
    public void setArrivalAirport(String arrival) throws InvalidInputException {
        if (arrival.length() > 4 || arrival.equals("")) {
            throw new InvalidInputException();
        }
        this.arrivalAirport = arrival;
    }


    //effect: throw InvalidDayOrNightException
//    public void throwExceptionDayOrNight() throws InvalidDayOrNightException {
//        if (!dayOrnight.equals("night")) {
//            if (!dayOrnight.equals("day")) {
//                throw new InvalidDayOrNightException();
//            }
//        }
//    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("entryNumber", entryNumber);
        json.put("month", month);
        json.put("day", day);
        json.put("airplaneModel", airplaneModel);
        json.put("aircraftName", airplaneName);
        json.put("pilotInCommand", pilotInCommand);
        json.put("flightTime", flightTime);
        json.put("dayOrNight", dayOrNight);
        json.put("departureAirport", departureAirport);
        json.put("arrivalAirport", arrivalAirport);
        json.put("remark", remark);
        return json;
    }
}
