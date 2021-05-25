package components;

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
    public Settings() throws IOException {
        JPanel mainPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridC = new GridBagConstraints();
        mainPanel.setLayout(gridBagLayout);

        JPanel headerPanel = new JPanel(new GridBagLayout());
        JPanel profile = new JPanel(new FlowLayout(FlowLayout.CENTER));
        profile.setBackground(Color.decode("#F5F9FF"));

        BufferedImage profileImg = ImageIO.read(new File("src/assets/profile.png"));
        BufferedImage masked = this.resizeImage(profileImg, 190, 200, BufferedImage.TYPE_INT_ARGB);
        JLabel profileLabel= new JLabel(new ImageIcon(masked));
        profile.add(profileLabel);

        JPanel upload = new RoundedPanel(new FlowLayout(FlowLayout.CENTER), 20, Color.decode("#011638"));
        upload.setBackground(Color.decode("#F5F9FF"));
        JButton uploadBtn = new JButton();
        uploadBtn.setText("Upload Picture");
        uploadBtn.setFont(new Font("Inter", Font.BOLD, 12));
        uploadBtn.setPreferredSize(new Dimension(120, 30));
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

        JTextField firstname = new RoundJTextField();
        firstname.setText("Hirwa");
        firstname.setFont(new Font("Inter", Font.PLAIN, 14));
        firstname.setPreferredSize(new Dimension(200, 35));

        JPanel firstnamePanel = new JPanel(new BorderLayout(10, 0));
        firstnamePanel.setBorder(BorderFactory.createEmptyBorder());
        firstnamePanel.add(firstname, BorderLayout.CENTER);
        box.add(firstnamePanel);
        box.add(Box.createHorizontalStrut(30));

        JTextField lastname = new RoundJTextField();
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

        boxV.add(Box.createVerticalStrut(30));
        boxV.add(namesPanel);

        JTextField username = new RoundJTextField();
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
        JFormattedTextField dob = new RoundedDateField(df);
        dob.setPreferredSize(new Dimension(400, 35));
        dob.setText("07/30/2004");
        dob.setFont(new Font("Inter", Font.PLAIN, 14));
        dob.addKeyListener(new textKeyListener());

        JPanel dobPanel = new JPanel(new BorderLayout(10, 0));
        dobPanel.setBorder(BorderFactory.createEmptyBorder());
        dobPanel.add(dob, BorderLayout.CENTER);
        boxV.add(dobPanel);
        boxV.add(Box.createVerticalStrut(20));

        JPasswordField password = new RoundedPasswordField();
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

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

//        int diameter = Math.min(width, height);
//        BufferedImage mask = new BufferedImage(width, height, type);
//        Graphics2D g2d = mask.createGraphics();
////        applyQualityRenderingHints(g2d);
//        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
//        g2d.dispose();
//
//        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
//        g2d = masked.createGraphics();
//        //        applyQualityRenderingHints(g2d);
//        int x = (diameter - originalImage.getWidth()) / 2;
//        int y = (diameter - originalImage.getHeight()) / 2;
//        g2d.drawImage(originalImage, x, y, null);
//        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
//        g2d.drawImage(mask, 0, 0, null);
//        g2d.dispose();

        return resizedImage;
    }

    private class RoundedPasswordField extends JPasswordField {
        private Shape shape;
        public RoundedPasswordField() { }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

    private class RoundedDateField extends JFormattedTextField {
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
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

    private class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField() { }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
            }
            return shape.contains(x, y);
        }
    }

    private class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius;

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }

    private class textKeyListener extends KeyAdapter {
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
            JOptionPane.showMessageDialog( null,"Account settings successfully updated");
        }
    }

    public static void main(String[] args) throws IOException {
        new Settings();
    }
}