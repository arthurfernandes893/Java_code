package lp2g06.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;



public class Livro implements Serializable{
    private String codigoLivro;
    private String titulo;
    private String categoria;
    private int quant;
    private int emprestados;
    private ArrayList<EmprestPara> Hist; 
    
    //no momento do emprestimo, emprestados eh zero e quant eh definido//
    public Livro(String codigoLivro, String titulo, String categoria, int quant){
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quant = quant;
        this.emprestados = 0;
        this.Hist = new ArrayList<EmprestPara>();
    }

    public void empresta()throws CopiaNaoDisponivelEx{
        if(quant ==0){
            throw new CopiaNaoDisponivelEx(emprestados,quant);
        }
        else{
            emprestados+=1;
            quant-=1;
        }
    }
    public void devolve()throws  NenhumaCopiaEmprestadaEx{
        if(emprestados == 0){
            throw new  NenhumaCopiaEmprestadaEx(emprestados,quant);
        }
        else{
            quant+=1;
            emprestados-=1;
        }
    }

    public void addUsuarioHist(String codigoUsuario, GregorianCalendar dataEmprest){
        EmprestPara emprestado = new EmprestPara(codigoUsuario,dataEmprest);
        Hist.add(emprestado);
    }

    public String gettitulo(){
        return titulo;
    }
    public ArrayList<EmprestPara> gethist(){
        return Hist;
    }
    public String getcodlivro(){
        return codigoLivro;
    }

    public void imprimehist(){
        ArrayList<EmprestPara>hist = Hist;
        for(EmprestPara em : hist){
            System.out.println(em);
        }
    }
    public String toString(){
        return titulo+" | "+ categoria +" | "+quant+" | "+emprestados+"\n";
    }
    }
