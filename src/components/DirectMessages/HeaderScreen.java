package components.DirectMessages;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeaderScreen extends JFrame {
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    public HeaderScreen() throws IOException {
     UI();
    }

    public void UI() throws IOException {


        JPanel profile = new JPanel();
        profile.setBackground(Color.decode("#F5F9FF"));

        BufferedImage profileImg =  ImageIO.read(new File("src\\assets\\profile.png"));

        BufferedImage masked = this.resizeImage(profileImg, 60, 60, BufferedImage.TYPE_INT_ARGB);
        JLabel profileLabel= new JLabel(new ImageIcon(masked));
        profile.add(profileLabel);
        topPanel.add(profile);

        JPanel usernamePanel = new JPanel();
        JLabel usernames = new JLabel();
        usernames.setText("Hirwa Marie Chanelle");
        usernames.setFont(new Font("Inter", Font.BOLD, 13));
        usernames.setForeground(Color.decode("#4C5B5C"));
        usernamePanel.setBackground(Color.decode("#F5F9FF"));
        usernamePanel.add(usernames);
        topPanel.add(usernamePanel);
        topPanel.setBackground(Color.decode("#F5F9FF"));

        JPanel leftArrowPanel = new JPanel();
        BufferedImage leftArrowIcon = ImageIO.read(new File("C:\\Users\\DELL\\OneDrive\\Studies\\OOP\\Projects\\Class\\chat-system\\desktop\\chat_swing_client\\src\\assets\\profile.png"));
        BufferedImage leftMask = this.resizeImage(leftArrowIcon, 10, 10, BufferedImage.TYPE_INT_ARGB);
        JLabel leftArrowLabel= new JLabel(new ImageIcon(leftMask));
        leftArrowPanel.setBackground(Color.decode("#F5F9FF"));
        leftArrowLabel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(0,400,0,0),
                new EmptyBorder(0,0,0,0)));
        leftArrowPanel.add(leftArrowLabel);
        topPanel.setLayout(new GridBagLayout());
        topPanel.add(leftArrowPanel);

        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel todayDate = new JLabel();
        todayDate.setText("18th April 2021");
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#E5E5E5")),
                todayDate.getText(), TitledBorder.LEFT, TitledBorder.TOP);
        titledBorder.setTitleColor(Color.decode("#4C5B5C"));
        titledBorder.setTitleFont(new Font("Inter", Font.PLAIN, 12));
        datePanel.setBackground(Color.decode("#F5F9FF"));
        datePanel.setLocation(0, 500);
        datePanel.setBorder(titledBorder);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        bottomPanel.add(datePanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        mainPanel.add(bottomPanel);

        add(mainPanel);
        setBounds(280, 20, 800, 600);
        setTitle("Direct Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public JPanel export() {
        return topPanel;
    }

}
