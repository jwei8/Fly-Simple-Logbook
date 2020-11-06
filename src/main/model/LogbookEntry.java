package model;

//represent one logbook entry with flight information

import exceptions.InvalidDayOrNightException;
import exceptions.InvalidInputException;
import org.json.JSONObject;
import persistence.Writeable;

public class LogbookEntry implements Writeable {

    public String month;
    public int day;
    public String pilotInCommand;
    public String airplaneModel;
    public String airplaneName;
    public String dayOrnight;
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
        this.day = 1;
        this.airplaneModel = "";
        this.airplaneName = "";
        this.pilotInCommand = "pic";
        this.flightTime = 0.0;
        this.dayOrnight = "dayOrNight";
        this.departureAirport = "Airport";
        this.arrivalAirport = "home";
        this.remark = "remark";

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
    public String getDayOrnight() {
        return dayOrnight;
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
    public void setMonth(String month) {
        this.month = month;
    }

    //requires: day > 0
    //modifies: this
    //effects: sets entry date
    public void setDay(int day) {
        this.day = day;
    }

    //requires: non-empty string
    //modifies: this
    //effect: set airplane model
    public void setAirplaneModel(String make) {
        this.airplaneModel = make;
    }

    //requires: non-empty string
    //modifies: this
    //effects: sets aircraft name
    public void setAirplaneName(String name) {
        this.airplaneName = name;
    }

    //requires: non-empty string
    //modifies: this
    //effects: sets pilot name
    public void setPic(String pic) {
        this.pilotInCommand = pic;
    }

    //requires: double > 0
    //modifies: this
    //effects: sets flight time
    public void setFLightTime(double time) {
        this.flightTime = time;
    }

    //requires: non-empty string
    //modifies: this
    //effects: sets day or night
    public void setDayOrnight(String day) {
        this.dayOrnight = day;
    }

    //requires: none empty string
    //modifies: this
    //effects: sets note
    public void setRemark(String note) {
        this.remark = note;
    }

    //requires: none empty string
    //modifies: this
    //effects: sets departure airport
    public void setDepartureAirport(String dep) {
        this.departureAirport = dep;
    }

    //requires: none empty string
    //modifies: this
    //effects: sets arrival airport
    public void setArrivalAirport(String arrival) {
        this.arrivalAirport = arrival;
    }


    //effect: throw InvalidInputException
    public void throwExceptionInvalidInput() throws InvalidInputException {
        if (entryNumber < 0) {
            throw new InvalidInputException();
        } else if  (!(day < 32) || !(day > 0)) {
            throw new InvalidInputException();
        }
    }


    public void throwExceptionDayOrNight() throws InvalidDayOrNightException {
        if (!dayOrnight.equals("night")) {
            if (!dayOrnight.equals("day")) {
                throw new InvalidDayOrNightException();
            }
        }
    }

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
        json.put("dayOrNight", dayOrnight);
        json.put("departureAirport", departureAirport);
        json.put("arrivalAirport", arrivalAirport);
        json.put("remark", remark);
        return json;
    }
}
