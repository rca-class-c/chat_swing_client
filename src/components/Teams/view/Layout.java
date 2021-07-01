package components.Teams.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import socket.IndexSocket;
import utils.CommonUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JPanel groupInfoPanel;

    private JLabel groupNameThirdLabel;

    public Layout() throws IOException {
        window = new JFrame("Teams Created");
        container = window.getContentPane();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JLabel teamsTitle;
        JTextField searchTeam;
        ImageIcon searchbg;
        JLabel teamsCreatedTitle;
        JButton newGroupBtn;
        JLabel teamsParagraph;
        groupInfoPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        teamsGeneralPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        headerPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,70,10));

        teamsTitle = new JLabel("Teams");
        teamsTitle.setForeground(Color.decode("#011638"));
        teamsTitle.setFont(new Font("Inter", Font.BOLD, 16));
        searchTeam = new JTextField(30);
//        searchTeam.setText("search a team");
        searchTeam.setForeground(Color.decode("#CCCCCC"));
        searchTeam.setPreferredSize(new Dimension(1, 25));
        BufferedImage img = ImageIO.read(new File("src/components/Teams/view/assets/clear.png"));
        searchbg = new ImageIcon(img.getScaledInstance(20, 20, BufferedImage.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(searchbg);
        searchTeam.add(imageLabel);
        searchTeam.setBorder(new EmptyBorder(0, 30, 0, 0));
        JButton searchBtn = new JButton("Search");

        searchBtn.setBackground(Color.decode("#011638"));
        searchBtn.setPreferredSize(new Dimension(80,40));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel label = new JLabel("");
        headerPanel.add(teamsTitle);
        headerPanel.add(searchTeam);
        headerPanel.add(searchBtn);
        headerPanel.setBackground(new Color(0, 0, 0, 0));
        teamsPanel.add(headerPanel);
        //Cards
        cardsMainPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
        cardsHeaderSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 50, 10));
        cardsHeaderPanel = new JPanel(new GridLayout(2, 2, 100, 30));
        groupButtonPanel = new JPanel(new BorderLayout());
        teamsDescPanel = new JPanel(new GridLayout(4, 0));
        teamsDescPanel.setPreferredSize(new Dimension(100,700));
        teamsCreatedTitle = new JLabel("Teams Created");
        teamsCreatedTitle.setForeground(Color.decode("#011638"));
        teamsCreatedTitle.setFont(new Font("Inter", Font.BOLD, 16));
        teamsParagraph = new JLabel("");
        teamsParagraph.setBorder(new EmptyBorder(5,0,0,0));
        teamsParagraph.setFont(new Font("Inter", Font.PLAIN, 12));
        teamsParagraph.setForeground(Color.decode("#B5B5C3"));
        newGroupBtn = new JButton();
        newGroupBtn.setText("New Group");
        newGroupBtn.setBackground(Color.decode("#011638"));
        newGroupBtn.setPreferredSize(new Dimension(20,40));
        newGroupBtn.setForeground(Color.WHITE);
        newGroupBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        teamsDescPanel.add(teamsCreatedTitle);
        teamsDescPanel.add(teamsParagraph);
        teamsDescPanel.setBackground(new Color(0, 0, 0, 0));

        String key= "groups/";
        Request request = new Request(new ProfileRequestData(4), key);
        //get all group in the system
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        if(response.isSuccess()){
            Group[] groups = new GroupResponseDataDecoder().returnGroupsListDecoded(response.getData());
            CommonUtil.addTabs(10, true);
            int limit = 0;
            if (groups.length != 0 ){

                teamsParagraph.setText("You have created " +groups.length+ " groups");
                for(Group group: groups){
                    if(limit <= 2){
                        cardInfo(group.getName());
                    }else{
                        System.out.println("Limit reached");
                    }
                    limit++;
                }
            }
            else{
                System.out.println("Request failed in this group");
            }
        }else {
            System.out.println("failed to fetch users in the given group");
        }

        JLabel searchResult = new JLabel("");
        JLabel searchResultDescription = new JLabel("");

        searchResult.setForeground(Color.ORANGE);
        teamsDescPanel.add(searchResult);
//        teamsDescPanel.add(searchResultDescription);
        teamsDescPanel.setBackground(new Color(0,0,0,0));


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyValue = "groups/search";
                Request request = new Request(new SearchRequestData(searchTeam.getText()),keyValue);
                ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
                System.out.println(response.getData()+" "+response.isSuccess());
                if(response.isSuccess()){
                    try {
                        Group[] groups = new GroupResponseDataDecoder().returnGroupsListDecoded(response.getData());

                        int limit = 0;
                        if (groups.length != 0 ){
                            for(Group group: groups){
                                if(limit < 1){
                                    searchResult.setText(group.getName()+"  Description  :  "+group.getDescription());


                                }else{
                                    System.out.println("Limit reached");
                                }
                                limit++;
                            }
                        }
                    } catch (IOException jsonProcessingException) {
                        jsonProcessingException.printStackTrace();
                    }
                    CommonUtil.addTabs(10, true);


                }else {
                    System.out.println("failed to fetch users in the given group");
                }

            }
        });
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





    }
    public void cardInfo(String label) throws IOException {
        JPanel groupInfoSubPanel;
        JPanel groupInfoFirstSubPanel;
        JPanel groupInforFirstPanelTop;
        JPanel groupInfoFirstSubPanelBottom;
        JButton groupInfoFirstPanelEditButton;
        JButton groupInfoFirstPanelDeleteButton;
        JLabel groupNameLabel;

        groupInfoSubPanel = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInfoFirstSubPanel = new JPanel();
        groupInfoFirstSubPanel.setLayout(new BoxLayout(groupInfoFirstSubPanel,BoxLayout.PAGE_AXIS));
        groupInforFirstPanelTop = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInfoFirstSubPanelBottom = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
        groupInforFirstPanelTop.setPreferredSize(new Dimension(195,40));
        groupInfoFirstSubPanelBottom.setPreferredSize(new Dimension(210,90));


        groupInfoFirstPanelEditButton = new JButton("Edit");
        groupInfoFirstPanelDeleteButton = new JButton("Delete");
        groupNameLabel = new JLabel(label);
        groupNameLabel.setBounds(200,0,0,0);
        groupInforFirstPanelTop.add(groupNameLabel);
        groupInfoFirstPanelEditButton.setBackground(Color.decode("#011638"));
        groupInfoFirstPanelEditButton.setForeground(Color.WHITE);
        groupInfoFirstPanelEditButton.setBorder(new EmptyBorder(0,0,0,0));
        groupInfoFirstPanelEditButton.setPreferredSize(new Dimension(90,30));
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

        groupInfoSubPanel.add(groupInfoFirstSubPanel);

        groupInfoSubPanel.setBackground(new Color(0,0,0,0));
        groupInfoSubPanel.setPreferredSize(new Dimension(220,200));
        groupInfoPanel.add(groupInfoSubPanel);

    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
}