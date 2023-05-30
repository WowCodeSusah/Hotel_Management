import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("Hotel Carlo");
    JButton book = new JButton("Book");
    GUI() {
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(title);
        frame.setVisible(true);
        frame.setSize(1000, 1000);

        frame.add(book);
        book.setBounds(0, -50, 50, 50);
        book.setForeground(Color.BLACK);
    }
}
