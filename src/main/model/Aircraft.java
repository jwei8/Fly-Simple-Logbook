package model;


public class Aircraft {

    public String aircraftType;
    public String callSign;
    public String description;


    //Represent and aircraft with the Type and Registration
    public Aircraft(String type, String registration, String remark) {
        this.aircraftType = type;
        this.callSign = registration;
        this.description = remark;
    }

    //getter
    //effect: return model type
    public String getAircraftType() {
        return aircraftType;
    }

    //getter
    //effect: return legal registration callsign
    //getter
    //effect: return the date in string.
    public String getAircraftReg() {
        return callSign;
    }

    public String editDescription(String update) {
        return description = update;
    }


}
