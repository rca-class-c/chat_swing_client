package components.sidebar.sample;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Friends extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel searchPanel;
    private JLabel friendsLabel;
    private JButton searchIconBtn;
    private JTextField searchInput;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Friends frame = new Friends();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Friends() {
        People p = new People();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setTitle("Friends");
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setPreferredSize(new Dimension(270,0));
        contentPane.add(rightPanel, BorderLayout.EAST);
        rightPanel.setLayout(new BorderLayout(0, 0));

        centerPanel = new JPanel();
        rightPanel.add(centerPanel);
        centerPanel.setLayout(new BorderLayout(0, 0));

        List<String> userNames = new ArrayList<String>();
        userNames.add("Adeline");
        userNames.add("Babins");
        userNames.add("Bugua");
        userNames.add("Curla");
        userNames.add("Cyrusa");
        userNames.add("Kalisa");
        userNames.add("Kami");
        userNames.add("Petersona");

        topPanel = new JPanel();
        topPanel.setForeground(new Color(128, 128, 128));
        topPanel.setBorder(new EmptyBorder(10, 30, 15, 30));
        topPanel.setBackground(new Color(240, 248, 255));
        topPanel.setPreferredSize(new Dimension(0, 85));
        rightPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new BorderLayout(0, 0));

        searchPanel = new JPanel();
        searchPanel.setBorder(new LineBorder(Color.GRAY, 1));
        searchPanel.setPreferredSize(new Dimension(0, 30));
        topPanel.add(searchPanel, BorderLayout.SOUTH);
        searchPanel.setLayout(new BorderLayout(0, 0));

        searchIconBtn = new JButton("");
        searchIconBtn.setBorder(new EmptyBorder(0,0,0,0));
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Pictures\\search.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        searchIconBtn.setIcon(imageIcon);
        searchIconBtn.setFocusPainted(false);
        searchIconBtn.setBackground(new Color(255, 255, 255));
        searchIconBtn.setPreferredSize(new Dimension(40, 0));
        searchPanel.add(searchIconBtn, BorderLayout.WEST);

        searchInput = new JTextField();
        searchInput.setForeground(new Color(128, 128, 128));
        searchInput.setText("Search Friends...");
        searchInput.setBorder(new EmptyBorder(0,0,0,0));
        searchPanel.add(searchInput, BorderLayout.CENTER);
        searchInput.setColumns(10);
        searchInput.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub

                searchInput.setForeground(new Color(128, 128, 128));
                searchPanel.setBorder(new LineBorder(Color.GRAY, 1));
                searchInput.setText("Search Friends...");
                centerPanel.removeAll();
                centerPanel.revalidate();
                centerPanel.repaint();
                p.resetY_axis();
                centerPanel.add(p.allUsers(userNames, p.button()));
            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
                searchPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(135, 206, 250), new Color(173, 216, 230)));
//				searchPanel.setBorder(new LineBorder(new Color(135,206,235), 3));
                searchInput.setForeground(Color.BLACK);
                searchInput.setText("");
            }
        });

        searchInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }


            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                String input = searchInput.getText();
                if(input==null) {
                    centerPanel.removeAll();
                    centerPanel.revalidate();
                    centerPanel.repaint();
                    p.resetY_axis();
                    centerPanel.add(p.allUsers(userNames, p.button()));
                }
                centerPanel.removeAll();
                centerPanel.revalidate();
                centerPanel.repaint();
                p.resetY_axis();
                centerPanel.add(p.findusers(userNames, input));
                System.out.println("input "+searchInput.getText());

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });


        friendsLabel = new JLabel("Friends");
        friendsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        topPanel.add(friendsLabel, BorderLayout.WEST);


//        userNames.add("Ruby");
//        userNames.add("Webgub");


//        p.findusers(userNames, "A");
//        centerPanel.add(p.findusers(userNames, "sA"));

        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();

        p.resetY_axis();

        centerPanel.add(p.allUsers(userNames,p.button()));

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
    }
}