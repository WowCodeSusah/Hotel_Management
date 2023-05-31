import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("Hotel Carlo");
    JLabel book_title = new JLabel("Book a Room");
    JLabel allRoom_title = new JLabel("All Rooms");
    JLabel amt_people_title = new JLabel("Amount of People");
    JLabel price_range_title = new JLabel("Price Range");
    JLabel accepted_rooms_title = new JLabel("Accepted Room");
    JButton book = new JButton("Book");
    JComboBox<Room> allRoom = new JComboBox<>();
    JComboBox<Integer> Amount_of_people = new JComboBox<>();
    JComboBox<String> Price_range = new JComboBox<>();
    JComboBox<Room> acceptedRoom = new JComboBox<>();
    ArrayList<Room> sortedRooms = new ArrayList<>();
     GUI(Hotel hotel) {
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GroupLayout(frame.getContentPane()));
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1000, 1000);

        frame.add(title);
        title.setBounds(400, 0, 400, 200);

        allRoom.setModel(new DefaultComboBoxModel<Room>(hotel.Array_hotel.toArray(new Room[0])));
        allRoom.setBounds(20, 200, 540, 50);
        frame.add(allRoom);

        allRoom_title.setBounds(20, 150, 300, 50);
        allRoom_title.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(allRoom_title);

        book_title.setBounds(20, 220, 300, 100);
        book_title.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(book_title);

        amt_people_title.setBounds(20, 280, 150, 50);
        amt_people_title.setFont(new Font("Serif", Font.BOLD, 15));
        frame.add(amt_people_title);

        Integer[] people_choice = {2, 3, 4, 5, 6, 7};
        Amount_of_people.setModel(new DefaultComboBoxModel<Integer>(people_choice));
        Amount_of_people.setBounds(20, 320, 100, 50);
        frame.add(Amount_of_people);

        price_range_title.setBounds(250, 280, 150, 50);
        price_range_title.setFont(new Font("Serif", Font.BOLD, 15));
        frame.add(price_range_title);

        String[] price_choice = {"Low", "Medium", "High"};
        Price_range.setModel(new DefaultComboBoxModel<String>(price_choice));
        Price_range.setBounds(250, 320, 100, 50);;
        frame.add(Price_range);

        accepted_rooms_title.setBounds(20, 500, 150, 50);
        accepted_rooms_title.setFont(new Font("Serif", Font.BOLD, 15));
        frame.add(accepted_rooms_title);

        acceptedRoom.setBounds(20, 550, 580, 50);
        frame.add(acceptedRoom);

        frame.add(book);
        book.setAlignmentX(Component.CENTER_ALIGNMENT);
        book.setBounds(20, 400, 100, 50);
        book.setForeground(Color.BLACK);
        book.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (e.getButton() == MouseEvent.BUTTON1) {
                    String price = Price_range.getItemAt(Price_range.getSelectedIndex());
                    int people = Amount_of_people.getItemAt(Amount_of_people.getSelectedIndex());
                    sortedRooms = hotel.searchRoom(hotel.Hash_hotel, people, price ,hotel.keys);
                    System.out.println("Bro Plis");
                    acceptedRoom.setModel(new DefaultComboBoxModel<Room>(sortedRooms.toArray(new Room[0])));
                 }
             }
         });


    }
}
