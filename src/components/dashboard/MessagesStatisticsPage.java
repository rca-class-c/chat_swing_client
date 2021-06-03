package components.dashboard;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class MessagesStatisticsPage extends JFrame{


    public MessagesStatisticsPage() throws IOException {
        setTitle("Message Statistics");
        setSize(1200, 700);
        setMinimumSize(new Dimension(800,600));
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initUI(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(229, 229, 229));
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(new Color(229, 229, 229));
        JPanel chartPanel = new JPanel();
        chartPanel.setBackground(new Color(229, 229, 229));

        BoxLayout tableLayout = new BoxLayout(tablePanel, BoxLayout.Y_AXIS);
        tablePanel.setLayout(tableLayout);

        BoxLayout chartLayout = new BoxLayout(chartPanel, BoxLayout.Y_AXIS);
        chartPanel.setLayout(chartLayout);

        this.addTable(tablePanel);
        this.addChart(chartPanel);


        mainPanel.add(this.header(), BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.WEST);
        mainPanel.add(chartPanel, BorderLayout.EAST);
        this.add(mainPanel);
    }

    public void addTable(JPanel panel){
        String[][] data = {
                { "2021-01-23", "4031"},
                { "2021-01-24", "6014" },
                { "2021-01-25", "4031"},
                { "2021-01-26", "6014" }
        };

        String[] columnNames = { "Date", "Messages" };

        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(sp);

        sp.setBackground(new Color(229, 229, 229));
        tablePanel.setBackground(new Color(229, 229, 229));
        panel.add(tablePanel);
    }
    private CategoryDataset createDataset() {

        var dataset = new DefaultCategoryDataset();
        dataset.setValue(46, "Gold medals", "USA");
        dataset.setValue(38, "Gold medals", "China");
        dataset.setValue(29, "Gold medals", "UK");
        dataset.setValue(22, "Gold medals", "Russia");
        dataset.setValue(13, "Gold medals", "South Korea");
        dataset.setValue(11, "Gold medals", "Germany");

        return dataset;
    }
    public void addChart(JPanel panel){
        BarchartComponent chart = new BarchartComponent("Message Sent across the system",this.createDataset(),"Number of messages");
        panel.add(chart);
    }

    public JPanel header(){
        JPanel header = new JPanel(new BorderLayout());
        JLabel headerText = new JLabel("Messages");
        headerText.setBorder(new EmptyBorder(10,10,10,10));

        String[] options = {"2021", "2020", "2019"};

        JPanel selectPanel = new JPanel();
        Select select = new Select(options);
        selectPanel.setSize(300,50);
        selectPanel.add(select.createSelect());
        selectPanel.setBackground(new Color(229, 229, 229));
        selectPanel.setBorder(new EmptyBorder(10,10,10,10));


        header.add(headerText, BorderLayout.WEST);
        header.add(selectPanel, BorderLayout.CENTER);
        header.setBackground(new Color(229, 229, 229));
        return header;
    }

    public static void main(String[] args) throws IOException {
        new MessagesStatisticsPage();



    }
}
