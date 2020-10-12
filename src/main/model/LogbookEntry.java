package model;


public class LogbookEntry {

    public String month;
    public int day;
    public String pilotInCommand;
    public String airplaneModel;
    public String airplaneName;
    public String dayOrnight;
    public String remark;
    public int entryNumber;
    public double flightTime;
    public String date;





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
        this.remark = "remark";

    }

    //getter
    //effect: return the date in string.
    public int getEntryNumber() {
        return entryNumber;
    }

    //getter
    //effect: return the date in string.
    public String getDate() {
        date = month + " " + day;
        return date;
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
    //effect: return the date in string.
    public String getPic() {
        return pilotInCommand;
    }

    //requires: entry number > 0
    //modifies: this
    //effects: sets entry number
    public void setEntryNumber(int num) {
        this.entryNumber = num;
    }

    //requires: non-empty string
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
    public void setCallSign(String name) {
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
    //effects: sets pilot name
    public void setDayOrnight(String day) {
        this.dayOrnight = day;
    }

    //requires:
    //modifies: this
    //effects: sets pilot name
    public void setRemark(String note) {
        this.remark = note;
    }

}