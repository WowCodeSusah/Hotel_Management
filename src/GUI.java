import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("HELP ME MISS");
    JButton book = new JButton("Book");
    GUI() {
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(1000, 1000);

        frame.add(book);
        book.setBounds(0, -50, 50, 50);
        book.setForeground(Color.BLACK);
    }
}
