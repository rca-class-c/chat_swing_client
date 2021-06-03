package components.dashboard;

import javax.swing.*;
import javax.swing.table.JTableHeader;
//import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableComponent extends JTable{

    TableComponent( String[][] data,String[] columnNames)
    {

       super(data, columnNames);


        this.setBounds(30, 40, 200, 300);
        this.setRowHeight(30);
        this.setSelectionBackground(Color.getHSBColor(244,100,5));
        this.setSelectionForeground(Color.black);
        this.setFocusable(false);
        this.setIntercellSpacing(new Dimension(0,0));
        this.setRowMargin(0);
        this.setShowVerticalLines(false);
        this.setAutoResizeMode(AUTO_RESIZE_LAST_COLUMN);



        this.setTableHeader(new JTableHeader(this.getColumnModel()) {
            @Override public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 30;

                return d;
            }
        });
        this.getTableHeader().setBackground(Color.white);
        this.getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));


//        this.setBackground(new Color(245,249,255));
        this.setShowGrid(false);
        this.setShowHorizontalLines(true);


    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }

}