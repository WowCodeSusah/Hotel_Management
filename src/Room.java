public class Room {
    public int room_number;
    public String status;
    public String price;
    public int max_people;
    public Room(int room_number, String status, String price, int max_people) {
        this.room_number = room_number;
        this.max_people = max_people;
        this.price = price;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_number=" + room_number +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", max_people=" + max_people +
                '}';
    }
}
