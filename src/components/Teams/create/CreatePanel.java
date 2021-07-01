package components.Teams.create;

import models.Group;
import models.Request;
import models.ResponseDataSuccessDecoder;
import socket.IndexSocket;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreatePanel {
    public JPanel returnPanel(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JButton btn = new JButton("Save Group");
        btn.setBackground(new Color(53,32,88));
        btn.setForeground(Color.white);
        btn.setBorder(BorderFactory.createCompoundBorder(
                btn.getBorder(),
                BorderFactory.createEmptyBorder(7, 30, 7, 30)));
        btn.setFont(new Font("Montserrat", Font.PLAIN, 18));
        JPanel panel = new JPanel();
        JLabel header = new JLabel("Create Group");
        JPanel namePanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JLabel descLabel = new JLabel("Description:");
        panel.setPreferredSize(new Dimension(900, 750));
        header.setFont(new Font("Roboto",Font.BOLD,30));
        panel.setBackground(Color.white);

        JTextField textField = new JTextField("", 16);
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.black, 1, true),
                BorderFactory.createEmptyBorder(2, 2, 2, 2))
        );
        textField.setFont(new Font("Montserrat", Font.PLAIN, 20));
        textField.setBounds(0,0,25,10);
        textField.setColumns(25);


        JTextArea textArea = new JTextArea();
        textArea.setColumns(25);
        textArea.setFont(new Font("Roboto",Font.PLAIN,20));
        textArea.setRows(3);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));



        namePanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        headerPanel.setBackground(Color.white);
        headerPanel.add(header);
        namePanel.add(nameLabel);
        textPanel.add(descLabel);
        namePanel.add(textField);
        textPanel.add(textArea);

        namePanel.setSize(700, 100);
        headerPanel.setSize(700, 120);
        textPanel.setSize(700, 100);
        panel.setSize(750, 750);
        panel.setLocation(400,20);


        btn.addActionListener(ActionListener->{
            String name = textField.getText();
            String description = textArea.getText();
            Group newGroup = new Group(name,description,2);
            String key = "groups/new";
            Request request = new Request(newGroup,key);
            ResponseDataSuccessDecoder responseDataSuccessDecoder = new IndexSocket().execute(request);
            System.out.println(responseDataSuccessDecoder);
        });
        panel.add(headerPanel);
        panel.add(namePanel);
        panel.add(textPanel);
        panel.add(btn);
//        panel.setBackground(Color.blue);
        panel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

         return panel;
    }
}
