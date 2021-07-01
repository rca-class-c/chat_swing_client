package components.Teams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
public class TeamsCreated extends JFrame
{

    public TeamsCreated()
    {

        // the table

        JTable table = new JTable();
        Object[] columns ={"Teams","Members", "Creator", "Description", ""};
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);

    }
    public static void main(String[] args)
    {
        new TeamsCreated();
    }
}