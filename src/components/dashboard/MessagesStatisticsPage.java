//package components.dashboard;
//
//import ChartDirector.ChartViewer;
//import components.Forms.form.LoginForm;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.Color;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.awt.*;
//import java.io.IOException;
//
//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//
//public class MessagesStatisticsPage extends JFrame{
//
//
//    public MessagesStatisticsPage() throws IOException {
//        setTitle("Message Statistics");
//        setSize(1200, 700);
//        setMinimumSize(new Dimension(800,600));
//        initUI();
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//
//    }
//
//    public void initUI(){
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBackground(new Color(245,249,255));
//        JPanel tablePanel = new JPanel();
//        tablePanel.setBackground(new Color(245,249,255));
//        JPanel chartPanel = new JPanel();
//        chartPanel.setBackground(new Color(245,249,255));
//
//        BoxLayout tableLayout = new BoxLayout(tablePanel, BoxLayout.Y_AXIS);
//        tablePanel.setLayout(tableLayout);
//
//        BoxLayout chartLayout = new BoxLayout(chartPanel, BoxLayout.Y_AXIS);
//        chartPanel.setLayout(chartLayout);
//
//        this.addTable(tablePanel);
//        this.addChart(chartPanel);
//
//
//        mainPanel.add(this.header(), BorderLayout.NORTH);
//        mainPanel.add(tablePanel, BorderLayout.WEST);
//        mainPanel.add(chartPanel, BorderLayout.EAST);
//        this.add(mainPanel);
//    }
//
//    public void addTable(JPanel panel){
//        String[][] data = {
//                { "2021-01-23", "4031"},
//                { "2021-01-24", "6014" },
//                { "2021-01-25", "4031"},
//                { "2021-01-26", "6014" }
//        };
//
//        String[] columnNames = { "Date", "Messages" };
//
//        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));
//
//        JPanel tablePanel = new JPanel(new BorderLayout());
//        tablePanel.add(sp);
//
//        sp.setBackground(new Color(245,249,255));
//        tablePanel.setBackground(new Color(245,249,255));
//        panel.add(tablePanel);
//    }
//
//    public void addChart(JPanel panel){
//        BarchartComponent chart = new BarchartComponent("Message Sent across the system",null,"Number of messages");
//        ChartViewer viewer = new ChartViewer();
//        chart.createChart(viewer, 0);
//
//
//        panel.add(viewer);
//    }
//
//    public JPanel header(){
//        JPanel header = new JPanel(new BorderLayout());
//        JLabel headerText = new JLabel("Messages");
//        headerText.setBorder(new EmptyBorder(10,10,10,10));
//
//        String[] options = {"2021", "2020", "2019"};
//
//        JPanel selectPanel = new JPanel();
//        Select select = new Select(options);
//        selectPanel.setSize(300,50);
//        selectPanel.add(select.createSelect());
//        selectPanel.setBackground(new Color(245,249,255));
//        selectPanel.setBorder(new EmptyBorder(10,10,10,10));
//
//
//        header.add(headerText, BorderLayout.WEST);
//        header.add(selectPanel, BorderLayout.CENTER);
//        header.setBackground(new Color(245,249,255));
//        return header;
//    }
//
//    public static void main(String[] args) throws IOException {
//        new MessagesStatisticsPage();
//
//
//
//    }
//}
