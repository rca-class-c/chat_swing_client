package components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import socket.IndexSocket;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditMessage
{

    public void displayMessage(String passed){
        JFrame message = new JFrame();
        message.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        message.setBounds(150,60,250,150);
        JLabel string = new JLabel(passed);
        JButton btn = new JButton("Close");
        btn.setBackground(new Color(53,32,88));
        btn.setForeground(Color.white);
        btn.setBorder(BorderFactory.createCompoundBorder(
                btn.getBorder(),
                BorderFactory.createEmptyBorder(7, 30, 7, 30)));
        btn.setFont(new Font("Montserrat", Font.PLAIN, 14));
//        btn.setBounds(50,220,300,30);

        btn.addActionListener(ActionListener->{
            message.dispose();
        });
        string.setBounds(0,0,20,1);
        JPanel p =new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(string);
        p.add(btn);
        message.add(p);
        message.setVisible(true);
    }
    EditMessage(Messages message){
        JFrame f= new JFrame();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JLabel header = new JLabel("Edit Message");
        header.setBounds(10,30,400,30);
        JTextArea area=new JTextArea(message.getContent());
        area.setBounds(10,60, 450,150);
        area.setFont(new Font("Roboto",Font.PLAIN,20));
        header.setFont(new Font("Roboto",Font.PLAIN,25));
        area.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JButton btn = new JButton("Update Message");
        btn.setBackground(new Color(53,32,88));
        btn.setForeground(Color.white);
        btn.setBorder(BorderFactory.createCompoundBorder(
                btn.getBorder(),
                BorderFactory.createEmptyBorder(7, 30, 7, 30)));
        btn.setFont(new Font("Montserrat", Font.PLAIN, 18));
        btn.setBounds(50,220,300,30);
        btn.addActionListener(ActionListener->{
            String name = area.getText();
            MessageResponseDataFormat messageResponseDataFormat = new MessageResponseDataFormat(message.getSender(), message.getId(),name);
            String key = "messages/edit";
            Request request = new Request(messageResponseDataFormat,key);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseDataSuccessDecoder responseDataSuccessDecoder = new IndexSocket().execute(request);
            if(responseDataSuccessDecoder.isSuccess()){
                displayMessage("Message updated successfully!");
            }
            else {
                displayMessage("Failed to update message");
            }
        });


        f.add(btn);
        f.add(header);
        f.add(area);
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }