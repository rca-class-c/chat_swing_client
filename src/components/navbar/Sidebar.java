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
        navBarItems.setBounds(0, 130, 220, 500);
        navBarItems.setBackground(new Color(0,0,0,0));

        JButton home = new SideBarListItem("home.png", "Home");
        home.setActionCommand("teams");
        JLabel label5 = new JLabel("Hello from teams");
        label5.setVisible(false);
        home.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton new_teams = new SideBarListItem("Newgroup.png", "New team");
        new_teams.setActionCommand("new_teams");
        JLabel label6 = new JLabel("Hello from new_teams");
        label6.setVisible(false);
        new_teams.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton group = new SideBarListItem("group.png", "group");
        group.setActionCommand("group");
        JLabel label7 = new JLabel("Hello from group");
        label7.setVisible(false);
        group.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton new_group = new SideBarListItem("add-group.png", "New group");
        new_group.setActionCommand("new_group");
        JLabel label8 = new JLabel("Hello from new_group");
        label8.setVisible(false);
        new_group.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

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

        home.setBorder(new EmptyBorder(0, 20, 0, 50));
        logout.setBorder(new EmptyBorder(68, 20, 0, 50));
        group.setBorder(new EmptyBorder(0, 20, 0, 50));
        new_group.setBorder(new EmptyBorder(0, 20, 0, 50));
        chat.setBorder(new EmptyBorder(0, 20,0 , 50));
        settings.setBorder(new EmptyBorder(0, 20, 0, 30));
        teams.setBorder(new EmptyBorder( 0, 20, 0, 50));
        new_teams.setBorder(new EmptyBorder( 0, 20, 0, 50));

        navBarItems.add(home);
        navBarItems.add(teams);
        navBarItems.add(new_teams);
        navBarItems.add(group);
        navBarItems.add(new_group);
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

            }   case "home" -> {
                    System.out.println("home action listener");
                    frame.dispose();
                    new GenerateFrame(new Layout().mainLayout());
                }
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
             case "group" -> {
                System.out.println("group action listener");
                frame.dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
             }
            case "new_group" -> {
                System.out.println("new_group action listener");
                frame.dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
            }
            case "new_teams" -> {
                System.out.println("new_teams action listener");
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
