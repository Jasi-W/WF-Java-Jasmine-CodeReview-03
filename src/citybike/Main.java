package citybike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //BIKES
        Bike bike1 = new Bike( "white", "CanBeRented");
        Bike bike2 = new Bike( "yellow", "InService");
        Bike bike3 = new Bike( "orange", "Discarded");
        Bike bike4 = new Bike( "red", "CanBeRented");
        Bike bike5 = new Bike( "blue", "CanNotBeRented");
        Bike bike6 = new Bike( "green", "InService");
        Bike bike7 = new Bike( "brown", "CanBeRented");
        Bike bike8 = new Bike( "gray", "Discarded");
        Bike bike9 = new Bike( "black", "CanBeRented");
        Bike bike10 = new Bike( "gurke", "CanBeRented");

        HashMap<Integer, Bike> allBikes = new  HashMap<Integer, Bike>();
        allBikes.put(1, bike1);
        allBikes.put(2, bike2);
        allBikes.put(3, bike3);
        allBikes.put(4, bike4);
        allBikes.put(5, bike5);
        allBikes.put(6, bike6);
        allBikes.put(7, bike7);
        allBikes.put(8, bike8);
        allBikes.put(9, bike9);
        allBikes.put(10, bike10);

        System.out.println("\nBIKES:");
        allBikes.forEach((k, v) -> {
            System.out.println("id: " +v.getBikeID()+ " color: " +v.color+ " State: "  + v.state);
        });

        //STATIONS
        List<Bike> arrStation1 = new ArrayList<Bike>();
        arrStation1.add(bike1);
        arrStation1.add(bike4);
        arrStation1.add(bike8);
        Station station1 = new Station( "Location 1", arrStation1);

        List<Bike> arrStation2 = new ArrayList<Bike>();
        arrStation2.add(bike3);
        arrStation2.add(bike2);
        arrStation2.add(bike6);
        arrStation2.add(bike5);
        Station station2 = new Station( "Location 2", arrStation2 );

        List<Bike> arrStation3 = new ArrayList<Bike>();
        Station station3 = new Station( "Location 3", arrStation3);

        HashMap<Integer, Station> allStations = new HashMap<>();
        allStations.put(station1.getStationID(), station1);
        allStations.put(station2.getStationID(), station2);
        allStations.put(station3.getStationID(), station3);

        printAllStations(allStations);

        //USERS
        User user1 = new User(1, "Anna", "Wild", null);
        User user2 = new User(2, "Marc", "Klug", null);
        User user3 = new User(3, "Leon", "Lang", null);
        User user4 = new User(4, "Maria", "Kurz", null);

        HashMap<Integer, User> allUser = new HashMap<>();
        allUser.put(user1.userID, user1);
        allUser.put(user2.userID, user2);
        allUser.put(user3.userID, user3);
        allUser.put(user4.userID, user4);

        System.out.println("USERS: ");
        allUser.forEach((key, value) -> {
            System.out.println("ID: " +value.userID+ " Name: " + value.firstname+ " "  +value.lastname);
        });

        // userZ rents a bike bikeX from stationY1
        // bikeX is removed from the data of that Station, and connected to a userZ
        user1.rentBike(station1, bike4);
        printAllStations(allStations);

        //userZ returns a bike to stationY2
        user1.returnBike(station2, bike4);
        printAllStations(allStations);
    }

    public static void printAllStations(HashMap <Integer, Station> allStations){
        System.out.println("\nSTATIONS: ");
        allStations.forEach((k, v) -> {
            System.out.println("Station ID: " +v.getStationID()+ " in " +v.getLocation()+ " \n" +v.currentlyInStation.size()+ " Bikes in the Station: ");
            v.currentlyInStation.forEach((b) -> {
                System.out.println("--> bikeID: " +b.getBikeID()+ " Color: " +b.color);
            });
            System.out.println();
        });
    }
}

