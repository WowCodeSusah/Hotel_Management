import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HotelCalender hotel_carlos = new HotelCalender();
        hotel_carlos.createNewDate(185);
        System.out.println(hotel_carlos.fullCalender.get(185).Hash_hotel);
        System.out.println(hotel_carlos.fullCalender);
        GUI gui = new GUI(hotel_carlos);
    }
}