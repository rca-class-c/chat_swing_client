package components.navbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class NewPage extends JPanel {
    private ActionEvent actionEvent;

    public NewPage(ActionEvent actionEvent) {

        this.actionEvent = actionEvent;
        perform();
    }
public void perform(){
    JLabel form = new JLabel("Checking");
    this.add(form);
    try{
        JLabel check = new JLabel("Checkingggggg");
        this.add(check);
        System.out.println(this);



    }catch (Exception exception){
        System.out.println(exception);
    }



    this.setBounds(240, 10, 1020, 750);
    this.setBackground(Color.WHITE);


}
    public  NewPage(){
        perform();
         }

}
