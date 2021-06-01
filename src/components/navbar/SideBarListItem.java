package components.navbar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SideBarListItem extends JPanel{

    public SideBarListItem(String imagePath, String name) throws IOException {
        JLabel label = new JLabel();
        label.setText(name);
        label.setForeground(Color.decode("#011638"));
        label.setSize(15, 35);

        System.out.println(System.getProperty("user.dir") + "/src/components/navbar/" + imagePath);
        BufferedImage myPicture = ImageIO.read(new File(System.getProperty("user.dir") + "/chat_swing_client/src/components/navbar/" + imagePath));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        picLabel.setBorder(new EmptyBorder(0, 0, 0, 23));
        add(picLabel);
        setBackground( Color.white);
        add(label);
    }
}
