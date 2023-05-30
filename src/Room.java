public class Room {
    public int room_number;
    public String status;
    public String price;
    public String condition;
    public int max_people;
    public Room(int room_number, String status, String price, int max_people, String condition) {
        this.room_number = room_number;
        this.max_people = max_people;
        this.price = price;
        this.status = status;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "[Room " + room_number + "." + " Status = " + status + ", Condition = "+ condition + ", Price = " + price  + ", Max_Capacity = " + max_people + "]\n";
    }
}
