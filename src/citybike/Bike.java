package citybike;

public class Bike {

    //Attributes
    public int bikeID;
    public String color;
    public String state;
    public static int counter = 1;

    //Constructor
    public Bike( String color, String state) {
        this.bikeID = counter++;
        this.color = color;
        this.state = state;
    }

    //getter & setter methods
    public int getBikeID() {
        return bikeID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
