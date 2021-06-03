package components.add_group_member;

import models.*;
import socket.IndexSocket;
import utils.CommonUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddGroupMembers extends JFrame {
    private TableModel model;
    private JTable table;
    private TableRowSorter sorter;
    private JScrollPane jsp;
    private ArrayList<User> groupMembers;

    public AddGroupMembers() throws IOException {
        //calling request from the server

        boolean haveMembers=true;
        String key= "groups/members";
        Request request = new Request(new ProfileRequestData(1),key);
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        if(response.isSuccess()){
            User[] users = new UserResponseDataDecoder().returnUsersListDecoded(response.getData());
            CommonUtil.addTabs(10, true);
            if (users.length != 0){

                for (User user : users) {
                    System.out.println(user.getUserID()+". "+user.getFname()+" "+user.getLname());
                    CommonUtil.addTabs(10, false);
//                    groupMembers.add(user);
                }
            }else{
                System.out.println("No user found in this group");
                haveMembers=false;
            }
        }else {
            System.out.println("failed to fetch users in the given group");
        }


        JFrame frame = new JFrame();
        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(2,3));
        upPanel.setBackground(Color.white);
        upPanel.setBorder(new EmptyBorder(25, 25, 0, 25));
        JLabel label = new JLabel("<html><p>Add members in a team</p></html>");
        label.setFont (label.getFont ().deriveFont (19f));
        label.setForeground(Color.decode("#011638"));
        label.setBorder(BorderFactory.createEmptyBorder(0,0,20, 0));
        label.add(Box.createHorizontalStrut(700));

        final PlaceholderTextField searchField = new PlaceholderTextField("");
//        searchField.setColumns(20);
        searchField.setBackground(Color.decode("#F3F6F9"));
        searchField.setPlaceholder("Search for a user");
        searchField.setBounds(0,100,300,45);
        searchField.setBorder(BorderFactory.createCompoundBorder(
                searchField.getBorder(),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        searchField.setMargin(new Insets(10, 15, 10, 15));
        final Font f = searchField.getFont();
        upPanel.add(label);
        upPanel.add(searchField);


        JPanel midPanel = new JPanel();
        midPanel.setBackground(Color.white);




        frame.getContentPane().add(midPanel, BorderLayout.CENTER);
        midPanel.setLayout(new BorderLayout(0, 0));
        midPanel.setBorder(new EmptyBorder(25, 25, 0, 25));
        String[] columnNames = {"Name", "Action"};
        Object[][] rowData = {{"Uwikoreye dada","Add" },{"Umudjama didi","Add"},{"Kalisa diane","Add"},{"Umudjama didi","Add"},{"Kalisa diane","Add"},{"Majyane benji","Add"},{"Majyane benji","Add"},{"Jai kamari","Add"}};

        model = new DefaultTableModel(rowData, columnNames);
        sorter = new TableRowSorter<>(model);
        table = new JTable(model);
        table.setRowHeight(60);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setShowGrid(false);
        table.setRowSorter(sorter);
        table.setDefaultEditor(Object.class, null);


//        setLayout(new FlowLayout(FlowLayout.CENTER));

//        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

        table.setTableHeader(null);
        jsp = new JScrollPane(table);
        jsp.setBorder(null);


        JScrollBar sb=jsp.getVerticalScrollBar();
        sb.setPreferredSize(new Dimension(5, Integer.MAX_VALUE));
        sb.setUI(new MyScrollbarUI());

        midPanel.add(jsp);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchField.getText());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchField.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchField.getText());
            }
            public void search(String str) {
                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });


        JPanel downPanel = new JPanel();
        downPanel.setBackground(Color.white);
        downPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        JButton done = new JButton("Done");

        frame.getContentPane().add(downPanel, BorderLayout.SOUTH);
        downPanel.setLayout(new BorderLayout(0, 0));
        downPanel.add(done);

        frame.getContentPane().add(upPanel, BorderLayout.NORTH);
        frame.setBounds(100, 100, 515, 630);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    class ButtonEditor extends DefaultCellEditor
    {
        protected JButton btn;
        private String lbl;
        private Boolean clicked;

        public ButtonEditor(JTextField txt) {
            super(txt);

            btn=new JButton();
            btn.setOpaque(true);

            //WHEN BUTTON IS CLICKED
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    fireEditingStopped();
                }
            });
        }

        //OVERRIDE A COUPLE OF METHODS
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                                                     boolean selected, int row, int col) {

            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
            lbl=(obj==null) ? "":obj.toString();
            btn.setText(lbl);
            clicked=true;
            return btn;
        }

        //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
        @Override
        public Object getCellEditorValue() {

            if(clicked)
            {
                //SHOW US SOME MESSAGE


                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            JTable target = (JTable)e.getSource();
                            int row = target.getSelectedRow();
                            int column = target.getSelectedColumn();
                            Object ob = table.getModel().getValueAt(row, 0);
                            System.out.println("Value = "+ob);
                            JOptionPane.showMessageDialog(btn, " user added");
                        }
                    }
                });
            }
            //SET IT TO FALSE NOW THAT ITS CLICKED
            clicked=false;
            return new String(lbl);
        }

        @Override
        public boolean stopCellEditing() {

            //SET CLICKED TO FALSE FIRST
            clicked=false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            // TODO Auto-generated method stub
            super.fireEditingStopped();
        }
    }

    public static void main(String[] args) throws IOException {
        new AddGroupMembers();
    }
}

class MyScrollbarUI extends BasicScrollBarUI {
    private Image imageThumb, imageTrack;
    MyScrollbarUI() {
        try {
            imageThumb = ImageIO.read(new File("C:\\Users\\DELL\\Documents\\GitHub\\chat_swing_client\\src\\assets\\Rectangle_1.png"));
            imageTrack = ImageIO.read(new File("C:\\Users\\DELL\\Documents\\GitHub\\chat_swing_client\\src\\assets\\Rectangle.png"));
        } catch (IOException e){}
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor( Color.red );
        g.drawRect( 0, 0, thumbBounds.width - 2, thumbBounds.height - 1 );
        AffineTransform transform = AffineTransform.getScaleInstance((double)thumbBounds.width/imageThumb.getWidth(null),(double)thumbBounds.height/imageThumb.getHeight(null));
        ((Graphics2D)g).drawImage(imageThumb, transform, null);
        g.translate( -thumbBounds.x, -thumbBounds.y );
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.translate(trackBounds.x, trackBounds.y);
        ((Graphics2D)g).drawImage(imageTrack,AffineTransform.getScaleInstance(1,(double)trackBounds.height/imageTrack.getHeight(null)),null);
        g.translate( -trackBounds.x, -trackBounds.y );
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton jbutton = new JButton();
        jbutton.setPreferredSize(new Dimension(0, 0));
        jbutton.setMinimumSize(new Dimension(0, 0));
        jbutton.setMaximumSize(new Dimension(0, 0));
        return jbutton;
    }

}

//BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements  TableCellRenderer
{

    //CONSTRUCTOR
    public ButtonRenderer() {
        //SET BUTTON PROPERTIES
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {

        //SET PASSED OBJECT AS BUTTON TEXT
        setText((obj==null) ? "":obj.toString());

        return this;
    }

}
