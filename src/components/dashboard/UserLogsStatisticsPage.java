package components.dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import socket.IndexSocket;
import utils.CommonUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UserLogsStatisticsPage extends JFrame{

   private enum Days {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    }
    public UserLogsStatisticsPage() throws IOException {
        setTitle("Message Statistics");
        setSize(1200, 700);
        setMinimumSize(new Dimension(800,600));
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initUI() throws JsonProcessingException {
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
    public  List<List> data() throws JsonProcessingException {
        String key= "stats/messages/daily";

        Request request = new Request(null, key);
        //get all group in the system
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        if (response.isSuccess()){
            List<List> reports = new Reports().returnreport(response.getData());
            return  reports;
        }

        return  null;

    }
   public  String[][] getdata() throws JsonProcessingException {
       if (this.data() != null) {


           String[][] report;
           report = new String[this.data().get(0).size()][2];
           List<List> reports = this.data();
               if (reports.get(0).size() != 0) {
                   for (int i = 0; i < reports.get(0).size(); i++) {
                       report[i][0] = reports.get(0).get(i).toString().replace("message", "");
                       report[i][1] = reports.get(1).get(i).toString();
                   }
               } else {
                   System.out.println("Request failed in this group");
               }

           return report;
       }

       return null;

   }
    public void addTable(JPanel panel) throws JsonProcessingException {
        //this.getdata();
        String[][] data = this.getdata();

        String[] columnNames = { "Date", "Messages" };

        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(sp);

        sp.setBackground(new Color(229, 229, 229));
        tablePanel.setBackground(new Color(229, 229, 229));
        panel.add(tablePanel);
    }
    private CategoryDataset createDataset() throws JsonProcessingException {

        var dataset = new DefaultCategoryDataset();
        List<List> report = this.data();
        for (int i = 0;report.get(0).size()>i;i++){
            dataset.setValue(Double.parseDouble(this.data().get(1).get(i).toString()), "users", Days.values()[i]);
        }
//        dataset.setValue(46, "user", "Monday");
//        dataset.setValue(38, "user", "Tuesday");
//        dataset.setValue(29, "user", "Wednesday");
//        dataset.setValue(22, "user", "Thursday");
//        dataset.setValue(13, "user", "Friday");
//        dataset.setValue(11, "user", "Saturday");
//        dataset.setValue(89, "user", "Sunday");

        return dataset;
    }
    public void addChart(JPanel panel) throws JsonProcessingException {
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
        new UserLogsStatisticsPage();



    }
}
