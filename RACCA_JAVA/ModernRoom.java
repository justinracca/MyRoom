// Inheritance
// ModernRoom inherits Room class

public class ModernRoom extends Room {

    // Constructor using super keyword
    public ModernRoom(int beds, String style) {
        super(beds, style);
    }

    // Polymorphism
    // Overriding abstract method
    @Override
    public String showRoomStyle() {
        return "Room Style: " + style + "\nNumber of Beds: " + beds;
    }
}