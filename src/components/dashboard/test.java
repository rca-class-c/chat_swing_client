package components.dashboard;

import javax.swing.*;

public class test {

    public static void main(String[] args) {
        String[][] data = {
                { "2021-01-23", "4031"},
                { "2021-01-24", "6014" },
                { "2021-01-25", "4031"},
                { "2021-01-26", "6014" }
        };

        String[] columnNames = { "date", "messages" };
        JFrame f = new JFrame();
        f.setTitle("JTable Example");
        JScrollPane sp = new JScrollPane(new TableComponent(data,columnNames));
        f.add(sp);
        f.setSize(300, 700);
        f.setVisible(true);
    }
}
