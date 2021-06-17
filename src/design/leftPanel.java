package design;
import java.awt.*;
import javax.swing.*;


public class leftPanel extends JFrame {
    private int radius;

    public  leftPanel() {
        super("Left panel");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void initUI() {
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel= new JPanel();

        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,120, 10, 120));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10,100, 10, 100));
       
        leftPanel.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#F5F9FF"));
        middlePanel.setBackground(Color.decode("#F5F9FF"));
        rightPanel.setBackground(Color.blue);

        add(leftPanel,BorderLayout.WEST);
        add(middlePanel,BorderLayout.CENTER);
        add(rightPanel,BorderLayout.EAST);


    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new leftPanel();
            }
        });
    }
}


