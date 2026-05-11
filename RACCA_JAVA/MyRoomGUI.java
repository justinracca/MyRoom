import java.awt.*;
import java.awt.event.*;

// Main GUI Class
// Implements interface

public class MyRoomGUI extends Frame implements ActionListener, BookingActions {

    // Labels
    Label titleLabel;

    Label guestLabel;
    Label namesLabel;
    Label emailLabel;
    Label contactLabel;

    Label bedsLabel;
    Label styleLabel;
    Label necessityLabel;
    Label lightingLabel;

    // TextFields
    TextField guestField;
    TextField namesField;
    TextField emailField;
    TextField contactField;

    // Choices
    Choice bedsChoice;
    Choice styleChoice;
    Choice necessityChoice;
    Choice lightingChoice;

    // Buttons
    Button confirmButton;
    Button resetButton;

    // TextArea
    TextArea outputArea;

    public MyRoomGUI() {

        // Frame settings
        setTitle("MyRoom - Room Booking System");
        setSize(500, 650);
        setLayout(null);
        setVisible(true);

        // Close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Title
        titleLabel = new Label("MyRoom - Room Booking System");
        titleLabel.setBounds(120, 40, 250, 30);
        add(titleLabel);

        // Information Section
        guestLabel = new Label("Number of Guests:");
        guestLabel.setBounds(50, 100, 150, 25);
        add(guestLabel);

        guestField = new TextField();
        guestField.setBounds(220, 100, 150, 25);
        add(guestField);

        namesLabel = new Label("Guest Name/s:");
        namesLabel.setBounds(50, 140, 150, 25);
        add(namesLabel);

        namesField = new TextField();
        namesField.setBounds(220, 140, 150, 25);
        add(namesField);

        emailLabel = new Label("Email Address:");
        emailLabel.setBounds(50, 180, 150, 25);
        add(emailLabel);

        emailField = new TextField();
        emailField.setBounds(220, 180, 150, 25);
        add(emailField);

        contactLabel = new Label("Contact Number:");
        contactLabel.setBounds(50, 220, 150, 25);
        add(contactLabel);

        contactField = new TextField();
        contactField.setBounds(220, 220, 150, 25);
        add(contactField);

        // Room Customization
        bedsLabel = new Label("Number of Beds:");
        bedsLabel.setBounds(50, 280, 150, 25);
        add(bedsLabel);

        bedsChoice = new Choice();

        bedsChoice.add("1");
        bedsChoice.add("2");
        bedsChoice.add("3");
        bedsChoice.add("4");

        bedsChoice.setBounds(220, 280, 150, 25);
        add(bedsChoice);

        styleLabel = new Label("Room Style:");
        styleLabel.setBounds(50, 320, 150, 25);
        add(styleLabel);

        styleChoice = new Choice();

        styleChoice.add("Standard");
        styleChoice.add("Modern");
        styleChoice.add("Elegant");
        styleChoice.add("Cozy");
        styleChoice.add("Vintage");

        styleChoice.setBounds(220, 320, 150, 25);
        add(styleChoice);

        necessityLabel = new Label("Extra Necessity:");
        necessityLabel.setBounds(50, 360, 150, 25);
        add(necessityLabel);

        necessityChoice = new Choice();

        necessityChoice.add("None");
        necessityChoice.add("Gaming Setup");
        necessityChoice.add("Work Station");
        necessityChoice.add("Mini Bar");
        necessityChoice.add("Relaxation Corner");

        necessityChoice.setBounds(220, 360, 150, 25);
        add(necessityChoice);

        lightingLabel = new Label("Lighting Setting:");
        lightingLabel.setBounds(50, 400, 150, 25);
        add(lightingLabel);

        lightingChoice = new Choice();

        lightingChoice.add("Standard");
        lightingChoice.add("Cool");
        lightingChoice.add("Warm");

        lightingChoice.setBounds(220, 400, 150, 25);
        add(lightingChoice);

        // Buttons
        confirmButton = new Button("Confirm Booking");
        confirmButton.setBounds(90, 460, 140, 35);
        add(confirmButton);

        resetButton = new Button("Reset Form");
        resetButton.setBounds(260, 460, 140, 35);
        add(resetButton);

        // Action Listener
        confirmButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Output Area
        outputArea = new TextArea();
        outputArea.setBounds(50, 520, 380, 90);
        add(outputArea);
    }

    // Action Event Method
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirmButton) {
            confirmBooking();
        }

        if (e.getSource() == resetButton) {
            resetForm();
        }
    }

    // Interface Method
    // Displays booking information
    @Override
    public void confirmBooking() {

        try {

            int guests = Integer.parseInt(guestField.getText());

            // Exception Handling
            if (guests > 4 || guests <= 0) {
                outputArea.setText("Guests should only be from 1 to 4.");
                return;
            }

            int beds = Integer.parseInt(bedsChoice.getSelectedItem());

            BookingDetails details = new BookingDetails(
                    guests,
                    namesField.getText(),
                    emailField.getText(),
                    contactField.getText(),
                    beds,
                    styleChoice.getSelectedItem(),
                    necessityChoice.getSelectedItem(),
                    lightingChoice.getSelectedItem()
            );

            // Polymorphism
            Room room = new ModernRoom(details.getBeds(),
                    details.getStyle());

            outputArea.setText(
                    "BOOKING CONFIRMED\n\n" +
                    "Guests: " + details.getGuests() + "\n" +
                    "Guest Name/s: " + details.getGuestNames() + "\n" +
                    "Email: " + details.getEmail() + "\n" +
                    "Contact: " + details.getContact() + "\n\n" +
                    room.showRoomStyle() + "\n" +
                    "Extra Necessity: " + details.getNecessity() + "\n" +
                    "Lighting: " + details.getLighting()
            );

        } catch (Exception ex) {

            outputArea.setText("Please enter valid information.");
        }
    }

    // Interface Method
    // Clears all fields
    @Override
    public void resetForm() {

        guestField.setText("");
        namesField.setText("");
        emailField.setText("");
        contactField.setText("");

        bedsChoice.select(0);
        styleChoice.select(0);
        necessityChoice.select(0);
        lightingChoice.select(0);

        outputArea.setText("");
    }

    // Main Method
    public static void main(String[] args) {

        new MyRoomGUI();
    }
}