package components.navbar;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;


public class Sidebar extends JPanel {
    public Sidebar() throws IOException {
        setBackground(Color.white);
        setBounds(0,0,220, 1080);
        setLayout(null);
        JPanel navBarItems = new JPanel();
        navBarItems.setLayout(new BoxLayout(navBarItems, BoxLayout.Y_AXIS));
        navBarItems.setBounds(0, 180, 200, 500);

        JPanel chat = new SideBarListItem("chat.png", "Chat");
        JPanel team = new SideBarListItem("user-group.png", "Team");
        JPanel settings = new SideBarListItem("settings.png", "Settings");
        JPanel logout = new SideBarListItem("logout.png", "Logout");
        logout.setBorder(new EmptyBorder(200, 0, 0, 0));

        navBarItems.add(chat);
        navBarItems.add(team);
        navBarItems.add(settings);
        navBarItems.add(logout);

        JPanel logo = logo();
        logo.setVisible(true);
        add(logo);
        add(navBarItems);
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
