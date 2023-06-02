import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HotelCalender hotel_carlos = new HotelCalender();
        GUI gui = new GUI(hotel_carlos);
    }
}