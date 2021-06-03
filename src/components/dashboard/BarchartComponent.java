//package components.dashboard;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import ChartDirector.*;
//
//public class BarchartComponent
//{
//    private String title;
//    private String XAxisLabel;
//    private String YAxisLabel;
//
//    public BarchartComponent(String title, String XAxisLabel, String YAxisLabel) {
//        this.title = title;
//        this.XAxisLabel = XAxisLabel;
//        this.YAxisLabel = YAxisLabel;
//    }
//
//    public BarchartComponent(String title) {
//        this.title = title;
//    }
//
//    public BarchartComponent() {
//        this.title = "Bar Chart";
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getXAxisLabel() {
//        return XAxisLabel;
//    }
//
//    public void setXAxisLabel(String XAxisLabel) {
//        this.XAxisLabel = XAxisLabel;
//    }
//
//    public String getYAxisLabel() {
//        return YAxisLabel;
//    }
//
//    public void setYAxisLabel(String YAxisLabel) {
//        this.YAxisLabel = YAxisLabel;
//    }
//
//    //    //Name of demo program
//    public String toString() { return "Multi-Color Bar Chart (1)"; }
//
//    //Number of charts produced in this demo
//    public int getNoOfCharts() { return 1; }
//
//    //Main code for creating charts
//    {
//        // The data for the bar chart
//        double[] data = {850, 1560, 1709, 2011, 1230, 1890, 1066};
//
//        // The labels for the bar chart
//        String[] labels = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//
//        // The colors for the bars
//        int[] colors = {0x3E4965,0x3E4965,0x3E4965,0x3E4965,0x3E4965,0x3E4965,0x3E4965,};
//
//        // Create a XYChart object of size 600 x 400 pixels
//        XYChart c = new XYChart(600, 400);
//
//        // Add a title box using grey (0x555555) 24pt Arial font
//        c.addTitle(title, "Arial", 18, 0x555555);
//
//        // Set the plotarea at (70, 60) and of size 500 x 300 pixels, with transparent background
//        // and border and light grey (0xcccccc) horizontal grid lines
//        c.setPlotArea(70, 60, 500, 300, Chart.Transparent, -1, Chart.Transparent, 0xcccccc);
//
//        // Set the x and y axis stems to transparent and the label font to 12pt Arial
//        c.xAxis().setColors(Chart.Transparent);
//        c.yAxis().setColors(Chart.Transparent);
//        c.xAxis().setLabelStyle("Arial", 12);
//        c.yAxis().setLabelStyle("Arial", 12);
//
//        // Add a multi-color bar chart layer with transparent border using the given data
//        c.addBarLayer3(data, colors).setBorderColor(Chart.Transparent);
//
//        // Set the labels on the x axis.
//        c.xAxis().setLabels(labels);
//
//        // For the automatic y-axis labels, set the minimum spacing to 40 pixels.
//        c.yAxis().setTickDensity(40);
//
//        // Add a title to the y axis using dark grey (0x555555) 14pt Arial font
//        c.yAxis().setTitle(YAxisLabel, "Arial", 14, 0x555555);
//
//        // Output the chart
//        viewer.setChart(c);
//
//        //include tool tip for the chart
//        viewer.setImageMap(c.getHTMLImageMap("clickable", "", "title='{xLabel}: ${value}M'"));
//    }
//
//    //Allow this module to run as standalone program for easy testing
//    public static void main(String[] args)
//    {
//        //Instantiate an instance of this demo module
//        BarchartComponent demo = new BarchartComponent();
//
//        //Create and set up the main window
//        JFrame frame = new JFrame(demo.toString());
//        frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {System.exit(0);} });
//        frame.getContentPane().setBackground(Color.white);
//
//        // Create the chart and put them in the content pane
//        ChartViewer viewer = new ChartViewer();
//        demo.createChart(viewer, 0);
//        frame.getContentPane().add(viewer);
//
//        // Display the window
//        frame.pack();
//        frame.setVisible(true);
//    }
//}
