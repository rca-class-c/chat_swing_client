package components.navbar;


import components.Teams.create.CreatePanel;
import components.Teams.view.Layout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Sidebar extends JPanel {
    private JFrame frame;
    public Sidebar(JFrame frame) throws IOException {
        this.frame = frame;
        setBackground(Color.white);
        setBounds(0,0,220, 1080);
        setLayout(null);
        JPanel navBarItems = new JPanel();
        navBarItems.setLayout(new BoxLayout(navBarItems, BoxLayout.Y_AXIS));
        navBarItems.setBounds(0, 180, 200, 500);
            JLabel label = new JLabel("Hello from user");
            label.setVisible(false);
            JMenuItem user = new JMenuItem("Team");
            user.setActionCommand("User");
            user.addActionListener(e-> {
                try {
                    actionListener(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

         JPanel chat = new SideBarListItem("chat.png", "Chat");
        JButton chatting = new JButton("Chatting");
        chatting.setActionCommand("Chatting");
       JLabel label1 = new JLabel("Hello from chatting");
       label1.setVisible(false);
        chatting.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        JPanel team = new SideBarListItem("user-group.png", "Team");
        JPanel new_team = new SideBarListItem("user-group.png", "New Team");
        JPanel settings = new SideBarListItem("settings.png", "Settings");
        JPanel logout = new SideBarListItem("logout.png", "Logout");
        logout.setBorder(new EmptyBorder(200, 0, 0, 0));

//        navBarItems.add(label);
//        navBarItems.add(label1);
        navBarItems.add(user);
        navBarItems.add(chatting);
        navBarItems.add(chat);
        navBarItems.add(settings);
        navBarItems.add(logout);

        JPanel logo = logo();
        logo.setVisible(true);
        add(logo);
        add(navBarItems);
    }
    public void actionListener(ActionEvent actionEvent) throws IOException {

        JLabel label = new JLabel("Sidebar");

        String command = actionEvent.getActionCommand();
        System.out.println("Command  "+command);

        if(command.equals("User")){
            System.out.println("user action listener");
            frame.dispose();
            new GenerateFrame(new components.Teams.view.Layout().mainLayout());
//            body.add(label);
        }else if(command.equals("Chatting")){
            System.out.println("chat action listener");
            frame.dispose();
            new GenerateFrame(new CreatePanel().returnPanel());
        }else{
            System.out.println("Unknown");
        }
    }
    public JPanel logo(){
        JPanel myLogo = new JPanel();
        myLogo.setSize(160,110);
        myLogo.setBackground(Color.white);

        ImageIcon imageIcon = new ImageIcon("classC.jpg");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(170, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        JLabel pic = new JLabel(imageIcon);

        myLogo.add(pic);
        return myLogo;
    }
}
