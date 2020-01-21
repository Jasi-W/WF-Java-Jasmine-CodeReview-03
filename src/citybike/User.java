package citybike;

public class User {
    int userID = 0;
    String firstname;
    String lastname;
    Bike currentlyRentedBike;


    public User(int userID, String firstname, String lastname, Bike currentlyRentedBike){
        this.userID += userID++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public void rentBike(Station s, Bike b){
        this.currentlyRentedBike = b;
        s.removeBike(b);
        System.out.println("\n" + this.firstname + " " + this.lastname + " rented bike number " + b.bikeID + " (color " + b.color + ") @ " + s.getLocation());
    }

    public void returnBike(Station s, Bike b){
        if (s.addBike(currentlyRentedBike) >= 0) {
            System.out.println("\n" + this.firstname + " " + this.lastname + " returned bike number " + currentlyRentedBike.bikeID + " (color " + currentlyRentedBike.color + ") to station " + s.getLocation());
            this.currentlyRentedBike = null;
            return;
        }

    }

}
