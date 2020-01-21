package citybike;

import java.util.ArrayList;
import java.util.List;

public class Station {

    //Attributes
    private int stationID = 0;
    private String location;
    public List<Bike> currentlyInStation = new ArrayList<>();
    public static int counter = 0;

    //Constructor
    public Station(String location, List<Bike> currentlyInStation){
        this.stationID += counter++;
        this.location = location;
        this.currentlyInStation = currentlyInStation;
    }

    //getter & setter methods
    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Bike> getCurrentlyInStation() {
        return currentlyInStation;
    }

    public void setCurrentlyInStation(List<Bike> currentlyInStation) {
        this.currentlyInStation = currentlyInStation;
    }

    //Methods
    public int addBike(Bike bike){

        if(this.getCurrentlyInStation().size() < 5){
            this.getCurrentlyInStation().add(bike);
            return this.getCurrentlyInStation().size();
        }

        if(this.getCurrentlyInStation().size() == 5){
            System.out.println(this.getLocation()+ "is occupied!");
        }
        return -1;
    }

    public void removeBike(Bike bike){
        this.currentlyInStation.remove(bike);
    }
}
