package components.Teams.create;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CreatePanel {
    public CreatePanel(){

    }
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
        JLabel nameLabel = new JLabel("Name:");
        JLabel descLabel = new JLabel("Description:");
        panel.setPreferredSize(new Dimension(900, 750));
        header.setFont(new Font("Roboto",Font.BOLD,30));
        panel.setBackground(Color.white);

        JTextField textField = new JTextField("", 20);
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.black, 1, true),
                BorderFactory.createEmptyBorder(2, 2, 2, 2))
        );
        textField.setFont(new Font("Montserrat", Font.PLAIN, 20));
        textField.setBounds(0,0,30,10);
        textField.setColumns(38);


        JTextArea textArea = new JTextArea();
        textArea.setColumns(37);
        textArea.setFont(new Font("Roboto",Font.PLAIN,20));
        textArea.setRows(3);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));



        namePanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        namePanel.add(nameLabel);
        textPanel.add(descLabel);
        namePanel.add(textField);
        textPanel.add(textArea);

        namePanel.setSize(750, 100);
        textPanel.setSize(750, 100);
        panel.setSize(750, 750);
        panel.setLocation(400,20);

        panel.add(header);
        panel.add(namePanel);
        panel.add(textPanel);
        panel.add(btn);
//        panel.setBackground(Color.blue);
        panel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

         return panel;
    }
}
