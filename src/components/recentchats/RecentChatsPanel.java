package components.recentchats;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RecentChatsPanel {
    JPanel panel3 = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(22,25);
            int width = 420;
            int height = 100;
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded opaque panel with borders.

            graphics.setColor(Color.white);
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
            graphics.setColor(Color.WHITE);
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
        }
    };

    JLabel label3A = new JLabel();
    JLabel label3B = new JLabel();

    RecentChatsPanel() throws IOException {
        BufferedImage master = ImageIO.read(new File("src/Images/batman.jpg"));

        int diameter = Math.min(60, 60);
        BufferedImage mask = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
//        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        //        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();
        JLabel label = new JLabel(new ImageIcon(masked));
        JPanel ImagePanel = new JPanel();
        ImagePanel.add(label);
        ImagePanel.setPreferredSize(new Dimension(62, 65));
        ImagePanel.setBackground(new Color(0, 0, 0, 0));
//        ImagePanel.setLayout();
        panel3.add(ImagePanel);

//Label3A
//        panel3.add(Box.createHorizontalGlue());
        label3A.setText("El Maestro");
        label3A.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        label3A.setPreferredSize(new Dimension(130, 25));
        label3A.setForeground(new Color(62, 73, 101));
        label3A.setFont(new Font("Sans", Font.BOLD, 20));
        JPanel textPanel = new JPanel();
        textPanel.add(label3A);
        textPanel.setBorder(new EmptyBorder(12, 0, 0, 0));

        label3B.setText("El Maestrogyuyiooioirequureuiiuiqer");
        label3B.setVisible(true);
        label3B.setForeground(Color.gray);
        label3B.setPreferredSize(new Dimension(130, 40));
        label3B.setFont(new Font("Sans", Font.CENTER_BASELINE, 13));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(Box.createHorizontalStrut(25));
        textPanel.add(label3B);
        textPanel.setPreferredSize(new Dimension(250, 90));
        textPanel.setBackground(Color.WHITE);
        textPanel.setOpaque(true);
        panel3.add(textPanel);
        //panel 3y

        panel3.setVisible(true);
        panel3.setBackground(Color.BLACK);
        panel3.setBounds(16, 130, 450, 350);
        panel3.setOpaque(false);
        panel3.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel3.setLayout(new FlowLayout(FlowLayout.LEADING,10,0));
        // panel 4
        JPanel panel4 = new JPanel();
        JLabel MessageDate = new JLabel();
        MessageDate.setText("03 March");
        MessageDate.setFont(new Font("Sans", Font.PLAIN, 14));
        panel4.setBackground(Color.WHITE);
        panel4.setOpaque(true);

        //panel4
        panel4.add(MessageDate);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        CirclePanel circlePanel = new CirclePanel();
        JLabel circleLabel = new JLabel();
        circleLabel.setText("7");
        circleLabel.setForeground(Color.white);
        circleLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        circlePanel.add(circleLabel, BorderLayout.CENTER);
        circlePanel.setBackground(Color.WHITE);
        circlePanel.setOpaque(true);
        circlePanel.setVisible(true);
        panel4.add(Box.createVerticalStrut(17));
        panel4.add(circlePanel);
        panel4.setPreferredSize(new Dimension(75, 85));
        panel3.add(panel4);

    }

    public JPanel getPanel3() {
        return panel3;
    }

    public class CirclePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new Color(212,29,17));
            g2.setBackground(new Color(212,29,17));
            g2.fillOval(20,0,30,30);
        }
    }
}
