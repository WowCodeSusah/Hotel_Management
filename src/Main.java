import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Room> Hotel = new HashMap<>();
        ArrayList<Room> room_array = new ArrayList<>();
        createRooms(room_array);
        System.out.println(room_array);
        GUI gui = new GUI();
    }
    public static void createRooms(ArrayList<Room> yes) {
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
            int random_people_upperbound = 11;
            int random_people = random.nextInt(5, random_people_upperbound);
            Room room = new Room(i + 1, status, price, random_people);
            yes.add(room);
        }
    }
}