package bmibank;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MLOGui{
        public MinhaListaOrdenavel array;
        public ButtonPressed bp;
        public MLOGui(MinhaListaOrdenavel pessoas){
            this.array = pessoas;
            
            JTextArea lista = new JTextArea(8, 80);
            JPanel lista_container = new JPanel();
            
            JFrame tela = new JFrame();
            JPanel frame = new JPanel();
            
            
            JScrollPane scrollPane = new JScrollPane(lista);
            
            JPanel intro = new JPanel();
        
            bp = new ButtonPressed(pessoas,lista);

            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
            
            b1.addActionListener(bp);
            b2.addActionListener(bp);
            b3.addActionListener(bp);
            b4.addActionListener(bp);
            b5.addActionListener(bp);
            b6.addActionListener(bp);
            b7.addActionListener(bp);
         

            lista.setToolTipText("LISTAGEM DE PESSOAS COM IMC");
            lista.setLineWrap(true);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
            lista_container.setBackground(new Color(89, 248, 232));
            frame.setBackground(new Color(19,246,224));
            lista.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT , 14));
            lista.setMargin(new Insets(15, 25, 15, 0));
            lista.setEditable(false);
            
            tela.setTitle("LISTA ORDENAVEL DE IMCs");

            intro.add(new JLabel("BEM VINDO A BASE DE DADOS DOS IMCs. selecione a opcao que deseja para ordenar as informações")).setBackground(new Color(196, 253, 247));
            FormGui form = new FormGui(pessoas);

            lista_container.add(lista);
            frame.add(b1);
            frame.add(b2);
            frame.add(b3);
            frame.add(b4);
            frame.add(b5);
            frame.add(b6);
            frame.add(b7);
            frame.add(lista_container);
            frame.add(form);
            frame.add(intro);
            

            tela.add(frame);
            frame.setVisible(true);
            tela.setVisible(true);

        }
        
}
