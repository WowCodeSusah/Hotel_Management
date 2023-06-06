import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class HotelCalender {
    public ArrayList<String> keys = new ArrayList<>();
    public hotelDates hotelCalender = new hotelDates();
    public HashMap<Integer, hotelDates> fullCalender = new HashMap<>();
    public int currentDate;
    public HotelCalender() {
        createRooms_hashmap(this.hotelCalender.Hash_hotel, this.keys, this.hotelCalender.array_hotel);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date day = new Date();
        this.fullCalender.put(getDate(date.format(day)),this.hotelCalender);
        this.currentDate = getDate(date.format(day));
    }
    /* Currently not used
    public void createRooms_array(ArrayList<Room> yes) {
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
     */
    public void createRooms_hashmap(HashMap<String, Room> yes, ArrayList<String> keys, ArrayList<Room> array_hotel) {
        for (int i = 0; i < 10000; i++) {
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
                roomNumber = "0000" + (i + 1);
            } else if ((i + 1) <= 99) {
                roomNumber = "000" + (i + 1);
            } else if ((i + 1) <= 999 ) {
                roomNumber = "00" + (i + 1);
            } else if ((i + 1) <= 9999) {
                roomNumber = "0" + (i + 1);
            } else {
                roomNumber = "" + (i + 1);
            }
            key = "H" + roomNumber + "P" + (random_price + 1) + "MP" + random_people;
            keys.add(key);
            array_hotel.add(room);
            yes.put(key, room);
        }
    }
    public ArrayList<Room> searchRoom(HashMap<String, Room> hotel, int maxPeople, String price, ArrayList<String> keys) {
        //Search the keys
        ArrayList<String> acceptedKeys = new ArrayList<>();
        for (String key : keys) {
            String currentKeys = "";
            int currentMaxPeople = 0;
            currentKeys = key;
            currentMaxPeople = currentKeys.charAt(10) - 48;
            int currentPrice = 0;
            String actualPrice = "";
            currentPrice = currentKeys.charAt(7) - 48;
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
        return acceptedRooms;
    }
    public int getDate(String dateData) {
        int currentDate = 0;
        int hari = ((dateData.charAt(0) - 48) * 10) + (dateData.charAt(1) - 48);
        int month = ((dateData.charAt(3) - 48) * 10) + (dateData.charAt(4) - 48);
        int year = ((dateData.charAt(6) - 48) * 1000) + ((dateData.charAt(7) - 48) * 100)+ ((dateData.charAt(8) - 48) * 10) + (dateData.charAt(9) - 48);
        int month_number = 0;
        if (month == 1) {
            month_number = 31;
        } else if (month == 2) {
            if (year%4 == 0) {
                month_number = 60;
            } else {
                month_number = 59;
            }
        } else if (month == 3) {
            if (year%4 == 0) {
                month_number = 91;
            } else {
                month_number = 90;
            }
        } else if (month == 4) {
            if (year%4 == 0) {
                month_number = 121;
            } else {
                month_number = 120;
            }
        } else if (month == 5) {
            if (year%4 == 0) {
                month_number = 152;
            } else {
                month_number = 151;
            }
        } else if (month == 6) {
            if (year%4 == 0) {
                month_number = 182;
            } else {
                month_number = 181;
            }
        } else if (month == 7) {
            if (year%4 == 0) {
                month_number = 213;
            } else {
                month_number = 212;
            }
        } else if (month == 8) {
            if (year%4 == 0) {
                month_number = 244;
            } else {
                month_number = 243;
            }
        } else if (month == 9) {
            if (year%4 == 0) {
                month_number = 274;
            } else {
                month_number = 273;
            }
        } else if (month == 10) {
            if (year%4 == 0) {
                month_number = 305;
            } else {
                month_number = 304;
            }
        } else if (month == 11) {
            if (year%4 == 0) {
                month_number = 335;
            } else {
                month_number = 334;
            }
        } else {
            if (year%4 == 0) {
                month_number = 366;
            } else {
                month_number = 365;
            }
        }
        currentDate = hari + month_number;
        return currentDate;
    }
    public void createNewDate(int date) {
        for (int i = 0; i + this.currentDate < date; i ++) {
            int newDate = this.currentDate + 1 + i;
            if (fullCalender.containsKey(newDate)) {
                System.out.println("Date " + newDate + " Exist Creating Date After");
            } else {
                hotelDates hotelDates = new hotelDates();
                newDate = this.currentDate + 1 + i;
                this.fullCalender.put(newDate, hotelDates);
                for (int j = 0; j < 10000; j++) {
                    int room_number = this.fullCalender.get(this.currentDate + i).Hash_hotel.get(this.keys.get(j)).room_number;
                    String status = this.fullCalender.get(this.currentDate + i).Hash_hotel.get(this.keys.get(j)).status;
                    String price = this.fullCalender.get(this.currentDate + i).Hash_hotel.get(this.keys.get(j)).price;
                    String condition = this.fullCalender.get(this.currentDate + i).Hash_hotel.get(this.keys.get(j)).condition;
                    int max_people = this.fullCalender.get(this.currentDate + i).Hash_hotel.get(this.keys.get(j)).max_people;
                    Room check_room = new Room(room_number, status, price, max_people, condition);
                    if (check_room.status.equals("Occupied")) {
                        check_room.status = "Free";
                    } else if (check_room.status.equals("Reserved")) {
                        check_room.status = "Occupied";
                    } else {
                        check_room.status = "Free";
                    }
                    fullCalender.get(newDate).Hash_hotel.put(this.keys.get(j), check_room);
                    fullCalender.get(newDate).array_hotel.add(check_room);
                }
            }
        }
    }
}
