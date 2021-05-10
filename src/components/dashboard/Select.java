package components.dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Select {
    String[] options;

    Select(String[] options){
        this.options = options;
    }

    public JComboBox createSelect(){



        JComboBox select = new JComboBox(this.options);



        return select;
    }

    public static void main(String[] args) {
        // The labels for the bar chart
        String[] options = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        //Instantiate an instance of this demo module
        Select demo = new Select(options);


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
