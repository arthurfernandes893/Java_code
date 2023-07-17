import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class MLOGui{
    public static void main(String[] args){
        MinhaListaOrdenavel array = new MinhaListaOrdenavel();
        for(int i = 0;i<10;i++){
            array.cirapreset(i);
        }

        JFrame tela = new JFrame();
        JPanel frame = new JPanel();

        JButton b1 = new JButton("ALFABETICA(A-Z)");
        JButton b2 = new JButton("ALFABETICA(Z-A)");
        JButton b3 = new JButton("MENOR PESO");
        JButton b4 = new JButton("MAIOR PESO");
        JButton b5 = new JButton("ALTURA");
        JButton b6 = new JButton("GENERO");
        JButton b7 = new JButton("IMC");

        b1.setActionCommand("1");
        b2.setActionCommand("2");
        b3.setActionCommand("3");
        b4.setActionCommand("4");
        b5.setActionCommand("5");
        b6.setActionCommand("6");
        b7.setActionCommand("7");
        /* 
        b1.addActionListener(bp);
        b2.addActionListener(bp);
        b3.addActionListener(bp);
        b4.addActionListener(bp);
        b5.addActionListener(bp);
        b6.addActionListener(bp);
        b7.addActionListener(bp);
        */
        
        tela.add(frame);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        
        frame.setVisible(true);
       
        JPanel lista = new JPanel();

    }

        //mudar lista pessoas //

        
}
