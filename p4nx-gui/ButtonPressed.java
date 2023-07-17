import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ButtonPressed implements ActionListener{
    MinhaListaOrdenavel array;

    public ButtonPressed(MinhaListaOrdenavel person){
        array = person;
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("1")){
            array.compara(Integer.parseInt(e.getActionCommand()));

        }
        if(e.getActionCommand().equals("2")){
            array.compara(Integer.parseInt(e.getActionCommand()));
        }
        if(e.getActionCommand().equals("3")){
           array.compara(Integer.parseInt(e.getActionCommand()));
        }
        if(e.getActionCommand().equals("4")){
           array.compara(Integer.parseInt(e.getActionCommand()));
        }
        if(e.getActionCommand().equals("5")){
           array.compara(Integer.parseInt(e.getActionCommand()));
        }
        if(e.getActionCommand().equals("6")){
           array.compara(Integer.parseInt(e.getActionCommand()));
        }
        if(e.getActionCommand().equals("7")){
            array.compara(Integer.parseInt(e.getActionCommand()));
        }
    }

    
 
}
