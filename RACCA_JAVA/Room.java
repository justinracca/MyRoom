// Abstract Class
// This is the parent class for room details

public abstract class Room {

    protected int beds;
    protected String style;

    // Constructor
    public Room(int beds, String style) {
        this.beds = beds;
        this.style = style;
    }

    // Abstract Method
    public abstract String showRoomStyle();

}