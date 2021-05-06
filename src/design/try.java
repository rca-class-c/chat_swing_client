/* package design;
import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
impo
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
    public  Home(){
        initUI();
    }
    private void initUI(){
        EditGroup();
        setTitle("Class C");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void EditGroup(){
        JPanel leftPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel chatLabel = new JLabel("Chat");
        JLabel teamLabel = new JLabel("Team");
        JLabel settingsLabel = new JLabel("Settings");

        leftPanel.setBackground(Color.LIGHT_GRAY);
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        BoxLayout leftPanelLayout = new BoxLayout(pan1, BoxLayout.Y_AXIS);

        pan1.setLayout(leftPanelLayout);
        chatLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        teamLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        settingsLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        pan1.add(chatLabel);
        pan1.add(teamLabel);
        pan1.add(settingsLabel);
        pan1.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
        pan1.setBackground(null);
        leftPanel.add(pan1);

        JLabel text2=new JLabel("Edit Group ");
        text2.setFont(new Font("Verdana", Font.BOLD, 18));
        text2.setForeground(Color.decode("#0a0a52"));
        JLabel text3 = new JLabel("Java Teams");
        text3.setFont(new Font("Verdana", Font.BOLD, 18));
        text3.setForeground(Color.decode("#FFD700"));

        BoxLayout centerPanelLayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
        centerPanel.setLayout(centerPanelLayout);

        JPanel headingPanel = new JPanel();
        headingPanel.add(text2);
        headingPanel.add(text3);
        centerPanel.add(headingPanel);


        JPanel pant = new JPanel();
        JPanel p1 = new JPanel();
        JButton newTeam= new JButton("NEW GROUP");
        centerPanel.add(pant);


        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200,0));

        this.setLayout(new BorderLayout());
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);


        newTeam.setFocusPainted(false);
        newTeam.setBackground(Color.decode("#0a0a52"));
        newTeam.setBorder(BorderFactory.createCompoundBorder(
                new customBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        newTeam.setForeground(Color.decode("#FFFFFF"));

        JButton upload = new JButton("Upload Profile");
        upload.setFocusPainted(false);
        upload.setBorder(BorderFactory.createCompoundBorder(
                new customBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))

        ));
        upload.setBackground(Color.decode("#0a0a52"));
        upload.setForeground(Color.decode("#FFFFFF"));

        JTextField name= new JTextField("name");


        name.setColumns(30);
        name.setForeground(Color.gray.brighter());
        name.setBorder(new InputBorder(15));

        JTextField desc = new JTextField("Description");

        desc.setPreferredSize(new Dimension(400,100));
        desc.setForeground(Color.gray.brighter());
                desc.setBorder((Border) new InputBorder(15));


        JButton save = new JButton("Save");save
        save.setFocusPainted(false);
        save.setBorder(BorderFactory.createCompoundBorder(
                new customBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))

        ));
        save.setBackground(Color.decode("#0a0a52"));
        save.setForeground(Color.decode("#FFFFFF"));

        p1.setSize(300,600);
        p1.setBackground(Color.decode("#FFFFFF"));
        p1.setVisible(true);
        p1.add(text2);
        p1.add(text3);
        p1.add(upload);
        p1.add(newTeam);
        p1.add(name);
        p1.add(desc);

        p1.add(save);


        JPanel p2 = new JPanel();
        p2.setSize(650, 600);
        p2.setBackground(Color.decode("#E5E5E5"));
        p2.setVisible(true);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(900, 600);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(150);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(p2);
        splitPane.setRightComponent(p1);
        this.add(splitPane);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new Home();
            ex.setVisible(true);
        });
    }
} */