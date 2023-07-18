package bmibank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
public class FormGui extends JPanel implements ActionListener{
    public JFrame formulario;
    public JPanel form;
    public JPanel nome;
    public JPanel sobrenome;
    public JPanel data;
    public JPanel peso;
    public JPanel altura;
    public JPanel genero;
    public JTextField nomefield;
    public JTextField sobrenomefield;
    public JTextField pesofield;
    public JTextField alturafield;
    public JComboBox diaselector;
    public JComboBox messelector;
    public JComboBox anoselector;
    public JComboBox generoselector;
    
    MinhaListaOrdenavel array;
    public FormGui(MinhaListaOrdenavel array){
        this.array = array; 

        setSize(500, 700);

        formulario = new JFrame("Cadastro");
        form = new JPanel(); //orientar na vertical
        
        nome = new JPanel();
        nome.add(new JLabel("nome:"));
        nomefield = new JTextField("", 5); 
        nome.add(nomefield);
        form.add(nome);
        
        sobrenome = new JPanel();
        sobrenome.add(new JLabel("sobrenome:"));
        sobrenomefield = new JTextField("",5);
        sobrenome.add(sobrenomefield);
        form.add(sobrenome);
        
        data = new JPanel();
        
        JLabel dia = new JLabel("dia");
        String[] dias = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        diaselector = new JComboBox(dias);
        data.add(dia);
        data.add(diaselector);

        JLabel mes = new JLabel("mes");
        String[] meses = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        messelector = new JComboBox(meses);
        data.add(dia);
        data.add(messelector);

        JLabel ano = new JLabel("ano");
        String[] anos = { "1990","1991","1992","1993", "1994","1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" };
        anoselector = new JComboBox(anos);
        data.add(ano);
        data.add(anoselector);

        form.add(data);

        peso = new JPanel();
        peso.add(new JLabel("Peso:"));
        peso.add(new JTextField("0", 3));
        form.add(peso);

        altura = new JPanel();
        altura.add(new JLabel("altura:"));
        altura.add(new JTextField("0", 3));
        form.add(altura);

        genero = new JPanel();
        String[] generos = {"marculino","feminino"};
        generoselector = new JComboBox(generos);
        genero.add(generoselector);
        form.add(genero);

        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(this);
        formulario.add(form);

        form.setVisible(true);
        formulario.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String nome,sobrenome,genero;
        float peso,altura;
        int dia,mes,ano;
        
        nome = this.nomefield.getText()+"";
        sobrenome = this.sobrenomefield.getText()+"";
        dia = Integer.parseInt((String) diaselector.getSelectedItem());
        mes = Integer.parseInt((String) messelector.getSelectedItem());
        ano = Integer.parseInt((String) anoselector.getSelectedItem());
        peso = Float.parseFloat((String) pesofield.getText()+"");
        altura = Float.parseFloat((String) alturafield.getText()+"");

        if(((String) generoselector.getSelectedItem()).equals("masculino")){
            Homem h = new Homem(nome, sobrenome, new GregorianCalendar(ano,mes,dia), peso, altura);
            array.add((PessoaIMC) h);
        }
        else{
            Mulher w = new Mulher(nome, sobrenome, new GregorianCalendar(ano,mes,dia), peso, altura);
            array.add((PessoaIMC) w);
        }

    
    }
}
