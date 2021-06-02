package components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
    private int radius;

    public  Home() {
        super("Class C");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void initUI() {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        JLabel edit = new JLabel("EDIT GROUP");
        edit.setFont(new Font("Verdana", Font.BOLD, 18));
        edit.setForeground(Color.decode("#0a0a52"));

        JLabel teams = new JLabel("JAVA TEAM");
        teams.setFont(new Font("Verdana", Font.BOLD, 18));
        teams.setForeground(Color.decode("#FFD700"));

        JButton newGroup = new JButton("New Group");
        newGroup.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        newGroup.setBackground(Color.decode("#0a0a52"));
        newGroup.setForeground(Color.white);
        newGroup.setPreferredSize(new Dimension(40,40));

        JButton upload = new JButton("UPLOAD PROFILE");
        upload.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        upload.setBackground(Color.decode("#0a0a52"));
        upload.setForeground(Color.white);

        JTextField name= new JTextField("name");
        name.setColumns(30);
        name.setForeground(Color.gray.brighter());
        name.setBorder(new design.InputBorder(15));
        name.setColumns(40);
        JTextField desc= new JTextField("Description");
        JButton save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,40));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());

        edit.setFont(new Font("Verdana", Font.PLAIN,15));
        save.setForeground(Color.decode("#FFFFFF"));
        save.setBackground(Color.decode("#0a0a52"));
        save.setFont(new Font("Verdana", Font.BOLD, 16));
        save.setBounds(10, 10, 120, 50);
        
        save.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));

        JPanel nameLabelPanel = new JPanel();
        nameLabelPanel.setBackground(Color.WHITE);
        nameLabelPanel.setLayout(new BorderLayout());
        nameLabelPanel.add(name, BorderLayout.SOUTH);

        JPanel descLabelPanel = new JPanel();
        descLabelPanel.setBackground(Color.WHITE);
        descLabelPanel.setLayout(new BorderLayout());
        descLabelPanel.add(desc, BorderLayout.SOUTH);
        desc.setBorder(new design.InputBorder(15));
        desc.setForeground(Color.lightGray);

        JPanel savePanel = new JPanel(new BorderLayout());
        savePanel.setBackground(Color.WHITE);
        savePanel.add(save, BorderLayout.WEST);

        rightPanel.add(edit);
        rightPanel.add(teams);
        rightPanel.add(upload);
        rightPanel.add(newGroup);
        rightPanel.add(nameLabelPanel);
        rightPanel.add(name);
        rightPanel.add(descLabelPanel);
        rightPanel.add(desc);
        rightPanel.add(savePanel);
        rightPanel.setLayout(new GridLayout(7,1,0,10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));


        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home();
            }
        });
    }
}
class CustomBorder extends  AbstractBorder {
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(12));
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }
}

class RoundedBorder implements Border{
    private int radius;
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}