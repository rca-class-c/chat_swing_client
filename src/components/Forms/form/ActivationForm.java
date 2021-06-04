package components.Forms.form;

import components.navbar.SidebarDemo;
import models.ProfileRequestData;
import models.Request;
import models.ResponseDataSuccessDecoder;
import socket.IndexSocket;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActivationForm extends JFrame implements ActionListener{

    private static final Color themeColor = Color.decode("#011638");
    JLabel activationLabel = new JLabel("Activation Code ");
    JTextField activationField = new JTextField();
    JButton activateButton = new JButton("ACTIVATE");
    JLabel signUpLabel = new JLabel("<html> <font color='#011638'>Already registered?</font>  Sign In.</html>");
    JLabel helpLabel = new JLabel("<html><font color='#EFA510'>Help?</font></html>");

    public ActivationForm() throws IOException {
        setTitle(" Activation");
        setSize(700, 500);
        setMinimumSize(new Dimension(400,600));
        initialUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initialUI() throws IOException {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel formPanel = new JPanel();
        BoxLayout formLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(formLayout);

        BufferedImage img = ImageIO.read(new File("src/components/Forms/images/logo.png"));
        Image newImg = img.getScaledInstance(100,85,Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(newImg));


        JPanel imgPanel = new JPanel(new BorderLayout());
        imgPanel.add(imgLabel, BorderLayout.CENTER);

        imgPanel.setBorder(BorderFactory.createEmptyBorder(0,0,35,0));
        imgPanel.setBackground(Color.WHITE);

        activationField.setPreferredSize(new Dimension(200, 25));
        activateButton.setPreferredSize(new Dimension(120, 30));
        activateButton.setForeground(Color.WHITE);
        activateButton.setBackground(themeColor);

        JPanel signupLabelPanel = new JPanel(new BorderLayout());
        JPanel helpPanel = new JPanel(new BorderLayout());

        JLabel headLabel = new JLabel("JOIN TO CHAT SYSTEM JAVA");
        headLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        headLabel.setForeground(Color.decode("#4C5B5C"));

        JPanel headLabelPanel = new JPanel(new GridBagLayout());
        headLabelPanel.setBackground(Color.WHITE);

        JPanel activationPanel = new JPanel(new BorderLayout(10, 0));
        activationPanel.setBackground(Color.WHITE);

        JPanel activateButtonPanel = new JPanel(new GridBagLayout());
        activateButtonPanel.setBackground(Color.WHITE);

        headLabelPanel.add(headLabel);
        headLabelPanel.setBorder(BorderFactory.createEmptyBorder(0,0, 20,0));


        activationPanel.add(activationLabel, BorderLayout.WEST);
        activationPanel.add(activationField, BorderLayout.CENTER);
        activationPanel.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

        activationLabel.setForeground(Color.decode("#011638"));

        activateButtonPanel.add(activateButton);
        activateButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0,0));


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
        formPanel.add(activationPanel);
        formPanel.add(activateButtonPanel);
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
                    new LoginForm();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        activateButton.addActionListener(e -> {


            int code = Integer.parseInt(activationField.getText());
            String  key= "users/verify";

            Request request = new Request(new ProfileRequestData(code),key);
            ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
            if(response.isSuccess()){
                this.dispose();
                try {
                    new RegisterForm();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                System.out.println("Activation code doesn't exist");
            }
            });

    }

    public static void main(String[] args) throws IOException {
        new ActivationForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
