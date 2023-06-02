import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GUI {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("Hotel Carlo");
    JLabel book_title = new JLabel("Book a Room");
    JLabel allRoom_title = new JLabel("All Rooms");
    JLabel amt_people_title = new JLabel("Amount of People");
    JLabel price_range_title = new JLabel("Price Range");
    JLabel accepted_rooms_title = new JLabel("Accepted Room");
    JLabel confirmation = new JLabel();
    JLabel date_title = new JLabel("Choose A Date");
    JLabel setStatus_title = new JLabel("Set Status Manually");
    JButton check = new JButton("Check");
    JButton book = new JButton("Book");
    JButton statusButton = new JButton("Change");
    JComboBox<Room> allRoom = new JComboBox<>();
    JComboBox<Integer> Amount_of_people = new JComboBox<>();
    JComboBox<String> Price_range = new JComboBox<>();
    JComboBox<Room> acceptedRoom = new JComboBox<>();
    JComboBox<String> statusChoice = new JComboBox<>();
    ArrayList<Room> sortedRooms = new ArrayList<>();
    JDateChooser date = new JDateChooser();
    JLabel background1 = new JLabel(new ImageIcon("hotel.jpg"));
    int selectedDate;
    ArrayList<Room> comboCurrentRooms;
     GUI(HotelCalender hotel) throws IOException {
         background1.setBounds(0, 0, 1200, 700);
         frame.add(background1);
         selectedDate = hotel.currentDate;

         title.setFont(new Font("Serif", Font.BOLD, 40));
         title.setAlignmentX(Component.CENTER_ALIGNMENT);
         title.setAlignmentY(Component.BOTTOM_ALIGNMENT);

         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.getContentPane().setLayout(new GroupLayout(frame.getContentPane()));
         frame.setVisible(true);
         frame.setLayout(null);
         frame.setSize(1200, 700);

         frame.add(title);
         title.setBounds(500, 0, 400, 200);

         comboCurrentRooms = hotel.fullCalender.get(selectedDate).array_hotel;
         allRoom.setModel(new DefaultComboBoxModel<Room>(comboCurrentRooms.toArray(new Room[0])));
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
         Price_range.setBounds(250, 320, 100, 50);
         ;
         frame.add(Price_range);

         accepted_rooms_title.setBounds(20, 430, 150, 50);
         accepted_rooms_title.setFont(new Font("Serif", Font.BOLD, 15));
         frame.add(accepted_rooms_title);

         acceptedRoom.setBounds(20, 480, 540, 50);
         frame.add(acceptedRoom);

         frame.add(check);
         check.setBounds(20, 380, 100, 50);
         check.setForeground(Color.BLACK);
         check.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (e.getButton() == MouseEvent.BUTTON1) {
                     String price = Price_range.getItemAt(Price_range.getSelectedIndex());
                     int people = Amount_of_people.getItemAt(Amount_of_people.getSelectedIndex());
                     sortedRooms = hotel.searchRoom(hotel.fullCalender.get(selectedDate).Hash_hotel, people, price, hotel.keys);
                     acceptedRoom.setModel(new DefaultComboBoxModel<Room>(sortedRooms.toArray(new Room[0])));
                 }
             }
         });

         book.setBounds(20, 550, 100, 50);
         book.setForeground(Color.black);
         frame.add(book);
         book.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (e.getButton() == MouseEvent.BUTTON1) {
                     Room room = acceptedRoom.getItemAt(acceptedRoom.getSelectedIndex());
                     confirmation.setText("You Reserve Room " + room.room_number + ", Thank You :)");
                     room.setStatus("Reserved");
                     acceptedRoom.removeAllItems();
                 }
             }
         });

         confirmation.setBounds(20, 600, 300, 50);
         frame.add(confirmation);

         date_title.setBounds(700, 150, 300, 50);
         date_title.setFont(new Font("Serif", Font.BOLD, 30));
         frame.add(date_title);

         date.setBounds(700, 200, 200, 50);
         Date bruh = new Date();
         date.setDate(bruh);
         date.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
             @Override
             public void propertyChange(PropertyChangeEvent e) {
                 Date selectedDate_1;
                 selectedDate_1 = date.getDate();
                 String actualDate = "" + selectedDate_1.toString();
                 String actualActualDate;
                 String Day = String.valueOf(actualDate.charAt(8)) + actualDate.charAt(9) + "";
                 String Month = String.valueOf(actualDate.charAt(4)) + String.valueOf(actualDate.charAt(5)) + String.valueOf(actualDate.charAt(6)) + "";
                 String actualMonth;
                 String Year = (actualDate.charAt(24) - 48) * 1000 + (actualDate.charAt(25) - 48) * 100 + (actualDate.charAt(26) - 48) * 10 + (actualDate.charAt(27) - 48) + "";
                 actualMonth = switch (Month) {
                     case "Jan" -> "01";
                     case "Feb" -> "02";
                     case "Mar" -> "03";
                     case "Apr" -> "04";
                     case "May" -> "05";
                     case "Jun" -> "06";
                     case "Jul" -> "07";
                     case "Aug" -> "08";
                     case "Sep" -> "09";
                     case "Oct" -> "10";
                     case "Nov" -> "11";
                     default -> "12";
                 };
                 actualActualDate = Day + "/" + actualMonth + "/" + Year;
                 selectedDate = hotel.getDate(actualActualDate);
                 hotel.createNewDate(selectedDate);
                 comboCurrentRooms = hotel.fullCalender.get(selectedDate).array_hotel;
                 allRoom.setModel(new DefaultComboBoxModel<Room>(comboCurrentRooms.toArray(new Room[0])));
             }
         });
         frame.add(date);

         setStatus_title.setBounds(700, 280, 300, 50);
         setStatus_title.setFont(new Font("Serif", Font.BOLD, 20));
         setStatus_title.setVisible(true);
         frame.add(setStatus_title);

         String[] status_list = {"Free", "Occupied", "Reserved"};
         statusChoice.setModel(new DefaultComboBoxModel<String>(status_list));
         statusChoice.setBounds(700, 350, 100, 50);
         statusChoice.setVisible(true);
         frame.add(statusChoice);

         statusButton.setBounds(700, 420, 100, 50);
         statusButton.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (e.getButton() == MouseEvent.BUTTON1) {
                     String change = statusChoice.getItemAt(statusChoice.getSelectedIndex());
                     Room targetRoom = allRoom.getItemAt(allRoom.getSelectedIndex());
                     targetRoom.status = change;
                 }
             }
         });
         frame.add(statusButton);
     }

}
