package sample;

import javax.swing.*;
import java.awt.*;

public class Groups {
    private JFrame mainWindow;
    private JLabel tit;
    private JButton AddBtn;
    public  Groups(){
        mainUnit();
    }
    public JPanel member(String names,String imgpath){
        ImageIcon userImage = new ImageIcon(imgpath);
        Image icon = userImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel user= new JLabel();
        user.setText(names);
        user.setIcon(new ImageIcon(icon));

        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.decode("#cccccc"));
        userPanel.add(user);
        return userPanel;
    }
    public void mainUnit(){
        mainWindow= new JFrame("Demo");
        mainWindow.setSize(500,500);
        tit = new JLabel("Group Members");
        AddBtn = new JButton("Add");
        AddBtn.setBackground(Color.decode("#011638"));
        AddBtn.setForeground(Color.white);
        AddBtn.setFocusPainted(false);
        AddBtn.setSize(250,30);

        JPanel addUserPanel = new JPanel();
        addUserPanel.setPreferredSize(new Dimension(150,100));
        addUserPanel.setBackground(Color.WHITE);
//        addUserPanel.setLayout(new FlowLayout());

        addUserPanel.setBounds(100,80,400,400);
//        addUserPanel.setAutoscrolls(true);

        addUserPanel.add(tit);
        addUserPanel.setLayout(new BoxLayout(addUserPanel,BoxLayout.Y_AXIS));
        addUserPanel.add(member("Cyrus  ","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\cyrus.png"));
        addUserPanel.add(member("Babin","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\Babins.png"));
        addUserPanel.add(member("Curly","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\curl.png"));
        addUserPanel.add(member("Kalisa","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\kalisa.png"));
        addUserPanel.add(AddBtn);
        Container container = new Container();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container = mainWindow.getContentPane();
        container.add(addUserPanel,BorderLayout.EAST);
//        mainWindow.add(addUserPanel,BorderLayout.EAST);

        mainWindow.setVisible(true);
    }

    public static void main(String[] args) {
        new Groups();
    }
}
