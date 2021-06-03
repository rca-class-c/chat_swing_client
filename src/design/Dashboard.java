package design;
import components.Teams.create.CreatePanel;
import components.Teams.view.Layout;
import components.dashboard.MessagesStatisticsPage;
import  components.Teams.TeamsCreated;
import components.dashboard.UserLogsStatisticsPage;
import components.navbar.GenerateFrame;
import design.CustomBorder;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;



public class Dashboard extends JFrame {
    private JFrame frame;

    private int radius;

    public Dashboard() {
        super("Dashboard");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void initUI() {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        // messages icon
        ImageIcon icon = new ImageIcon("src\\images\\msg.png");
        Image image = icon.getImage();
        Image newer = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newer);

        //teams icon
        ImageIcon teaming = new ImageIcon("src\\images\\hashtag.png");
        Image imageTeam = teaming.getImage();
        Image newTeam = imageTeam.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH);
        teaming= new ImageIcon(newTeam);

        //users icons
        ImageIcon users = new ImageIcon("src\\images\\users.png");
        Image imageUser= users.getImage();
        Image newUser= imageUser.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH);
        users= new ImageIcon(newUser);

        //user logs icon
        ImageIcon userLogs = new ImageIcon("src\\images\\bars.jpg");
        Image imageLogs= userLogs.getImage();
        Image newLog= imageLogs.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH);
        userLogs= new ImageIcon(newLog);


        JButton msg = new JButton("<html><font color='black'>Messages</font></html>");
        msg.setActionCommand("messages");
        msg.setBorder(BorderFactory.createCompoundBorder(
                (Border) new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        msg.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        msg.setIcon(icon);
        msg.setBackground(Color.decode("#FFFFFF"));
        msg.setForeground(Color.decode("#F5F9FF"));

        JButton Team = new JButton("<html><font color='black'>Teams</font></html>");
        Team.setActionCommand("Teams");
        Team.setBorder(BorderFactory.createCompoundBorder(
                (Border) new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        Team.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Team.setIcon(teaming);
        Team.setBackground(Color.decode("#FFFFFF"));
        Team.setForeground(Color.decode("#F5F9FF"));
        Team.setPreferredSize(new Dimension(120, 60));

        JButton user = new JButton("<html><font color='black'>Users</font></html>");
        user.setActionCommand("Users");
        user.setBorder(BorderFactory.createCompoundBorder(
                (Border) new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        user.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        user.setIcon(users);
        user.setBackground(Color.decode("#FFFFFF"));
        user.setForeground(Color.decode("#F5F9FF"));
        user.setPreferredSize(new Dimension(120, 60));

        JButton logs = new JButton("<html><font color='black'>User Logs</font></html>");
        logs.setActionCommand("User Logs");
        logs.addActionListener(e-> {
            try {
                actionListener(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        logs.setBorder(BorderFactory.createCompoundBorder(
                (Border) new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));

        logs.setIcon(userLogs);
        logs.setBackground(Color.decode("#FFFFFF"));
        logs.setForeground(Color.decode("#F5F9FF"));
        logs.setPreferredSize(new Dimension(140, 60));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#F5F9FF"));

        panel.add(msg);
        panel.add(Team);
        panel.add(user);
        panel.add(logs);

        rightPanel.add(panel);
        rightPanel.setBackground(Color.decode("#F5F9FF"));
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.CENTER);

    }

    private void actionListener(ActionEvent actionEvent) throws IOException {

        JLabel label = new JLabel("navigation");

        String command = actionEvent.getActionCommand();
        System.out.println("Command  "+command);

        switch (command) {
            case "messages" -> {
                System.out.println("messages action listener");
                dispose();
                new MessagesStatisticsPage();
            }
            case "Teams" -> {
                System.out.println("Team action listener");
                dispose();
                new TeamsCreated();

            }
            case "Users" -> {
                System.out.println("Users action listener");
                dispose();
                new GenerateFrame(new CreatePanel().returnPanel());
            }
            case "User Logs" -> {
                System.out.println("Logs action listener");
                dispose();
                new UserLogsStatisticsPage();
            }
            default -> System.out.println("Unknown");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard();
            }
        });
    }
}


