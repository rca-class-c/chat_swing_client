package screens;

import com.fasterxml.jackson.core.JsonProcessingException;
import components.DirectMessages.HeaderScreen;
import components.navbar.SidebarDemo;
import models.*;
import simplifiers.RequestSimplifiers;
import socket.IndexSocket;
import utils.ChatBetweenTwo;
import utils.CommonUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DirectChatScreen extends JFrame {

    int yVerticalCounter = 10;
    JPanel chatHeaderPanel = new JPanel();
    JPanel chatBodyPanel = new JPanel();
    JPanel chatFooterPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    public DirectChatScreen() {
        this.setTitle("Chat Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
//        this.setLayout(new java.awt.BorderLayout(10, 10));


        this.setBackground(new Color(255, 255, 255));

        UI();

        this.setVisible(true);
    }

    public void UI() {

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

try {
    ChatHeaderUI(chatHeaderPanel);
    ChatBodyUI(chatBodyPanel);
    ChatFooterUI(chatFooterPanel);

    panel.add(chatHeaderPanel);
    panel.add(chatBodyPanel, BorderLayout.WEST);
    panel.add(chatFooterPanel);
} catch (Exception e) {
    e.printStackTrace();
}
    }


    public void ChatHeaderUI(JPanel panel) {
        try {


            panel.setLayout(null);
            panel.setBounds(0, 0, 850, 60);
            panel.setBackground(Color.green);
//            new HeaderScreen().export();
            //TODO: Add Header Screen to chat
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void ChatBodyUI(JPanel panel) throws JsonProcessingException {
        panel.setLayout(null);
        panel.setBounds(0,60, 1050,600);



//        Messages[] messages = new MessageResponseDataDecoder().returnDecodedMessage();
//
//        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
//        System.out.println("Response"+ response.getData());
//        if(response.isSuccess()){
//            Group[] groups = new GroupResponseDataDecoder().returnGroupsListDecoded(response.getData());
//            CommonUtil.addTabs(10, true);
//            if (groups.length != 0){
//                for(int i=0; i<groups.length; i++){
//                    groupNameLabel = new JLabel(groups[0].getName());
//                    groupNameSecondLabel = new JLabel(groups[1].getName());
//                    groupNameThirdLabel = new JLabel(groups[2].getName());
//                }
//            }else{
//                System.out.println("Request failed in this group");
//            }
//        }else {
//            System.out.println("failed to fetch users in the given group");
//        }
        panel.setBackground( Color.decode("#F5F9FF"));

        String  key= "messages/direct";
        Request request = new Request(new ChatBetweenTwo(2,1),key);
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        System.out.println(response.isSuccess());
        System.out.println("Res Data" + response.getData());

        Messages[] messages = new UserResponseDataDecoder().returnMessagesListDecoded(response.getData());
//        messages = subArray(messages, 7, messages.length);

        System.out.println(messages[0].toString());

        for (Messages message: messages) {
            //TODO: GET LOGGED IN ID
            //TODO: Show subarray messages

            if (message != null) {
                if (message.getSender() == 2)
                    MessageUI(panel, "OUTGOING", message.getSent_at(), message.getContent());
                else
                    MessageUI(panel, "INCOMING", message.getSent_at(), message.getContent());
            }

        }
//        ChatFooterUI(chatFooterPanel);
    }


    public void ChatFooterUI(JPanel panel) {
        panel.setLayout(null);
        panel.setBounds(20,20, 810,900);
        panel.setBackground(Color.blue);

        WrietMessageUI(panel);

    }

    public void WrietMessageUI(JPanel panel) {
        JTextField writeMessageTextField = new JTextField();
        writeMessageTextField.setLayout(null);


        writeMessageTextField.setBounds( 0, yVerticalCounter + 50, 700, 36);
        writeMessageTextField.setBorder(new EmptyBorder(0, 10, 0, 10));
        writeMessageTextField.setText("Send Message");

//
//        Icon imageIcon = new ImageIcon(this.getClass().getResource("../assets/profile.png"));
////        Image image = imageIcon.getImage();
////
////        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
////        imageIcon = new ImageIcon(newimg);
//
//        JPanel iconPanel = new JPanel();
//
//        JLabel label = new JLabel(imageIcon);
//        iconPanel.setLayout(null);
//        iconPanel.setBounds( 400, 500, 40, 36);
//
//        iconPanel.setBackground(Color.RED);

        JButton btn = new JButton("Send");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = "messages/send/direct";
                // TODO: Message Id refining
                Messages message = new Messages(0, 4, 7, 0, writeMessageTextField.getText());
                Request request = new Request(message, key);
//                System.out.println("Request "+request.getData());
                ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
                System.out.println(response.isSuccess());
                if (response.isSuccess()) writeMessageTextField.setText("Send Message");
               }
        });


//        if(response.isSuccess()){
//            this.dispose();
//            try {
//                new SidebarDemo();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
        btn.setLayout(null);



        btn.setBounds( 750, yVerticalCounter + 50, 90, 36);
//        btn.setBorder(new EmptyBorder(0, 10, 0, 10));


        panel.add(writeMessageTextField);
//        panel.add(iconPanel);
        panel.add(btn);

    }

    public void MessageUI(JPanel panel, String type, Date time, String message) {
        JPanel timePanel = new JPanel(new BorderLayout(60,20));
        JPanel messagePanel = new JPanel(new BorderLayout(30,4));

        messagePanel.setBackground(Color.decode("#FFFFFF"));
        timePanel.setBackground(null);

        if (type.equals("INCOMING")) {
            timePanel.setBounds(20, yVerticalCounter,80,20);
            messagePanel.setBounds(20,(yVerticalCounter + 20),400,30);
        }
        else if (type.equals("OUTGOING")) {
            timePanel.setBounds(425, yVerticalCounter,80,20);
            messagePanel.setBounds(430,(yVerticalCounter + 20),400,30);
        }

        JLabel timeLabel = new JLabel(time.toString());
        JLabel messageLabel = new JLabel();

        Font timeLabelFont = timeLabel.getFont();
// bold
        timeLabel.setForeground(Color.decode("#CCCCCC"));
        timeLabel.setFont(timeLabelFont.deriveFont(timeLabelFont.getStyle() | Font.PLAIN));

        timePanel.add(timeLabel, BorderLayout.CENTER);
//        messageLabel.setBorder(new EmptyBorder(0,10,0,0));

        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        messageLabel.setText(message);

        if (type.equals("INCOMING")) {
            messageLabel.setForeground(Color.decode("#3E4965"));
            messagePanel.setBackground(Color.decode("#ffffff"));
        }
        else if (type.equals("OUTGOING")) {
            messagePanel.setBackground(Color.decode("#3E4965"));
            messageLabel.setForeground(Color.decode("#FFFFFF"));
        }

        messagePanel.add(messageLabel, BorderLayout.CENTER);

        //TODO: Use Custom Font

        panel.add(timePanel);
        panel.add(messagePanel);

        yVerticalCounter += 70;



    }
    public JPanel export() {
        return centerPanel;
    }


//    public static void main(String[] args) {
//        new DirectChatScreen();
//    }
public static<T> T[] subArray(T[] array, int beg, int end) {
    return Arrays.copyOfRange(array, beg, end + 1);
}
}
