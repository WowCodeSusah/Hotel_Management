import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("HELP ME MISS", SwingConstants.CENTER);
    JButton book = new JButton("Book");
    GUI() {
        label.setFont(new Font("Serif", Font.BOLD, 40));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(1000, 1000);

        frame.add(book);
        book.setBounds(0, -50, 50, 50);
        book.setForeground(Color.BLACK);
    }
}
