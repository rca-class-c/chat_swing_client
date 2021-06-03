package components.Forms.form;

import com.sun.jdi.connect.spi.Connection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RegisterForm extends JFrame implements ActionListener {
    private static final Color themeColor = Color.decode("#011638");


    JLabel userNameLabel = new JLabel("Username");
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("last Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel dobLabel = new JLabel("Date of Birth");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPassLabel = new JLabel("Confirm password");

    JTextField userNameField = new JTextField();
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField genderField = new JTextField();
    JTextField dobField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPassField = new JPasswordField();

    JButton registerBtn = new JButton("REGISTER");
    JLabel signInLabel = new JLabel("<html> <font color='#011638'>Already registered?</font>  Sign in.</html>");
    JLabel helpLabel = new JLabel("<html><font color='#EFA510'>Help?</font></html>");

    public RegisterForm() throws IOException {
        setTitle("Register");
        setSize(500, 700);
        setMinimumSize(new Dimension(400,600));
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initUI() throws IOException {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel formPanel = new JPanel();
        BoxLayout formLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(formLayout);

        BufferedImage img = ImageIO.read(this.getClass().getResource("../images/logo.png"));
        Image newImg = img.getScaledInstance(100, 85, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(newImg));


        JPanel imgPanel = new JPanel(new BorderLayout());
        imgPanel.add(imgLabel, BorderLayout.CENTER);

        imgPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        imgPanel.setBackground(Color.WHITE);

        userNameField.setPreferredSize(new Dimension(200, 25));
        firstNameField.setPreferredSize(new Dimension(200, 25));
        lastNameField.setPreferredSize(new Dimension(200, 25));
        genderField.setPreferredSize(new Dimension(200, 25));
        dobField.setPreferredSize(new Dimension(200, 25));
        passwordField.setPreferredSize(new Dimension(200, 25));
        confirmPassField.setPreferredSize(new Dimension(200, 25));
        registerBtn.setPreferredSize(new Dimension(120, 30));

        registerBtn.setForeground(Color.WHITE);
        registerBtn.setBackground(themeColor);

        JPanel signInLabelPanel = new JPanel(new BorderLayout());
        JPanel helpPanel = new JPanel(new BorderLayout());

        JLabel headLabel = new JLabel("REGISTER TO CHAT SYSTEM JAVA");
        headLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        headLabel.setForeground(Color.decode("#4C5B5C"));

        JPanel headLabelPanel = new JPanel(new GridBagLayout());
        headLabelPanel.setBackground(Color.WHITE);

        JPanel userTextFieldPanel = new JPanel(new BorderLayout(60, 0));
        userTextFieldPanel.setBackground(Color.WHITE);

        JPanel fnameTextFieldPanel = new JPanel(new BorderLayout(60, 0));
        fnameTextFieldPanel.setBackground(Color.WHITE);

        JPanel lnameTextFieldPanel = new JPanel(new BorderLayout(60, 0));
        lnameTextFieldPanel.setBackground(Color.WHITE);

        JPanel genderTextFieldPanel = new JPanel(new BorderLayout(75, 0));
        genderTextFieldPanel.setBackground(Color.WHITE);

        JPanel dobTextFieldPanel = new JPanel(new BorderLayout(50, 0));
        dobTextFieldPanel.setBackground(Color.WHITE);

        JPanel passwordFieldPanel = new JPanel(new BorderLayout(60, 0));
        passwordFieldPanel.setBackground(Color.WHITE);

        JPanel confirmPassFieldPanel = new JPanel(new BorderLayout(10, 0));
        confirmPassFieldPanel.setBackground(Color.WHITE);

        JPanel signButtonPanel = new JPanel(new GridBagLayout());
        signButtonPanel.setBackground(Color.WHITE);

        headLabelPanel.add(headLabel);
        headLabelPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        userTextFieldPanel.add(userNameLabel, BorderLayout.WEST);
        userTextFieldPanel.add(userNameField, BorderLayout.CENTER);
        userTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        fnameTextFieldPanel.add(firstNameLabel, BorderLayout.WEST);
        fnameTextFieldPanel.add(firstNameField, BorderLayout.CENTER);
        fnameTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        lnameTextFieldPanel.add(lastNameLabel, BorderLayout.WEST);
        lnameTextFieldPanel.add(lastNameField, BorderLayout.CENTER);
        lnameTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        genderTextFieldPanel.add(genderLabel, BorderLayout.WEST);
        genderTextFieldPanel.add(genderField, BorderLayout.CENTER);
        genderTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        dobTextFieldPanel.add(dobLabel, BorderLayout.WEST);
        dobTextFieldPanel.add(dobField, BorderLayout.CENTER);
        dobTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        passwordFieldPanel.add(passwordLabel, BorderLayout.WEST);
        passwordFieldPanel.add(passwordField, BorderLayout.CENTER);
        passwordFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        confirmPassFieldPanel.add(confirmPassLabel, BorderLayout.WEST);
        confirmPassFieldPanel.add(confirmPassField, BorderLayout.CENTER);
        confirmPassFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        signButtonPanel.add(registerBtn);
        signButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

        signInLabelPanel.add(signInLabel, BorderLayout.EAST);
        signInLabel.setPreferredSize(new Dimension(170, 30));
        signInLabelPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        signInLabelPanel.setBackground(Color.WHITE);

        helpPanel.add(helpLabel, BorderLayout.EAST);
        helpLabel.setPreferredSize(new Dimension(35, 15));
        helpPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        helpPanel.setBackground(Color.WHITE);

        passwordLabel.setForeground(Color.decode("#011638"));
        userNameLabel.setForeground(Color.decode("#011638"));
        firstNameLabel.setForeground(Color.decode("#011638"));
        lastNameLabel.setForeground(Color.decode("#011638"));
        genderLabel.setForeground(Color.decode("#011638"));
        dobLabel.setForeground(Color.decode("#011638"));
        confirmPassLabel.setForeground(Color.decode("#011638"));


        formPanel.add(imgPanel);
        formPanel.add(headLabelPanel);
        formPanel.add(userTextFieldPanel);
        formPanel.add(fnameTextFieldPanel);
        formPanel.add(lnameTextFieldPanel);
        formPanel.add(genderTextFieldPanel);
        formPanel.add(dobTextFieldPanel);
        formPanel.add(passwordFieldPanel);
        formPanel.add(confirmPassFieldPanel);
        formPanel.add(signButtonPanel);
        formPanel.add(signInLabelPanel);
        formPanel.add(helpPanel);

        mainPanel.setBackground(Color.WHITE);
        formPanel.setBackground(Color.WHITE);
        mainPanel.add(formPanel);
        add(mainPanel);
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String gender = genderField.getText();
                String dob = dobField.getText();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg+=" \n";

//                try{
//                    Connection connection = PostegresConfig.getConnection();
//
//
//                }catch(Exception exception){
//                    exception.printStackTrace();
//                }
            }
        });


    }
    public static void main(String[] args) throws IOException {
        new RegisterForm();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
