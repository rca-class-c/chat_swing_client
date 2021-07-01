package components.sidebar.sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.border.EmptyBorder;

public class People implements Scrollable{
    private JLabel notFound;
    final int x_axis = 10;
    final int width=200;
    final int height=55;
    private int y_axis = 11;
    private int b_axis = 246;
    public People() {}


    final JPanel GenerateUserPanel(String name, String image) {
        JPanel userpanel = new JPanel();
        userpanel.setBounds(x_axis, y_axis, width, height);
        y_axis = y_axis+(height+2);
        b_axis = y_axis+2;
        System.out.println(b_axis);

        userpanel.setLayout(null);
        userpanel.setBackground(new Color(240, 248, 255));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(240, 248, 255));
        panel_3.setBounds(10, 11, 50, 41);
        userpanel.add(panel_3);

        JLabel lblNewLabel = new JLabel("");
        ImageIcon image9Icon = new ImageIcon(image); // load the image to a imageIcon
        Image image9 = image9Icon.getImage(); // transform it
        Image newimg9 = image9.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image9Icon = new ImageIcon(newimg9);
        lblNewLabel.setIcon(image9Icon);
        panel_3.add(lblNewLabel);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(240, 248, 255));
        panel_4.setBounds(69, 11, 150, 41);
        userpanel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel(name);
        panel_4.add(lblNewLabel_1);

        return userpanel;

    }

    public JButton button() {
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(new Color(240, 248, 255));
        btnNewButton.setForeground(new Color(240, 248, 255));
        btnNewButton.setBorder(new EmptyBorder(5, 5, 5, 5));

        System.out.println("Here "+b_axis);
        return btnNewButton;
    }
    @SuppressWarnings("unused")
    public JPanel findusers(List<String> users,String user) {
        JPanel foundusers = new JPanel();
        foundusers.setBackground(new Color(240, 248, 255));
        foundusers.setBorder(new EmptyBorder(5, 5, 5, 5));
        foundusers.setLayout(null);

        int i;
        for(i = 0; i<users.size();i++) {
            if(users.get(i).toLowerCase().contains(user.toLowerCase()) ) {
                System.out.println("we found : "+users.get(i)+" "+i);
                foundusers.add(GenerateUserPanel(users.get(i), "C:\\\\Users\\\\DELL\\\\Desktop\\\\chat_swing_client\\\\src\\\\components\\\\sidebar\\\\imgs\\\\webgub.png"));
            }

        }
        if(foundusers==null) {
            notFound = new JLabel("Not found");
            System.out.println("Not found");
            foundusers.add(notFound);
            return foundusers;
        }else {
            return foundusers;
        }

    }
    public void resetY_axis() {
        this.y_axis = 11;
    }
    public final JPanel allUsers(List<String> users, JButton button) {
        JPanel allusers = new JPanel();
        allusers.setBackground(new Color(240, 248, 255));
        allusers.setBorder(new EmptyBorder(5, 5, 5, 5));
        allusers.setLayout(null);

        int i;
        for(i = 0; i<users.size();i++) {
            allusers.add(GenerateUserPanel(users.get(i), "C:\\\\Users\\\\DELL\\\\Desktop\\\\chat_swing_client\\\\src\\\\components\\\\sidebar\\\\imgs\\\\webgub.png"));
        }

        System.out.println(b_axis);
        button.setBounds(84, b_axis, 89, 23);
        allusers.add(button);
        return allusers;
    }
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean getScrollableTracksViewportWidth() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean getScrollableTracksViewportHeight() {
        // TODO Auto-generated method stub
        return false;
    }
//		public JButton button() {
//			// TODO Auto-generated method stub
//			return null;
//		}

}
