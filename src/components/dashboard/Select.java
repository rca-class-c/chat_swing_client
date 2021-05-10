package components.dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Select {

    public JPanel createSelect(){

        // The labels for the bar chart
        String[] options = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        JComboBox select = new JComboBox(options);

        // create labels
        JLabel l = new JLabel("select your city ");
        JLabel l1 = new JLabel("Jalpaiguri selected");

        // set color of text
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);

        // create a new panel
        JPanel p = new JPanel();

        p.add(l);

        // add combobox to panel
        p.add(select);

        p.add(l1);

        return p;
    }

    public static void main(String[] args) {
        //Instantiate an instance of this demo module
        Select demo = new Select();

        //Create and set up the main window
        JFrame frame = new JFrame(demo.toString());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);} });
        frame.getContentPane().setBackground(Color.white);

        // Create the chart and put them in the content pane

        frame.getContentPane().add(demo.createSelect());

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }
}
