// Encapsulation
// Private variables with getters

public class BookingDetails {

    private int guests;
    private String guestNames;
    private String email;
    private String contact;
    private int beds;
    private String style;
    private String necessity;
    private String lighting;

    // Constructor
    public BookingDetails(int guests, String guestNames, String email,
                          String contact, int beds, String style,
                          String necessity, String lighting) {

        this.guests = guests;
        this.guestNames = guestNames;
        this.email = email;
        this.contact = contact;
        this.beds = beds;
        this.style = style;
        this.necessity = necessity;
        this.lighting = lighting;
    }

    // Getter Methods
    public int getGuests() {
        return guests;
    }

    public String getGuestNames() {
        return guestNames;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public int getBeds() {
        return beds;
    }

    public String getStyle() {
        return style;
    }

    public String getNecessity() {
        return necessity;
    }

    public String getLighting() {
        return lighting;
    }
}