import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TeamsCreated extends JFrame
{

    TeamsCreated()
    {
        super("Teams Created");
        setSize(810, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        JLabel label_l1,label_l2;
        label_l1=new JLabel("Teams Created");
        label_l1.setBounds(20,20, 200,10);
        label_l2=new JLabel("you have joined 5 groups");
        label_l2.setBounds(20,20, 200,50);
        add(label_l1);
        add(label_l2);
        setLayout(null);
        setVisible(true);

        // the table

        table = new JTable();
        Object[] columns ={"Teams","Members", "Creator", "Description", ""};
        DefaultTableModel model = new DefaultTableMOdel();

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);

    }
    public static void main(String[] args)
    {
        new TeamsCreated();
    }
}