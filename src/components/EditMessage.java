package components;

import javax.swing.*;
public class EditMessage
{
    EditMessage(){
        JFrame f= new JFrame();
        JLabel header = new JLabel("Edit Message");
        header.setBounds(10,30,150,30);
        JTextArea area=new JTextArea("Hello there this is you message content you can now edit them.");
        area.setBounds(10,60, 450,150);
        f.add(header);
        f.add(area);
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new EditMessage();
    }}