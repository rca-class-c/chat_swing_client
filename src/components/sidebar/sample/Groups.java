package components.sidebar.sample;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Group extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JLabel friendsLabel;
    private JLabel imhgLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Group frame = new Group();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Group() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setTitle("Group members");
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
        topPanel.setPreferredSize(new Dimension(0, 65));
        rightPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new BorderLayout(0, 0));
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\search.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);

        friendsLabel = new JLabel("Group members");
        friendsLabel.setBackground(new Color(240, 240, 240));
        friendsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        topPanel.add(friendsLabel, BorderLayout.SOUTH);

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

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBackground(new Color(72, 61, 139));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
//        btnNewButton.setBorder(null);
        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
                gl_centerPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_centerPanel.createSequentialGroup()
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addGap(25)
                                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(Alignment.LEADING, gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(imagePanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                        .addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                        .addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                        .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addGap(65)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(imgLabel2_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
                gl_centerPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_centerPanel.createSequentialGroup()
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(imgLabel2_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_centerPanel.createSequentialGroup()
                                                .addGap(32)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                                .addGap(155))
        );
        ImageIcon image5Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image5 = image5Icon.getImage(); // transform it
        Image newimg5 = image5.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image5Icon = new ImageIcon(newimg5);
        ImageIcon image6Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image6 = image6Icon.getImage(); // transform it
        Image newimg6 = image6.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image6Icon = new ImageIcon(newimg6);
        ImageIcon image7Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image7 = image7Icon.getImage(); // transform it
        Image newimg7 = image7.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image7Icon = new ImageIcon(newimg7);
        ImageIcon image8Icon = new ImageIcon("C:\\Users\\DELL\\Desktop\\chat_swing_client\\src\\components\\sidebar\\imgs\\webgub.png"); // load the image to a imageIcon
        Image image8 = image8Icon.getImage(); // transform it
        Image newimg8 = image8.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image8Icon = new ImageIcon(newimg8);

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
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        JLabel lblNewLabel_1 = new JLabel("Webgub");
        lblNewLabel_1.setBackground(new Color(30, 144, 255));
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
        panel_2.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_2, BorderLayout.CENTER);
    }
}


