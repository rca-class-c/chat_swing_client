package components.Forms.form;
import components.navbar.SidebarDemo;
import models.AuthInput;
import models.Request;
import models.ResponseDataSuccessDecoder;
import socket.IndexSocket;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class LoginForm extends JFrame implements ActionListener{
    private ActionListener action;
    private static final Color themeColor = Color.decode("#011638");


    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JLabel signUpLabel = new JLabel("<html> <font color='#011638'>Don't have account?</font>  Sign Up.</html>");
    JLabel helpLabel = new JLabel("<html><font color='#EFA510'>Help?</font></html>");


    public LoginForm() throws IOException {
        setTitle("Login");
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
        Image newImg = img.getScaledInstance(100,85,Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(newImg));


        JPanel imgPanel = new JPanel(new BorderLayout());
        imgPanel.add(imgLabel, BorderLayout.CENTER);

        imgPanel.setBorder(BorderFactory.createEmptyBorder(0,0,35,0));
        imgPanel.setBackground(Color.WHITE);


        userTextField.setPreferredSize(new Dimension(200, 25));
        passwordField.setPreferredSize(new Dimension(200, 25));
        loginButton.setPreferredSize(new Dimension(120, 30));


        loginButton.setBackground(themeColor);
       loginButton.setForeground(Color.WHITE);

        JPanel signupLabelPanel = new JPanel(new BorderLayout());
        JPanel helpPanel = new JPanel(new BorderLayout());

        JLabel headLabel = new JLabel("LOGIN TO CHAT SYSTEM JAVA");
        headLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        headLabel.setForeground(Color.decode("#4C5B5C"));

        JPanel headLabelPanel = new JPanel(new GridBagLayout());
        headLabelPanel.setBackground(Color.WHITE);

        JPanel userTextFieldPanel = new JPanel(new BorderLayout(10, 0));
        userTextFieldPanel.setBackground(Color.WHITE);

        JPanel passwordFieldPanel = new JPanel(new BorderLayout(10,0));
        passwordFieldPanel.setBackground(Color.WHITE);

        JPanel loginButtonPanel = new JPanel(new GridBagLayout());
        loginButtonPanel.setBackground(Color.WHITE);

        headLabelPanel.add(headLabel);
        headLabelPanel.setBorder(BorderFactory.createEmptyBorder(0,0, 20,0));

        userTextFieldPanel.add(userLabel, BorderLayout.WEST);
        userTextFieldPanel.add(userTextField, BorderLayout.CENTER);
        userTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0,0,12,0));


        passwordLabel.setForeground(Color.decode("#011638"));
        userLabel.setForeground(Color.decode("#011638"));

        passwordFieldPanel.add(passwordLabel, BorderLayout.WEST);
        passwordFieldPanel.add(passwordField, BorderLayout.CENTER);
        passwordFieldPanel.setBorder(BorderFactory.createEmptyBorder(0,0,12,0));

        loginButtonPanel.add(loginButton);
        loginButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0,0));

        signupLabelPanel.add(signUpLabel, BorderLayout.EAST);
        signUpLabel.setPreferredSize(new Dimension(170,30));
        signupLabelPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        signupLabelPanel.setBackground(Color.WHITE);

        helpPanel.add(helpLabel,BorderLayout.EAST);
        helpLabel.setPreferredSize(new Dimension(35,15));
        helpPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        helpPanel.setBackground(Color.WHITE);


        formPanel.add(imgPanel);
        formPanel.add(headLabelPanel);
        formPanel.add(userTextFieldPanel);
        formPanel.add(passwordFieldPanel);
        formPanel.add(loginButtonPanel);
        formPanel.add(signupLabelPanel);
        formPanel.add(helpPanel);


        mainPanel.setBackground(Color.WHITE);
        formPanel.setBackground(Color.WHITE);
        mainPanel.add(formPanel);
        add(mainPanel);

        signupLabelPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupLabelPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                try {
                    new ActivationForm();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        loginButton.addActionListener(e -> {


            String username = userTextField.getText();
            String password = passwordField.getText();


            AuthInput loginData = new AuthInput(username,password);
            String url = "users/login";
            Request request = new Request(loginData,url);
            ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
            if(response.isSuccess()){
                this.dispose();
                try {
                    new SidebarDemo();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            else{
                this.dispose();
                try {
                    new LoginForm();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
