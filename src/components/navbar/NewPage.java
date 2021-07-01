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
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
    JLabel form = new JLabel("Welcome");
    panel1.setFont(new Font("Montserrat", Font.BOLD, 28));
    form.setBounds(30,30,500,10);
    panel1.add(form);
    try{
        JLabel check = new JLabel("Welcome to Official classC chat system with you lovely Java!");
        panel2.setBounds(30,40,500,10);
        check.setFont(new Font("Montserrat", Font.PLAIN, 18));
        panel2.add(check);
        System.out.println(this);

        this.add(panel1);
        this.add(panel2);



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
