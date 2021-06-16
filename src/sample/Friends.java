//package components.sidebar.sample;

package sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Friends extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel searchPanel;
    private JLabel friendsLabel;
    private JButton searchIconBtn;
    private JTextField searchInput;
    private JLabel imhgLabel;
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
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\search.jpg"); // load the image to a imageIcon
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

        friendsLabel = new JLabel("Friends");
        friendsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        topPanel.add(friendsLabel, BorderLayout.WEST);

        centerPanel = new JPanel();
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane =new JScrollPane(centerPanel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(240, 248, 255));

        JPanel imagePanel2 = new JPanel();
        imagePanel2.setBackground(new Color(240, 248, 255));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(240, 248, 255));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(240, 248, 255));

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(240, 248, 255));

        JLabel imgLabel2_1 = new JLabel("");

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(240, 248, 255));

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(240, 248, 255));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(240, 248, 255));

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(240, 248, 255));

        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(240, 248, 255));

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(240, 248, 255));

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(240, 248, 255));


        JPanel panel_13 = new JPanel();
        panel_13.setBackground(new Color(240, 248, 255));

        JPanel panel_14 = new JPanel();
        panel_14.setBackground(new Color(240, 248, 255));

        JPanel panel_15 = new JPanel();
        panel_15.setBackground(new Color(240, 248, 255));

        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
                gl_centerPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_centerPanel.createSequentialGroup()
                                .addGap(25)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel_15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_13, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_11, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(Alignment.TRAILING, gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(imagePanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(panel_9, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel_14, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_12, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(panel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(imgLabel2_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
                gl_centerPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_centerPanel.createSequentialGroup()
                                .addGap(19)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(imagePanel2, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(imgLabel2_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(panel_11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel_13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(panel_15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(56))
        );

        JLabel lblNewLabel_11 = new JLabel("");
        ImageIcon image5Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image5 = image5Icon.getImage(); // transform it
        Image newimg5 = image5.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image5Icon = new ImageIcon(newimg5);
        lblNewLabel_11.setIcon(image5Icon);
        panel_15.add(lblNewLabel_11);

        JLabel lblNewLabel_10 = new JLabel("New label");
        panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
        panel_14.add(lblNewLabel_10);

        JLabel lblNewLabel_9 = new JLabel("New label");
        panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
        panel_12.add(lblNewLabel_9);

        JLabel lblNewLabel_8 = new JLabel("");
        ImageIcon image6Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image6 = image6Icon.getImage(); // transform it
        Image newimg6 = image6.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image6Icon = new ImageIcon(newimg6);
        lblNewLabel_8.setIcon(image6Icon);
        panel_13.add(lblNewLabel_8);

        JLabel lblNewLabel_7 = new JLabel("New label");
        panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
        panel_10.add(lblNewLabel_7);

        JLabel lblNewLabel_6 = new JLabel("");
        ImageIcon image7Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image7 = image7Icon.getImage(); // transform it
        Image newimg7 = image7.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image7Icon = new ImageIcon(newimg7);
        lblNewLabel_6.setIcon(image7Icon);
        panel_11.add(lblNewLabel_6);

        JLabel lblNewLabel_5 = new JLabel("New label");
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
        panel_8.add(lblNewLabel_5);

        JLabel lblNewLabel_4 = new JLabel("");
        ImageIcon image8Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image8 = image8Icon.getImage(); // transform it
        Image newimg8 = image8.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image8Icon = new ImageIcon(newimg8);
        lblNewLabel_4.setIcon(image8Icon);
        panel_9.add(lblNewLabel_4);

        JLabel lblNewLabel_3 = new JLabel("New label");
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
        panel_6.add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("");
        ImageIcon image9Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image9 = image9Icon.getImage(); // transform it
        Image newimg9 = image9.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image9Icon = new ImageIcon(newimg9);
        lblNewLabel_2.setIcon(image9Icon);
        panel_7.add(lblNewLabel_2);
        panel_4.setLayout(new GridLayout(1, 0, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Webgub");
        panel_4.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        ImageIcon image4Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image4 = image4Icon.getImage(); // transform it
        Image newimg4 = image4.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image4Icon = new ImageIcon(newimg4);
        lblNewLabel.setIcon(image4Icon);
        panel_5.add(lblNewLabel);

        JLabel nameLabel2 = new JLabel("Cyrus");
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
        panel_3.add(nameLabel2);

        JLabel imgLabel2 = new JLabel("");
        ImageIcon image3Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\kami.png"); // load the image to a imageIcon
        Image image3 = image3Icon.getImage(); // transform it
        Image newimg3 = image3.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image3Icon = new ImageIcon(newimg3);
        imgLabel2.setIcon(image3Icon);
        imagePanel2.add(imgLabel2);

        imhgLabel = new JLabel("");
        ImageIcon image2Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\cyrus.png"); // load the image to a imageIcon
        Image image2 = image2Icon.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image2Icon = new ImageIcon(newimg2);
        imhgLabel.setIcon(image2Icon);
        panel.add(imhgLabel);

        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

        JLabel nameLabel = new JLabel("Kami Keza");
        panel_1.add(nameLabel);
        centerPanel.setLayout(gl_centerPanel);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
    }
}