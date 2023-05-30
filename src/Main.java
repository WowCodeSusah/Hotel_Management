import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static ArrayList<String> keys = new ArrayList<>();
    public static void main(String[] args) {
        HashMap<String, Room> Hash_hotel = new HashMap<>();
        ArrayList<Room> Array_hotel = new ArrayList<>();
        createRooms_array(Array_hotel);
        createRooms_hashmap(Hash_hotel);
        searchRoom(Hash_hotel, 5, "Low");
        GUI gui = new GUI();
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
            int random_people_upperbound = 8;
            int random_people = random.nextInt(2, random_people_upperbound);
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
            int random_people_upperbound = 8;
            int random_people = random.nextInt(2, random_people_upperbound);
            Room room = new Room(i + 1, status, price, random_people, condition);

            // Hash Function
            String key = "";
            String roomNumber = "";
            if ((i + 1) <= 9) {
                roomNumber = "000" + (i + 1);
            } else if ((i + 1) <= 99 ) {
                roomNumber = "00" + (i + 1);
            } else if ((i + 1) <= 999) {
                roomNumber = "0" + (i + 1);
            } else {
                roomNumber = "" + (i + 1);
            }
            key = "H" + roomNumber + "P" + (random_price + 1) + "MP" + random_people;
            keys.add(key);
            yes.put(key, room);
        }
    }
    public static void searchRoom(HashMap<String, Room> hotel, int maxPeople, String price) {
        //Search the keys
        ArrayList<String> acceptedKeys = new ArrayList<>();
        for (String key : keys) {
            String currentKeys = "";
            int currentMaxPeople = 0;
            currentKeys = key;
            currentMaxPeople = currentKeys.charAt(9) - 48;
            int currentPrice = 0;
            String actualPrice = "";
            currentPrice = currentKeys.charAt(6) - 48;
            if (currentPrice == 1) {
                actualPrice = "High";
            } else if (currentPrice == 2) {
                actualPrice = "Medium";
            } else {
                actualPrice = "Low";
            }
            if (currentMaxPeople >= maxPeople && price.equals(actualPrice)) {
                acceptedKeys.add(key);
            }
        }
        //Search based on the status of the room
        ArrayList<Room> acceptedRooms = new ArrayList<>();
        for (String acceptedKey : acceptedKeys) {
            String currentStatus = "";
            currentStatus = hotel.get(acceptedKey).status;

            String currentCondition = "";
            currentCondition = hotel.get(acceptedKey).condition;

            if ((currentCondition.equals("New") || currentCondition.equals("Usable")) && currentStatus.equals("Free")) {
                acceptedRooms.add(hotel.get(acceptedKey));
            }
        }
        System.out.println(acceptedRooms);
    }
}