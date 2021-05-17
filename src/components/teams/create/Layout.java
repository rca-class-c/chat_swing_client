
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Layout {
    private JFrame window;
    private Container container;
    private JPanel mainPanel;
    private JPanel sidePanel;
    private JPanel teamsPanel;
    private JPanel friendsPanel;
    private JPanel headerPanel;
    private JPanel teamsDescPanel;
    private JPanel cardsMainPanel;
    private JPanel cardsHeaderPanel;
    private JPanel cardsHeaderSubPanel;
    private JPanel groupButtonPanel;
    private JLabel teamsTitle;
    private JTextField searchTeam;
    private ImageIcon searchbg;
    private JLabel teamsCreatedTitle;
    private JLabel teamsParagraph;
    private JButton newGroupBtn;


    public void sidebar() {
        JLabel label = new JLabel("Side bar");
        sidePanel.add(label);
        sidePanel.setBackground(Color.WHITE);

    }

    public void cardsLayout() throws IOException {
        headerPanel = new JPanel(new BorderLayout(170, 40));

        teamsTitle = new JLabel("Teams");
        teamsTitle.setForeground(Color.decode("#011638"));
        teamsTitle.setFont(new Font("Inter", Font.BOLD, 16));
        searchTeam = new JTextField(30);
        searchTeam.setText("search a team");
        searchTeam.setForeground(Color.decode("#CCCCCC"));
        searchTeam.setPreferredSize(new Dimension(1, 25));
        BufferedImage img = ImageIO.read(new File("src\\assets\\clear.png"));
        searchbg = new ImageIcon(img.getScaledInstance(20, 20, BufferedImage.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(searchbg);
        searchTeam.add(imageLabel);


        searchTeam.setBorder(new EmptyBorder(0, 30, 0, 0));
        JLabel label = new JLabel("");
        headerPanel.add(teamsTitle, BorderLayout.LINE_START);
        headerPanel.add(label, BorderLayout.CENTER);
        headerPanel.add(searchTeam, BorderLayout.LINE_END);
        headerPanel.setBackground(new Color(0, 0, 0, 0));
        teamsPanel.add(headerPanel);


        //Cards
        cardsMainPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
        cardsHeaderSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 50, 10));
        cardsHeaderPanel = new JPanel(new GridLayout(2, 2, 70, 30));
        groupButtonPanel = new JPanel(new BorderLayout());
        teamsDescPanel = new JPanel(new GridLayout(2, 0));
        teamsCreatedTitle = new JLabel("Teams Created");
        teamsCreatedTitle.setForeground(Color.decode("#011638"));
        teamsCreatedTitle.setFont(new Font("Inter", Font.BOLD, 16));
        teamsParagraph = new JLabel("You have created 5 groups");
        teamsParagraph.setFont(new Font("Inter", Font.PLAIN, 12));
        teamsParagraph.setForeground(Color.decode("#B5B5C3"));
        newGroupBtn = new JButton();
        newGroupBtn.setText("New Group");
//        newGroupBtn.setSize(20,10);
//        newGroupBtn.setPreferredSize(new Dimension(1,1));
        newGroupBtn.setBackground(Color.decode("#011638"));
        newGroupBtn.setForeground(Color.WHITE);
        newGroupBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        teamsDescPanel.add(teamsCreatedTitle);
        teamsDescPanel.add(teamsParagraph);
        teamsDescPanel.setBackground(new Color(0, 0, 0, 0));
        cardsHeaderPanel.setPreferredSize(new Dimension(550, 130));
        JLabel label2 = new JLabel("");
        JLabel label4 = new JLabel("");


        groupButtonPanel.setBackground(Color.CYAN);
        groupButtonPanel.add(newGroupBtn);
        groupButtonPanel.setPreferredSize(new Dimension(1, 1));
        cardsHeaderPanel.add(teamsDescPanel);
        cardsHeaderPanel.add(label4);
        cardsHeaderPanel.add(label2);
        cardsHeaderPanel.add(groupButtonPanel);

        cardsHeaderSubPanel.setBackground(new Color(0, 0, 0, 0));
        cardsHeaderPanel.setBackground(new Color(0, 0, 0, 0));
        cardsHeaderSubPanel.add(cardsHeaderPanel);

        cardsMainPanel.add(cardsHeaderSubPanel);
        cardsMainPanel.setPreferredSize(new Dimension(810, 299));
        cardsMainPanel.setBackground(Color.WHITE);

        teamsPanel.add(cardsMainPanel);
        teamsPanel.setBackground(Color.decode("#F5F9FF"));
    }

    public void mainLayout() throws IOException {
        mainPanel.setPreferredSize(new Dimension(1200, 750));
        sidePanel = new JPanel(new FlowLayout(SwingConstants.PREVIOUS, 10, 10));
        teamsPanel = new JPanel(new FlowLayout(SwingConstants.HORIZONTAL, 10, 10));
        friendsPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
        sidePanel.setPreferredSize(new Dimension(200, 750));
        teamsPanel.setPreferredSize(new Dimension(750, 750));
        friendsPanel.setPreferredSize(new Dimension(200, 750));
        friendsPanel.setBackground(Color.decode("#E5E5E5"));
        mainPanel.add(sidePanel);
        mainPanel.add(teamsPanel);
        mainPanel.add(friendsPanel);
        sidebar();
        cardsLayout();
        mainPanel.setSize(1200, 750);
        container.add(mainPanel);
    }

    public Layout() throws IOException {
        window = new JFrame("Teams Created");
        container = window.getContentPane();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        container.setLayout(null);
        mainPanel = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        mainLayout();
        window.setSize(1200, 750);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
