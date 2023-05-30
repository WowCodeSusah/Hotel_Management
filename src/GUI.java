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
        frame.getContentPane().setLayout(new GroupLayout(frame.getContentPane()));
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1000, 1000);

        frame.add(title);
        title.setBounds(400, 0, 400, 200);

        frame.add(book);
        book.setAlignmentX(Component.CENTER_ALIGNMENT);
        book.setBounds(500, 500, 100, 100);
        book.setForeground(Color.BLACK);
    }
}
