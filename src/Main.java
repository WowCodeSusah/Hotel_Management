import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Room> Hash_hotel = new HashMap<>();
        ArrayList<Room> Array_hotel = new ArrayList<>();
        createRooms_array(Array_hotel);
        createRooms_hashmap(Hash_hotel);
        System.out.println(Hash_hotel);
        GUI gui = new GUI();
        System.out.println("rabbit");
    }
    public static void createRooms_array(ArrayList<Room> yes) {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            String status = "";
            int random_status_upperbound = 3;
            int random_status = random.nextInt(random_status_upperbound);
            if (random_status == 0)  {
                status = "Free";
            } else if (random_status == 1) {
                status = "Occupied";
            } else {
                status = "Reserved";
            }
            String price = "";
            int random_price_upperbound = 3;
            int random_price = random.nextInt(random_price_upperbound);
            if (random_price == 0) {
                price = "High";
            } else if (random_price == 1) {
                price = "Medium";
            } else {
                price = "Low";
            }
            String condition = "";
            int random_condition_upperbound = 9;
            int random_condition = random.nextInt(random_condition_upperbound);
            if (random_condition == 0 || random_condition == 1) {
                condition = "New";
            } else if (random_condition == 2 || random_condition == 3 || random_condition == 4) {
                condition = "Unprepared";
            } else {
                condition = "Usable";
            }
            int random_people_upperbound = 11;
            int random_people = random.nextInt(5, random_people_upperbound);
            Room room = new Room(i + 1, status, price, random_people, condition);
            yes.add(room);
        }
    }
    public static void createRooms_hashmap(HashMap<String, Room> yes) {
        for (int i = 0; i < 1000; i++) {
            //Room Randomizer
            Random random = new Random();
            String status = "";
            int random_status_upperbound = 3;
            int random_status = random.nextInt(random_status_upperbound);
            if (random_status == 0) {
                status = "Free";
            } else if (random_status == 1) {
                status = "Occupied";
            } else {
                status = "Reserved";
            }
            String price = "";
            int random_price_upperbound = 3;
            int random_price = random.nextInt(random_price_upperbound);
            if (random_price == 0) {
                price = "High";
            } else if (random_price == 1) {
                price = "Medium";
            } else {
                price = "Low";
            }
            String condition = "";
            int random_condition_upperbound = 9;
            int random_condition = random.nextInt(random_condition_upperbound);
            if (random_condition == 0 || random_condition == 1) {
                condition = "New";
            } else if (random_condition == 2 || random_condition == 3 || random_condition == 4) {
                condition = "Unprepared";
            } else {
                condition = "Usable";
            }
            int random_people_upperbound = 11;
            int random_people = random.nextInt(5, random_people_upperbound);
            Room room = new Room(i + 1, status, price, random_people, condition);

            // Hash Function
            String key = "";
            key = "H" + (i + 1) + "P" + (random_price + 1) + "MP" + random_people;
            yes.put(key, room);
        }
    }
}