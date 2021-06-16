package components.recentchats;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecentChats {
    public JPanel getRecentChats() throws IOException {
        JPanel panel1 = new JPanel();
        JTextField field2 = new JTextField("Search");
        JButton SearchButton = new JButton();
        JPanel mainpanel = new JPanel();
        JLabel label1 = new JLabel("Chat");
//   MainPanel
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        mainpanel.setBackground(new java.awt.Color(245, 249, 255));


        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        panel1.setBackground(new java.awt.Color(245, 249, 255));
        panel1.setOpaque(false);
        panel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 10, 200), new EmptyBorder(0, 0, 0, 0)));
//        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBounds(0, 5, 20, 1);
        panel1.add(label1);

        //Search Image Icon
        BufferedImage wPic = ImageIO.read(this.getClass().getResource("Images/search.png"));
        ImageIcon imageIcon = new ImageIcon(wPic);
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
//        SearchButton
        SearchButton.setIcon(imageIcon);
        SearchButton.setPreferredSize(new Dimension(22, 22));
        SearchButton.setBackground(new Color(0, 0, 0, 0));
        SearchButton.setBorderPainted(false);
        SearchButton.setFocusPainted(false);
        SearchButton.setBorder(null);
// JTextfield2
        field2.setMargin(new Insets(0, 0, 0, 6));
        field2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        field2.setPreferredSize(new Dimension(230, 90));
        field2.setOpaque(false);

        JPanel panel2 = new JPanel();
        panel2.setBackground(null);
        panel2.setBorder(BorderFactory.createEmptyBorder(0,0,40,0));
        JPanel panel3 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(22, 25);
                int width = 420;
                int height = 50;
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Draws the rounded opaque panel with borders.

                graphics.setColor(Color.white);
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.WHITE);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
            }
        };
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.setPreferredSize(new Dimension(450,50));
        panel3.add(SearchButton);
        panel3.add(field2);
        panel3.setBackground(null);
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 0,0,0));
        panel2.add(panel3);

        JPanel recentChatPanel = new JPanel();
        RecentChatsPanel recentChat = new RecentChatsPanel();
        RecentChatsPanel recentChat1 = new RecentChatsPanel();
        RecentChatsPanel recentChat2 = new RecentChatsPanel();
        RecentChatsPanel recentChat3 = new RecentChatsPanel();
        RecentChatsPanel recentChat4 = new RecentChatsPanel();
        RecentChatsPanel recentChat5 = new RecentChatsPanel();
        RecentChatsPanel recentChat6 = new RecentChatsPanel();
        //mainpanel add panels
        mainpanel.add(panel1);
        mainpanel.add(panel2);

        recentChatPanel.add(recentChat.getPanel3());
        recentChatPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        recentChatPanel.add(recentChat1.getPanel3());
        recentChatPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        recentChatPanel.add(recentChat2.getPanel3());
        recentChatPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        recentChatPanel.add(recentChat3.getPanel3());
        recentChatPanel.add(recentChat6.getPanel3());
        recentChatPanel.setLayout(new BoxLayout(recentChatPanel, BoxLayout.Y_AXIS));
        recentChatPanel.setBorder(new EmptyBorder(0, 50, 0, 0));
        recentChatPanel.setBackground(new java.awt.Color(245, 249, 255));
        mainpanel.add(recentChatPanel);
        return  mainpanel;
    }

}
