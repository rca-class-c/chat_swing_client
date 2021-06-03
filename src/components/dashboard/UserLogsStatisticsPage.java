package components.dashboard;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class UserLogsStatisticsPage extends JFrame{


    public UserLogsStatisticsPage() throws IOException {
        setTitle("User logs report");
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

        BoxLayout tableLayout = new BoxLayout(tablePanel, BoxLayout.Y_AXIS);
        tablePanel.setLayout(tableLayout);


        this.addTable(tablePanel);


        mainPanel.add(this.header(), BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        this.add(mainPanel);
    }

    public void addTable(JPanel panel){
        String[][] data = {
                { "2021-01-23", "joined channel"},
                { "2021-01-24", "changed profile" },
                { "2021-01-25", "joined system"},
                { "2021-01-26", "deleted channel" },
                { "2021-01-26", "modified profile" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
                { "2021-01-26", "modified channel" },
        };

        String[] columnNames = { "Date", "activity" };

        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(sp);

        sp.setBackground(new Color(229, 229, 229));
        tablePanel.setBackground(new Color(229, 229, 229));
        panel.add(tablePanel);
    }

    public JPanel header(){
        JPanel header = new JPanel(new BorderLayout());
        JLabel headerText = new JLabel("User logs");
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
        new UserLogsStatisticsPage();



    }
}
