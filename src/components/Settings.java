package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

public class Settings extends JFrame {
    public Settings(){
        JPanel mainPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridC = new GridBagConstraints();
        mainPanel.setLayout(gridBagLayout);

//        BoxLayout mainLayout = new CardLayout(mainPanel, BoxLayout.Y_AXIS);
//        mainPanel.setLayout(mainLayout);

        JPanel headerPanel = new JPanel(new GridBagLayout());
        JPanel profile = new JPanel(new FlowLayout(FlowLayout.CENTER));
        profile.setBackground(Color.decode("#F5F9FF"));

        ImageIcon profileImg = new ImageIcon("assets/profile.png");
        Image icon = profileImg.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);

        JLabel profileLabel= new JLabel();
        profileLabel.setIcon(new ImageIcon(icon));
        profile.add(profileLabel);

        JPanel upload = new JPanel(new FlowLayout(FlowLayout.CENTER));
        upload.setBackground(Color.decode("#F5F9FF"));
        JButton uploadBtn = new JButton();
        uploadBtn.setText("Upload Picture");
        uploadBtn.setFont(new Font("Inter", Font.BOLD, 12));
        uploadBtn.setPreferredSize(new Dimension(150, 35));
        uploadBtn.setBackground(Color.decode("#011638"));
        uploadBtn.setForeground(Color.decode("#FFFFFF"));
        uploadBtn.setBorderPainted(false);
        uploadBtn.addActionListener(new buttonActionListener());
        upload.add(uploadBtn);

        JPanel remove = new JPanel(new FlowLayout(FlowLayout.CENTER));
        remove.setBackground(Color.decode("#F5F9FF"));
        JButton removeBtn = new JButton();
        removeBtn.setText("Remove");
        removeBtn.setFont(new Font("Inter", Font.BOLD, 12));
        removeBtn.setPreferredSize(new Dimension(150, 35));
        removeBtn.setContentAreaFilled(false);
        removeBtn.setBorderPainted(false);
        removeBtn.setForeground(Color.decode("#011638"));
        removeBtn.addActionListener(new buttonActionListener());
        remove.add(removeBtn);

        headerPanel.add(profile);
        headerPanel.add(upload);
        headerPanel.add(remove);

        JPanel namesPanel = new JPanel();
        namesPanel.setBackground(Color.decode("#F5F9FF"));
        BoxLayout namesLayout = new BoxLayout(namesPanel, BoxLayout.X_AXIS);
        Box box = Box.createHorizontalBox();
        namesPanel.setLayout(namesLayout);

        JTextField firstname = new JTextField();
        firstname.setText("Hirwa");
        firstname.setFont(new Font("Inter", Font.PLAIN, 14));
        firstname.setPreferredSize(new Dimension(200, 35));

        JPanel firstnamePanel = new JPanel(new BorderLayout(10, 0));
        firstnamePanel.setBorder(BorderFactory.createEmptyBorder());
        firstnamePanel.add(firstname, BorderLayout.CENTER);
        box.add(firstnamePanel);
        box.add(Box.createHorizontalStrut(30));

        JTextField lastname = new JTextField();
        lastname.setText("Chanelle");
        lastname.setFont(new Font("Inter", Font.PLAIN, 14));
        lastname.setPreferredSize(new Dimension(200, 35));

        JPanel lastnamePanel = new JPanel(new BorderLayout(10, 0));
        lastnamePanel.setBorder(BorderFactory.createEmptyBorder());
        lastnamePanel.add(lastname, BorderLayout.CENTER);
        box.add(lastnamePanel);

        namesPanel.add(box);

        JPanel formPanel = new JPanel();
        BoxLayout formLay = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        Box boxV = Box.createVerticalBox();
        formPanel.setLayout(formLay);

        formPanel.add(namesPanel);

        JTextField username = new JTextField();
        username.setText("Chanizzo");
        username.setFont(new Font("Inter", Font.PLAIN, 14));
        username.setPreferredSize(new Dimension(400, 35));

        JPanel usernamePanel = new JPanel(new BorderLayout(10, 0));
        usernamePanel.setBorder(BorderFactory.createEmptyBorder());
        usernamePanel.add(username, BorderLayout.CENTER);
        boxV.add(Box.createVerticalStrut(20));
        boxV.add(usernamePanel);
        boxV.add(Box.createVerticalStrut(20));

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        JFormattedTextField dob = new JFormattedTextField(df);
        dob.setPreferredSize(new Dimension(400, 35));
        dob.setText("07/30/2004");
        dob.setFont(new Font("Inter", Font.PLAIN, 14));
        dob.addKeyListener(new textKeyListener());

        JPanel dobPanel = new JPanel(new BorderLayout(10, 0));
        dobPanel.setBorder(BorderFactory.createEmptyBorder());
        dobPanel.add(dob, BorderLayout.CENTER);
        boxV.add(dobPanel);
        boxV.add(Box.createVerticalStrut(20));

        JPasswordField password = new JPasswordField();
        password.setText("Password");
        password.setFont(new Font("Inter", Font.PLAIN, 14));
        password.setPreferredSize(new Dimension(400, 35));

        JPanel passwordPanel = new JPanel(new BorderLayout(10, 0));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder());
        passwordPanel.add(password, BorderLayout.CENTER);
        boxV.add(passwordPanel);
        boxV.add(Box.createVerticalStrut(20));

        formPanel.add(boxV);

        JPanel save = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        save.setBackground(Color.decode("#F5F9FF"));
        JButton saveBtn = new JButton();
        saveBtn.setText("Save");
        saveBtn.setFont(new Font("Inter", Font.BOLD, 12));
        saveBtn.setPreferredSize(new Dimension(100, 32));
        saveBtn.setBackground(Color.decode("#011638"));
        saveBtn.setForeground(Color.decode("#FFFFFF"));
        saveBtn.addActionListener(new buttonActionListener());
        save.add(saveBtn);
        formPanel.add(save);

        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.gridx = 0;
        gridC.gridy = 0;
        mainPanel.add(headerPanel, gridC);

        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.gridx = 0;
        gridC.gridy = 1;
        mainPanel.add(formPanel, gridC);

        headerPanel.setBackground(Color.decode("#F5F9FF"));
        formPanel.setBackground(Color.decode("#F5F9FF"));
        mainPanel.setBackground(Color.decode("#F5F9FF"));

        add(mainPanel);
        setBounds(280, 20, 700, 600);
        setTitle("Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class textKeyListener extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
            {
                JOptionPane.showMessageDialog(null, "Invalid birthdate");
                e.consume();
            }
        }
    }

    public class buttonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog( null,"Account settings successfully updated");
        }
    }

    public static void main(String[] args) {
        new Settings();
    }
}