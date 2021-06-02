package components.GroupMessages;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeaderScreen extends JFrame{

    public HeaderScreen() throws IOException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JPanel profile = new JPanel();
        profile.setBackground(Color.decode("#F5F9FF"));

        BufferedImage profileImg = ImageIO.read(new File("src/assets/team.png"));
        BufferedImage masked = this.resizeImage(profileImg, 60, 60, BufferedImage.TYPE_INT_ARGB);
        JLabel profileLabel= new JLabel(new ImageIcon(masked));
        profile.add(profileLabel);
        topPanel.add(profile);

        JPanel groupNamePanel = new JPanel();
        groupNamePanel.setBackground(Color.decode("#F5F9FF"));
        groupNamePanel.setLayout(new BoxLayout(groupNamePanel, BoxLayout.Y_AXIS));

        JLabel groupName = new JLabel();
        groupName.setText("Java Team");
        groupName.setFont(new Font("Inter", Font.BOLD, 15));
        groupName.setForeground(Color.decode("#4C5B5C"));
        groupNamePanel.add(groupName);

        JLabel groupDescription = new JLabel();
        groupDescription.setText("A team of developers devoted to coding in java program...");
        groupDescription.setFont(new Font("Inter", Font.BOLD, 12));
        groupDescription.setForeground(Color.decode("#4C5B5C"));
        groupNamePanel.add(groupDescription);

        topPanel.add(groupNamePanel);
        topPanel.setBackground(Color.decode("#F5F9FF"));
        topPanel.setSize(new Dimension(1000, 900));

        JPanel leftArrowPanel = new JPanel();
        BufferedImage leftArrowIcon = ImageIO.read(new File("src/assets/right-arrow.png"));
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
        setBounds(280, 20, 900, 600);
        setTitle("Group Message");
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

    public static void main(String[] args) throws IOException {
        new HeaderScreen();
    }
}
