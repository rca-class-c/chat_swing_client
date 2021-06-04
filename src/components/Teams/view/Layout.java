package components.Teams.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import socket.IndexSocket;
import utils.CommonUtil;

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
    private JPanel teamsPanel;
    private JPanel headerPanel;
    private JPanel teamsDescPanel;
    private JPanel cardsMainPanel;
    private JPanel cardsHeaderPanel;
    private JPanel cardsHeaderSubPanel;
    private JPanel groupButtonPanel;
    private JPanel teamsGeneralPanel;
    private JPanel groupInfoSubPanel;
    private JPanel groupInfoPanel;
    private JPanel groupInfoFirstSubPanel;
    private JPanel groupInfoSecondSubPanel;
    private JPanel groupInfoThirdSubPanel;
    private JPanel groupInforFirstPanelTop;
    private JPanel groupInfoFirstSubPanelBottom;
    private JPanel groupInfoSecondSubPanelTop;
    private JPanel groupInfoSecondSubPanelBottom;
    private JPanel groupInfoThirdSubPanelTop;
    private JPanel groupInfoThirdSubPanelBottom;
    private JPanel settingPanel;
    private JButton groupInfoFirstPanelEditButton;
    private JButton groupInfoFirstPanelDeleteButton;
    private JButton groupInfoSecondPanelEditButton;
    private JButton groupInfoSecondPanelDeleteButton;
    private JButton groupInfoThirdPanelEditButton;
    private JButton groupInfoThirdPanelDeleteButton;
    private JLabel teamsTitle;
    private JTextField searchTeam;
    private ImageIcon searchbg;
    private JLabel teamsCreatedTitle;
    private JLabel teamsParagraph;
    private JButton newGroupBtn;
    private JLabel groupNameLabel;
    private JLabel groupNameSecondLabel;
    private JLabel groupNameThirdLabel;
    private JButton editButton;
    private JButton deleteButton;
    public int userId;
    public Layout() throws IOException {
        window = new JFrame("Teams Created");
        container = window.getContentPane();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        container.setLayout(null);
        mainPanel = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        mainLayout();
        window.setSize(750, 750);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public JPanel mainLayout() throws IOException {
        mainPanel.setPreferredSize(new Dimension(750, 750));
        teamsPanel = new JPanel(new FlowLayout(SwingConstants.HORIZONTAL, 10, 10));
        teamsPanel.setPreferredSize(new Dimension(750, 750));
        mainPanel.add(teamsPanel);
        cardsLayout();
        mainPanel.setSize(750, 750);
        mainPanel.setLocation(203,0);
        container.add(mainPanel);
        return mainPanel;
    }

    public void cardsLayout() throws IOException {
        groupInfoPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        teamsGeneralPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        headerPanel = new JPanel(new BorderLayout(170, 40));

        teamsTitle = new JLabel("Teams");
        teamsTitle.setForeground(Color.decode("#011638"));
        teamsTitle.setFont(new Font("Inter", Font.BOLD, 16));
        searchTeam = new JTextField(30);
        searchTeam.setText("search a team");
        searchTeam.setForeground(Color.decode("#CCCCCC"));
        searchTeam.setPreferredSize(new Dimension(1, 25));
        BufferedImage img = ImageIO.read(new File("src/components/Teams/view/assets/clear.png"));
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
        newGroupBtn.setPreferredSize(new Dimension(20,40));
        newGroupBtn.setForeground(Color.WHITE);
        newGroupBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        teamsDescPanel.add(teamsCreatedTitle);
        teamsDescPanel.add(teamsParagraph);
        teamsDescPanel.setBackground(new Color(0, 0, 0, 0));
        cardsHeaderPanel.setPreferredSize(new Dimension(550, 130));
        JLabel label2 = new JLabel("");
        JLabel label4 = new JLabel("");


        groupButtonPanel.setBackground(new Color(0,0,0,0));
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
        teamsGeneralPanel.setPreferredSize(new Dimension(810,350));
        groupInfoPanel.setPreferredSize( new Dimension( 810,200));
        groupInfoPanel.setBackground(new Color(0,0,0,0));
        cardsMainPanel.setPreferredSize(new Dimension(810, 150));
        teamsGeneralPanel.add(cardsMainPanel);
        teamsGeneralPanel.add(groupInfoPanel);
        teamsGeneralPanel.setBackground(Color.WHITE);
        teamsPanel.add(teamsGeneralPanel);

        cardsMainPanel.setBackground(new Color(0,0,0,0));
        teamsPanel.setBackground(Color.decode("#F5F9FF"));
        cardInfo();
    }
    public void cardInfo() throws IOException {
        String key= "groups/";
        Request request = new Request(new ProfileRequestData(4), key);
        //get all group in the system
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        if(response.isSuccess()){
            Group[] groups = new GroupResponseDataDecoder().returnGroupsListDecoded(response.getData());
            CommonUtil.addTabs(10, true);
            if (groups.length != 0){
                for(int i=0; i<groups.length; i++){
                    groupNameLabel = new JLabel(groups[0].getName());
                    groupNameSecondLabel = new JLabel(groups[1].getName());
                    groupNameThirdLabel = new JLabel(groups[2].getName());
                }
            }else{
                System.out.println("Request failed in this group");
            }
        }else {
            System.out.println("failed to fetch users in the given group");
        }
        groupInfoSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInfoFirstSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
        groupInfoSecondSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
        groupInfoThirdSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
        groupInfoFirstSubPanel.setPreferredSize(new Dimension(220,110));
        groupInfoSecondSubPanel.setPreferredSize(new Dimension(220,110));
        groupInfoThirdSubPanel.setPreferredSize(new Dimension(220,110));

        groupInforFirstPanelTop = new JPanel(new FlowLayout(SwingConstants.LEADING,50,10));
        groupInfoFirstSubPanelBottom = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInforFirstPanelTop.setPreferredSize(new Dimension(210,40));
        groupInfoFirstSubPanelBottom.setPreferredSize(new Dimension(210,90));

        groupInfoSecondSubPanelTop = new JPanel(new FlowLayout(SwingConstants.LEADING,50,10));
        groupInfoSecondSubPanelBottom = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInfoSecondSubPanelTop.setPreferredSize(new Dimension(210,40));
        groupInfoSecondSubPanelBottom.setPreferredSize(new Dimension(210,90));

        groupInfoThirdSubPanelTop = new JPanel(new FlowLayout(SwingConstants.LEADING,50,10));
        groupInfoThirdSubPanelBottom = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInfoThirdSubPanelTop.setPreferredSize(new Dimension(210,40));
        groupInfoThirdSubPanelBottom.setPreferredSize(new Dimension(210,90));


        groupInfoFirstPanelEditButton = new JButton("Edit");
        groupInfoFirstPanelDeleteButton = new JButton("Delete");

        groupNameLabel.setBounds(200,0,0,0);
        groupInforFirstPanelTop.add(groupNameLabel);
        groupInfoFirstPanelEditButton.setBackground(Color.decode("#011638"));
        groupInfoFirstPanelEditButton.setForeground(Color.WHITE);
        groupInfoFirstPanelEditButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoFirstPanelEditButton.setPreferredSize(new Dimension(90,30));
        teamsParagraph.setFont(new Font("Inter", Font.PLAIN, 12));
        groupInfoFirstPanelDeleteButton.setBackground(Color.decode("#D41D11"));
        groupInfoFirstPanelDeleteButton.setForeground(Color.WHITE);
        groupInfoFirstPanelDeleteButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoFirstPanelDeleteButton.setPreferredSize(new Dimension(90,30));

        groupInfoFirstSubPanelBottom.add(groupInfoFirstPanelEditButton);
        groupInfoFirstSubPanelBottom.add(groupInfoFirstPanelDeleteButton);

        BufferedImage img = ImageIO.read(new File("src/components/Teams/view/assets/message.png"));
        ImageIcon icon = new ImageIcon(img.getScaledInstance(25,25,BufferedImage.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        groupInforFirstPanelTop.add(imageLabel);

        groupInforFirstPanelTop.setBackground(new Color(0,0,0,0));
        groupInfoFirstSubPanelBottom.setBackground(new Color(0,0,0,0));
        groupInfoFirstSubPanel.setBackground(Color.decode("#F3F6F9"));
        groupInfoFirstSubPanel.add(groupInforFirstPanelTop);
        groupInfoFirstSubPanel.add(groupInfoFirstSubPanelBottom);


        BufferedImage secondImage = ImageIO.read(new File("src/components/Teams/view/assets/message.png"));
        ImageIcon icon1 = new ImageIcon(secondImage.getScaledInstance(25,25,BufferedImage.SCALE_DEFAULT));
        JLabel imageSecondLabel = new JLabel();
        imageSecondLabel.setIcon(icon1);


        groupInfoSecondPanelEditButton = new JButton("Edit");
        groupInfoSecondPanelDeleteButton = new JButton("Delete");


        groupInfoSecondPanelEditButton.setBackground(Color.decode("#011638"));
        groupInfoSecondPanelEditButton.setForeground(Color.WHITE);
        groupInfoSecondPanelEditButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoSecondPanelEditButton.setPreferredSize(new Dimension(90,30));
        groupInfoSecondPanelDeleteButton.setBackground(Color.decode("#D41D11"));
        groupInfoSecondPanelDeleteButton.setForeground(Color.WHITE);
        groupInfoSecondPanelDeleteButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoSecondPanelDeleteButton.setPreferredSize(new Dimension(90,30));

        groupInfoSecondSubPanelBottom.add(groupInfoSecondPanelEditButton);
        groupInfoSecondSubPanelBottom.add(groupInfoSecondPanelDeleteButton);

        groupInfoSecondSubPanelTop.add(groupNameSecondLabel);
        groupInfoSecondSubPanel.add(groupInfoSecondSubPanelTop);
        groupInfoSecondSubPanel.add(groupInfoSecondSubPanelBottom);
        groupInfoSecondSubPanelTop.add(imageSecondLabel);

        groupInfoThirdPanelEditButton = new JButton("Edit");
        groupInfoThirdPanelDeleteButton = new JButton("Delete");

        groupNameThirdLabel.setBounds(200,0,0,0);
        groupInfoThirdSubPanelTop.add(groupNameThirdLabel);
        groupInfoThirdPanelEditButton.setBackground(Color.decode("#011638"));
        groupInfoThirdPanelEditButton.setForeground(Color.WHITE);
        groupInfoThirdPanelEditButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoThirdPanelEditButton.setPreferredSize(new Dimension(90,30));
        groupInfoThirdPanelDeleteButton.setBackground(Color.decode("#D41D11"));
        groupInfoThirdPanelDeleteButton.setForeground(Color.WHITE);
        groupInfoThirdPanelDeleteButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoThirdPanelDeleteButton.setPreferredSize(new Dimension(90,30));

        groupInfoThirdSubPanelBottom.add(groupInfoThirdPanelEditButton);
        groupInfoThirdSubPanelBottom.add(groupInfoThirdPanelDeleteButton);

        BufferedImage thirdImage = ImageIO.read(new File("src/components/Teams/view/assets/message.png"));
        ImageIcon thirdIcon = new ImageIcon(thirdImage.getScaledInstance(25,25,BufferedImage.SCALE_DEFAULT));
        JLabel thirdLabel = new JLabel();
        thirdLabel.setIcon(thirdIcon);
        groupInfoThirdSubPanelTop.add(thirdLabel);

        groupInfoThirdSubPanelTop.setBackground(new Color(0,0,0,0));
        groupInfoThirdSubPanelBottom.setBackground(new Color(0,0,0,0));
        groupInfoThirdSubPanel.setBackground(Color.decode("#F3F6F9"));
        groupInfoThirdSubPanel.add(groupInfoThirdSubPanelTop);
        groupInfoThirdSubPanel.add(groupInfoThirdSubPanelBottom);


        groupInfoThirdSubPanel.add(groupInfoThirdSubPanelTop);
        groupInfoThirdSubPanel.add(groupInfoThirdSubPanelBottom);

        groupInfoSubPanel.add(groupInfoFirstSubPanel);
        groupInfoSubPanel.add(groupInfoSecondSubPanel);
        groupInfoSubPanel.add(groupInfoThirdSubPanel);
        groupInfoSubPanel.setBackground(new Color(0,0,0,0));
        groupInfoSubPanel.setPreferredSize(new Dimension(810,200));
        groupInfoPanel.add(groupInfoSubPanel);
    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
}
