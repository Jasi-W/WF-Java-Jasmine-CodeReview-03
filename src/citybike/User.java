package citybike;

public class User {
    public int userID;
    String firstname;
    String lastname;
    Bike currentlyRentedBike;
    public static int counter = 1;

    public User(int userID, String firstname, String lastname, Bike currentlyRentedBike){
        this.userID += counter++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public void rentBike(Station s, Bike b){
        this.currentlyRentedBike = b;
        s.removeBike(b);
        System.out.println("\nUser: " +this.firstname+ " " +this.lastname+ " rented bikeID: " +b.bikeID+ " with Color: " +b.color+ " in Station: " +s.getLocation());
    }

    public void returnBike(Station s, Bike b){
        if (s.addBike(currentlyRentedBike) >= 0) {
            System.out.println("User" + this.firstname + " " + this.lastname + " returned bikeID: " + currentlyRentedBike.bikeID + " with Color: " + currentlyRentedBike.color + " in Station: " + s.getLocation());
            this.currentlyRentedBike = null;
            return;
        }
    }
}
