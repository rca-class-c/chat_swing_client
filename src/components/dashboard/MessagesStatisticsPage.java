package components.dashboard;

import components.Forms.form.LoginForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MessagesStatisticsPage extends JFrame{


    public MessagesStatisticsPage() throws IOException {
        setTitle("Message Statistics");
        setSize(900, 700);
        setMinimumSize(new Dimension(800,600));
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initUI(){
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel tablePanel = new JPanel();
        JPanel chartPanel = new JPanel();

        BoxLayout tableLayout = new BoxLayout(tablePanel, BoxLayout.Y_AXIS);
        tablePanel.setLayout(tableLayout);

        BoxLayout chartLayout = new BoxLayout(chartPanel, BoxLayout.Y_AXIS);
        chartPanel.setLayout(chartLayout);

        this.addTable(tablePanel);



        mainPanel.add(tablePanel);
        mainPanel.add(chartPanel);
        this.add(mainPanel);
    }

    public void addTable(JPanel panel){
        String[][] data = {
                { "2021-01-23", "4031"},
                { "2021-01-24", "6014" },
                { "2021-01-25", "4031"},
                { "2021-01-26", "6014" }
        };

        String[] columnNames = { "date", "messages" };

        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(sp);

        panel.add(tablePanel);
    }

    public static void main(String[] args) throws IOException {
        new MessagesStatisticsPage();



    }
}
