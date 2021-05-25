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

        rightPanel.setLayout(null);
        rightPanel.setBounds(0,0, 200,2000);
        rightPanel.setBackground(new Color(245, 249, 255 ));

        ChatAreaUI(centerPanel);

        this.add(leftPanel);
        this.add(centerPanel);
        this.add(rightPanel);
    }

    public void ChatAreaUI(JPanel panel) {
        JPanel chatterPanel = new JPanel();
        JPanel chatHeaderPanel = new JPanel();
        JPanel selfPanel = new JPanel();
        JLabel timeLabel = new JLabel();
        JLabel messageLabel = new JLabel();

        timeLabel.setText("18:00am");
        timeLabel.setForeground(Color.white);
        timeLabel.setBackground(Color.BLACK);

//        panel.setLayout(new BorderLayout(10, 30));

        ChatHeaderUI(chatHeaderPanel);
        chatterPanel.setLayout(null);
        chatterPanel.setBounds(0,0, 20,30);
        chatterPanel.setBackground(Color.red);
        chatterPanel.add(timeLabel);


        panel.add(chatHeaderPanel);
        panel.add(chatterPanel);

    }


    public void ChatHeaderUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,0, 850,60);
        panel.setBackground(Color.green);

    }



}
