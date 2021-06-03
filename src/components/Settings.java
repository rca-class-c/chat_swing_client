package components;

import models.*;
import socket.IndexSocket;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Settings extends JFrame {
    private JTextField firstname;
    private JTextField lastname;
    private JTextField username;
    private JTextField email;
    private JFormattedTextField dob;
    private JPasswordField password;
    private String gender;
    private String status;
    private int catId;
    private final int id = 2;

    public Settings() throws IOException {
        String key = "users/profile";
        Request request = new Request(new ProfileRequestData(id), key);
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);

        if(response.isSuccess()) {
            User profile = new UserResponseDataDecoder().returnUserDecoded(response.getData());
            gender = profile.getGender();
            status = profile.getStatus();
            catId = profile.getCategoryID();

            JPanel mainPanel = new JPanel();
            GridBagLayout gridBagLayout = new GridBagLayout();
            GridBagConstraints gridC = new GridBagConstraints();
            mainPanel.setLayout(gridBagLayout);

            JPanel headerPanel = new JPanel(new GridBagLayout());
            JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            profilePanel.setBackground(Color.decode("#F5F9FF"));

            BufferedImage profileImg = ImageIO.read(new File("src/assets/profile.png"));
            BufferedImage masked = this.resizeImage(profileImg, 190, 200, BufferedImage.TYPE_INT_ARGB);
            JLabel profileLabel = new JLabel(new ImageIcon(masked));
            profilePanel.add(profileLabel);

//            upload = new RoundedPanel(new FlowLayout(FlowLayout.CENTER), 20, Color.decode("#011638"));
//            upload.setBackground(Color.decode("#F5F9FF"));
//            uploadBtn = new JButton();
//            uploadBtn.setText("Upload Picture");
//            uploadBtn.setFont(new Font("Inter", Font.BOLD, 12));
//            uploadBtn.setPreferredSize(new Dimension(120, 30));
//            uploadBtn.setBackground(Color.decode("#011638"));
//            uploadBtn.setForeground(Color.decode("#FFFFFF"));
//            uploadBtn.setBorderPainted(false);
//            uploadBtn.addActionListener(new buttonActionListener());
//            upload.add(uploadBtn);

//            remove = new JPanel(new FlowLayout(FlowLayout.CENTER));
//            remove.setBackground(Color.decode("#F5F9FF"));
//            removeBtn = new JButton();
//            removeBtn.setText("Remove");
//            removeBtn.setFont(new Font("Inter", Font.BOLD, 12));
//            removeBtn.setPreferredSize(new Dimension(150, 35));
//            removeBtn.setContentAreaFilled(false);
//            removeBtn.setBorderPainted(false);
//            removeBtn.setForeground(Color.decode("#011638"));
//            removeBtn.addActionListener(new buttonActionListener());
//            remove.add(removeBtn);

            headerPanel.add(profilePanel);
//            headerPanel.add(upload);
//            headerPanel.add(remove);

            JPanel namesPanel = new JPanel();
            namesPanel.setBackground(Color.decode("#F5F9FF"));
            BoxLayout namesLayout = new BoxLayout(namesPanel, BoxLayout.X_AXIS);
            Box box = Box.createHorizontalBox();
            namesPanel.setLayout(namesLayout);

            firstname = new RoundJTextField();
            firstname.setText(profile.getFname());
            firstname.setFont(new Font("Inter", Font.PLAIN, 14));
            firstname.setForeground(Color.decode("#989494"));
            firstname.setPreferredSize(new Dimension(200, 35));

            JPanel firstnamePanel = new JPanel(new BorderLayout(10, 0));
            firstnamePanel.setBorder(BorderFactory.createEmptyBorder());
            firstnamePanel.add(firstname, BorderLayout.CENTER);
            box.add(firstnamePanel);
            box.add(Box.createHorizontalStrut(30));

            lastname = new RoundJTextField();
            lastname.setText(profile.getLname());
            lastname.setFont(new Font("Inter", Font.PLAIN, 14));
            lastname.setForeground(Color.decode("#989494"));
            lastname.setPreferredSize(new Dimension(200, 35));

            JPanel lastnamePanel = new JPanel(new BorderLayout(10, 0));
            lastnamePanel.setBorder(BorderFactory.createEmptyBorder());
            lastnamePanel.add(lastname, BorderLayout.CENTER);
            box.add(lastnamePanel);

            namesPanel.add(box);

            JPanel credentialPanel = new JPanel();
            credentialPanel.setBackground(Color.decode("#F5F9FF"));
            BoxLayout credentialLayout = new BoxLayout(credentialPanel, BoxLayout.X_AXIS);
            Box boxC = Box.createHorizontalBox();
            credentialPanel.setLayout(credentialLayout);

            username = new RoundJTextField();
            username.setText(profile.getUsername());
            username.setFont(new Font("Inter", Font.PLAIN, 14));
            username.setForeground(Color.decode("#989494"));
            username.setPreferredSize(new Dimension(200, 35));

            JPanel usernamePanel = new JPanel(new BorderLayout(10, 0));
            usernamePanel.setBorder(BorderFactory.createEmptyBorder());
            usernamePanel.add(username, BorderLayout.CENTER);
            boxC.add(usernamePanel);
            boxC.add(Box.createHorizontalStrut(30));

            email = new RoundJTextField();
            email.setText(profile.getEmail());
            email.setFont(new Font("Inter", Font.PLAIN, 14));
            email.setForeground(Color.decode("#989494"));
            email.setPreferredSize(new Dimension(200, 35));

            JPanel emailPanel = new JPanel(new BorderLayout(10, 0));
            emailPanel.setBorder(BorderFactory.createEmptyBorder());
            emailPanel.add(email, BorderLayout.CENTER);
            boxC.add(emailPanel);

            credentialPanel.add(boxC);

            //    private JPanel upload;
            //    private JButton uploadBtn;
            //    private JPanel remove;
            //    private JButton removeBtn;
            JPanel formPanel = new JPanel();
            BoxLayout formLay = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
            Box boxV = Box.createVerticalBox();
            formPanel.setLayout(formLay);

            boxV.add(Box.createVerticalStrut(30));
            boxV.add(namesPanel);

            boxV.add(Box.createVerticalStrut(30));
            boxV.add(credentialPanel);
            boxV.add(Box.createVerticalStrut(30));

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            dob = new RoundedDateField(df);
            dob.setPreferredSize(new Dimension(400, 35));
            dob.setText(profile.getDob());
            dob.setFont(new Font("Inter", Font.PLAIN, 14));
            dob.setForeground(Color.decode("#989494"));
            dob.addKeyListener(new textKeyListener());

            JPanel dobPanel = new JPanel(new BorderLayout(10, 0));
            dobPanel.setBorder(BorderFactory.createEmptyBorder());
            dobPanel.add(dob, BorderLayout.CENTER);
            boxV.add(dobPanel);
            boxV.add(Box.createVerticalStrut(20));

            password = new RoundedPasswordField();
            password.setText(profile.getPassword());
            password.setFont(new Font("Inter", Font.PLAIN, 14));
            password.setForeground(Color.decode("#989494"));
            password.setPreferredSize(new Dimension(400, 35));

            JPanel passwordPanel = new JPanel(new BorderLayout(10, 0));
            passwordPanel.setBorder(BorderFactory.createEmptyBorder());
            passwordPanel.add(password, BorderLayout.CENTER);
            boxV.add(passwordPanel);
            boxV.add(Box.createVerticalStrut(20));

            formPanel.add(boxV);

            JPanel save = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            save.setBackground(Color.decode("#F5F9FF"));
            save.setSize(10, 32);
            JButton saveBtn = new JButton();
            saveBtn.setText("Save");
            saveBtn.setFont(new Font("Inter", Font.BOLD, 12));
            saveBtn.setPreferredSize(new Dimension(100, 32));
            saveBtn.setBackground(Color.decode("#011638"));
            saveBtn.setForeground(Color.decode("#FFFFFF"));
            saveBtn.addActionListener(new buttonActionListener());
            saveBtn.setBorderPainted(false);
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
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    private static class RoundedPasswordField extends JPasswordField {
        private Shape shape;
        public RoundedPasswordField() { }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(Color.decode("#4C5B5C"));
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

    private static class RoundedDateField extends JFormattedTextField {
        private Shape shape;
        public RoundedDateField(DateFormat dateFormat) {
            super(dateFormat);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(Color.decode("#4C5B5C"));
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

    private static class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField() { }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(Color.decode("#4C5B5C"));
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

//    private static class RoundedPanel extends JPanel {
//        private Color backgroundColor;
//        private int cornerRadius;
//
//        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
//            super(layout);
//            cornerRadius = radius;
//            backgroundColor = bgColor;
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
//            int width = getWidth();
//            int height = getHeight();
//            Graphics2D graphics = (Graphics2D) g;
//            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//            //Draws the rounded panel with borders.
//            if (backgroundColor != null) {
//                graphics.setColor(backgroundColor);
//            } else {
//                graphics.setColor(getBackground());
//            }
//            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
//            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//        }
//    }

    private static class textKeyListener extends KeyAdapter {
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

    private class buttonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String firstName = firstname.getText();
            String lastName = lastname.getText();
            String userName = username.getText();
            String Email = email.getText();
            String birthdate = dob.getText();
            String pass = String.valueOf(password.getPassword());

            User newProfile = new User(id, firstName, lastName, pass, Email, birthdate, userName, gender, catId, status);

            String updateKey = "users/update";
            Request request = new Request(newProfile, updateKey);
            ResponseDataSuccessDecoder response = new IndexSocket().execute(request);

            if(response.isSuccess()) {
                JOptionPane.showMessageDialog(null, "Account settings successfully updated");
            }else{
                JOptionPane.showMessageDialog(null, "Account settings failed to update");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Settings();
    }
}