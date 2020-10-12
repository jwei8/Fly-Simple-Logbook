package model;

import java.util.ArrayList;
import java.util.List;

public class AircraftRecord {

    List<Aircraft> aircraftList;


    //modifies this
    //construct a new empty list of LogBookEntry

    public AircraftRecord() {
        aircraftList = new ArrayList<>();
    }


    //requires:
    //modifies:this
    //effect: add a new airplane to the bottom of the list and produce the new list

    public void addAirplane(Aircraft plane) {
        aircraftList.add(plane);
    }


    //requires:
    //modifies:this
    //effect: remove an entry by FlightNum and produce the new list
    public List<Aircraft> removeAnAircraftByReg(String name) {
        ArrayList<Aircraft> toKeep = new ArrayList<>();

        for (Aircraft plane : aircraftList) {
            if (!plane.aircraftRegistration.equals(name)) {
                toKeep.add(plane);
            }
        }
        return toKeep;
    }

    //requires:
    //modifies: this
    //effect: count the number of airplanes saved
    public int countNumberOfAircraft() {
        return aircraftList.size();
    }

    public List<Aircraft> displayAllAirplane() {
        return aircraftList;
    }
}



