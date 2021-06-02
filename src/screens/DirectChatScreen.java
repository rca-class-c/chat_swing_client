package screens;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DirectChatScreen extends JFrame {

    int yVerticalCounter = 10;
    DirectChatScreen() {
        this.setTitle("Chat Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
//        this.setLayout(new java.awt.BorderLayout(10, 10));


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
        JPanel chatHeaderPanel = new JPanel();
        JPanel chatBodyPanel = new JPanel();
        JPanel chatFooterPanel = new JPanel();

        ChatHeaderUI(chatHeaderPanel);
        ChatBodyUI(chatBodyPanel);
        ChatFooterUI(chatFooterPanel);

         panel.add(chatHeaderPanel);
        panel.add(chatBodyPanel, BorderLayout.WEST);
          panel.add(chatFooterPanel);

    }


    public void ChatHeaderUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,0, 850,60);
        panel.setBackground(Color.green);

    }


    public void ChatBodyUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,60, 1050,2000);

        panel.setBackground( Color.decode("#F5F9FF"));
        MessageUI(panel, "INCOMING", "18:00AM", "TEST");
        MessageUI(panel, "OUTGOING", "18:00AM", "TEST");
        MessageUI(panel, "OUTGOING", "18:00AM", "TEST");
        MessageUI(panel, "OUTGOING", "18:00AM", "TEST");
        MessageUI(panel, "INCOMING", "18:00AM", "TEST");
        MessageUI(panel, "INCOMING", "18:00AM", "TEST");
    }


    public void ChatFooterUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,0, 850,10);
        panel.setBackground(Color.MAGENTA);

    }

    public void MessageUI(JPanel panel, String type, String time, String message) {
        JPanel timePanel = new JPanel(new BorderLayout(60,20));
        JPanel messagePanel = new JPanel(new BorderLayout(30,4));
        messagePanel.setBackground(Color.decode("#FFFFFF"));
        timePanel.setBackground(null);

        if (type.equals("INCOMING")) {
            timePanel.setBounds(20, yVerticalCounter,80,20);
            messagePanel.setBounds(20,(yVerticalCounter + 20),400,30);
        }
        else if (type.equals("OUTGOING")) {
            timePanel.setBounds(430, yVerticalCounter,80,20);
            messagePanel.setBounds(430,(yVerticalCounter + 20),400,30);
        }

        JLabel timeLabel = new JLabel("18:00am");
        JLabel messageLabel = new JLabel();
        timePanel.add(timeLabel, BorderLayout.CENTER);
//        messageLabel.setBorder(new EmptyBorder(0,10,0,0));

        containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        messageLabel.setText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat");
        messageLabel.setForeground(Color.decode("#3E4965"));
        messagePanel.add(messageLabel, BorderLayout.CENTER);


        panel.add(timePanel);
        panel.add(messagePanel);

        yVerticalCounter += 70;

    }
}
