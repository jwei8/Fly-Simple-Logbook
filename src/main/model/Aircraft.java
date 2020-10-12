package model;


public class Aircraft {

    public String aircraftType;
    public String aircraftRegistration;
    public String aircraftDescription;


    //Represent and aircraft with the Type and Registration
    public Aircraft() {
        this.aircraftType = "type";
        this.aircraftRegistration = "registration";
        this.aircraftDescription = "note";
    }

    //getter
    //effect: return model type
    public String getAircraftType() {
        return aircraftType;
    }

    //getter
    //effect: return legal registration callsign
    public String getAircraftReg() {
        return aircraftRegistration;
    }

    //getter
    //effect: return airplane description
    public String getAircraftDescription() {
        return aircraftDescription;
    }

    //requires: non-empty string
    //modifies: this
    //effects: sets airplane's type
    public void setAircraftType(String type) {
        this.aircraftType = type;
    }


    //requires: non-empty string
    //modifies: this
    //effects: sets airplane's name
    public void setAircraftReg(String callSign) {
        this.aircraftRegistration = callSign;
    }


    //requires: non-empty string
    //modifies: this
    //effects: sets airplane description
    public void setAircraftDescription(String note) {
        this.aircraftDescription = note;
    }


}
