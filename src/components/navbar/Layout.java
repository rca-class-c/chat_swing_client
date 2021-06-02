package components.navbar;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Layout {
    public Layout(JPanel body) throws IOException {
        JFrame frame = new JFrame("Navbar");
        JPanel sidebar = new Sidebar();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1920, 900);
        frame.setVisible(true);
        frame.add(body);
        frame.add(sidebar);
        frame.setResizable(true);

    }
}
