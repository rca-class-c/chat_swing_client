package components.navbar;

import javax.swing.*;
import java.io.IOException;

public class GenerateFrame {
    public GenerateFrame(JPanel body) throws IOException {
        JFrame frame = new JFrame();
        JPanel sidebar = new Sidebar(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1920, 900);
        frame.setVisible(true);
        frame.add(body);
        frame.add(sidebar);
        frame.setResizable(true);
    }
}
