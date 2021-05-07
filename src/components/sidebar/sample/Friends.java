package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Friends {
    private JFrame mainWindow;
    private JLabel tit;
    private JTextField searchBar;
    public  Friends(){
        mainUnit();
    }
    public JPanel member(String names,String imgpath){
        ImageIcon userImage = new ImageIcon(imgpath);
        Image icon = userImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel user= new JLabel();
        user.setText(names);
        user.setIcon(new ImageIcon(icon));

        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.decode("#cccccc"));
        userPanel.add(user);
        return userPanel;
    }
    public void mainUnit(){
        mainWindow= new JFrame("Demo");
        mainWindow.setSize(500,500);
        searchBar = new JTextField("Search");

        searchBar.setEditable(true);
        tit = new JLabel("Friends");
        JPanel addUserPanel = new JPanel();
        addUserPanel.setPreferredSize(new Dimension(150,100));
        addUserPanel.setBackground(Color.WHITE);
        addUserPanel.setLayout(new BoxLayout(addUserPanel,BoxLayout.Y_AXIS));
        addUserPanel.setBounds(100,80,400,400);
        addUserPanel.setAutoscrolls(true);

        addUserPanel.add(searchBar);
        addUserPanel.add(tit);
        addUserPanel.add(member("Cyrus  ","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\cyrus.png"));
        addUserPanel.add(member("Babin Curly","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\Babins.png"));
        addUserPanel.add(member("Curly","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\curl.png"));
        addUserPanel.add(member("Keza Kami","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\kami.png"));
        addUserPanel.add(member("Ruby","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\ruby.png"));
        addUserPanel.add(member("Webgub","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\webgub.png"));
        addUserPanel.add(member("Kalisa","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\kalisa.png"));
        addUserPanel.add(member("Webgub","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\webgub.png"));
        addUserPanel.add(member("Kalisa","C:\\Users\\DELL\\Desktop\\chat\\src\\imgs\\kalisa.png"));


//        JScrollPane scrollableTextArea = new JScrollPane(textArea);
//
//        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        JScrollPane scrollablePanel = new JScrollPane(addUserPanel);
//        scrollablePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
        class MyAdjustmentListener implements AdjustmentListener {
            public void adjustmentValueChanged(AdjustmentEvent e) {
//                label.setText("Slider's position is " + e.getValue());
                mainWindow.repaint();
            }
        }

        vbar.addAdjustmentListener(new MyAdjustmentListener( ));
        mainWindow.getContentPane().add(vbar, BorderLayout.SOUTH);
        Container container = new Container();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container = mainWindow.getContentPane();
//        container.add(scrollablePanel,BorderLayout.EAST;
        mainWindow.add(addUserPanel,BorderLayout.EAST);

        mainWindow.setVisible(true);
    }

    public static void main(String[] args) {
        new Friends();
    }
}
