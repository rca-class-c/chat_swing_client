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
        JPanel chatHeaderPanel = new JPanel();
        JPanel chatBodyPanel = new JPanel();
        JPanel chatFooterPanel = new JPanel();

        ChatHeaderUI(chatHeaderPanel);
        ChatBodyUI(chatBodyPanel);
        ChatFooterUI(chatFooterPanel);

        panel.add(chatHeaderPanel);
        panel.add(chatBodyPanel);
        panel.add(chatFooterPanel);

    }


    public void ChatHeaderUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,0, 850,60);
        panel.setBackground(Color.green);

    }


    public void ChatBodyUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,60, 850,2000);
        panel.setBackground(Color.red);

        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JLabel timeLabel = new JLabel();
        JLabel messageLabel = new JLabel();

        timeLabel.setText("18:00am");
        timeLabel.setForeground(Color.white);
        timeLabel.setBackground(Color.BLACK);
//
////        panel.setLayout(new BorderLayout(10, 30));
//
//        ChatHeaderUI(chatHeaderPanel);
//        chatterPanel.setLayout(null);
        westPanel.setBackground(Color.blue);
        eastPanel.setBackground(Color.black);
//        chatterPanel.add(timeLabel);
//
//        panel.add(chatHeaderPanel);
        panel.add(westPanel);
        panel.add(eastPanel);
        panel.setLayout(new GridLayout(1, 1));

    }


    public void ChatFooterUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(0,0, 850,60);
        panel.setBackground(Color.green);

    }

}
