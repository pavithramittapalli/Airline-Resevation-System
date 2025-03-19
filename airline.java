import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirlineReservationSystem extends JFrame {
    // GUI Components
    private JLabel flightLabel;
    private JComboBox<String> flightComboBox;
    private JLabel passengerNameLabel;
    private JTextField passengerNameField;
    private JButton bookButton;
    private JTextArea reservationDetailsArea;
    
    // Constructor to set up the GUI
    public AirlineReservationSystem() {
        setTitle("Airline Reservation System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        flightLabel = new JLabel("Select Flight:");
        String[] flights = {"Flight A - New York to LA", "Flight B - LA to Chicago", "Flight C - New York to Miami"};
        flightComboBox = new JComboBox<>(flights);
        
        passengerNameLabel = new JLabel("Enter Passenger Name:");
        passengerNameField = new JTextField(20);
        
        bookButton = new JButton("Book Ticket");
        
        reservationDetailsArea = new JTextArea(10, 30);
        reservationDetailsArea.setEditable(false);
        
        // Add components to the JFrame
        add(flightLabel);
        add(flightComboBox);
        add(passengerNameLabel);
        add(passengerNameField);
        add(bookButton);
        add(new JScrollPane(reservationDetailsArea));
        
        // ActionListener for the Book Ticket button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFlight = (String) flightComboBox.getSelectedItem();
                String passengerName = passengerNameField.getText();
                
                // Check if the passenger name is not empty
                if (passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                } else {
                    String reservationDetails = "Ticket Booked!\nFlight: " + selectedFlight + "\nPassenger: " + passengerName;
                    reservationDetailsArea.setText(reservationDetails);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AirlineReservationSystem frame = new AirlineReservationSystem();
                frame.setVisible(true);
            }
        });
    }
}
