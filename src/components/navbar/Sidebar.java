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
        setBounds(0,0,200, 1080);
        setLayout(null);

        JPanel navBarItems = new JPanel();
        navBarItems.setLayout(new BoxLayout(navBarItems, BoxLayout.Y_AXIS));
        navBarItems.setBounds(0, 160, 220, 500);
        navBarItems.setBackground(new Color(0,0,0,0));

        JButton teams = new SideBarListItem("user-group.png", "teams");
        teams.setActionCommand("teams");
        JLabel label1 = new JLabel("Hello from teams");
        label1.setVisible(false);
        teams.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

         JButton chat = new SideBarListItem("chat.png", "Chat");
        chat.setActionCommand("Chatting");
       JLabel label2 = new JLabel("Hello from chatting");
       label2.setVisible(false);
        chat.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JButton settings = new SideBarListItem("settings.png", "Settings");


        settings.setActionCommand("settings");
        JLabel label3 = new JLabel("Hello from settings");
        label3.setVisible(false);
        settings.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton logout = new SideBarListItem("logout.png", "Logout");
        logout.setActionCommand("logout");
        JLabel label4 = new JLabel("Hello from logout");
        label4.setVisible(false);
        logout.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        logout.setBorder(new EmptyBorder(90, 50, 0, 50));
        chat.setBorder(new EmptyBorder(15, 50, 15, 50));
        settings.setBorder(new EmptyBorder(15, 50, 15, 30));
        teams.setBorder(new EmptyBorder( 15, 50, 15, 50));

        navBarItems.add(teams);
        navBarItems.add(chat);
        navBarItems.add(settings);
        navBarItems.add(logout);

        JPanel logo = logo();
        logo.setBackground(new Color(0,0,0,0));
        logo.setVisible(true);
        add(logo);
        add(navBarItems);
    }


    public void actionListener(ActionEvent actionEvent) throws IOException {

        JLabel label = new JLabel("Sidebar");

        String command = actionEvent.getActionCommand();
        System.out.println("Command  "+command);

        switch (command) {
            case "teams" -> {
                System.out.println("teams action listener");
                frame.dispose();
                new GenerateFrame(new Layout().mainLayout());
            }
//            body.add(label);
            case "Chatting" -> {
                System.out.println("chat action listener");
                frame.dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
            }
            case "settings" -> {
                System.out.println("settings action listener");
                frame.dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
            }
            case "logout" -> {
                System.out.println("logout action listener");
                frame.dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
            }
            default -> System.out.println("Unknown");
        }
    }
    public JPanel logo(){
        JPanel myLogo = new JPanel();
        myLogo.setSize(160,110);
        myLogo.setBackground(Color.white);

        ImageIcon imageIcon = new ImageIcon("src/components/navbar/classC.jpg");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(170, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        JLabel pic = new JLabel(imageIcon);

        myLogo.add(pic);
        return myLogo;
    }
}
