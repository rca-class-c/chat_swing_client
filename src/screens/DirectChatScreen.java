package screens;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DirectChatScreen extends JFrame {
    DirectChatScreen() {
        this.setTitle("Chat Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(new java.awt.BorderLayout(10, 10));


        this.setBackground(new Color(255, 255, 255));

        UI();

        this.setVisible(true);
    }

    public void UI() {
        JPanel leftPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(null);
        leftPanel.setBounds(0,0, 200,2000);
        leftPanel.setBackground(Color.WHITE);

        centerPanel.setLayout(null);
        centerPanel.setBounds(200,0, 850,2000);
        centerPanel.setBackground(new Color(245, 249, 255 ));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        rightPanel.setLayout(null);
        rightPanel.setBounds(0,0, 200,2000);
        rightPanel.setBackground(new Color(245, 249, 255 ));

        this.add(leftPanel);
        this.add(centerPanel);
        this.add(rightPanel);
    }


}
