import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import p3nX.lp2g06.biblioteca.EmprestPara;

public class Livro implements Serializable{
    private String codigoLivro;
    private String titulo;
    private String categoria;
    private int quant;
    private int emprestados;
    private ArrayList<EmprestPara> Hist = new ArrayList<EmprestPara>(); 
    
    //no momento do emprestimo, emprestados eh zero e quant eh definido//
    public Livro(String codigoLivro, String titulo, String categoria, int quant){
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quant = quant;
        this.emprestados = 0;
    }

    public void empresta()throws CopiaNaoDisponivelEx{
        if(emprestados == quant){
            throw new CopiaNaoDisponivelEx();
        }
        else{
            emprestados+=1;
        }
    }
    public void devolve()throws  NenhumaCopiaEmprestadaEx{
        if(emprestados == quant){
            throw new  NenhumaCopiaEmprestadaEx();
        }
        else{
            quant+=1;
        }
    }

    public void addUsuarioHist(String codigoUsuario, GregorianCalendar dataEmprest,GregorianCalendar dataDevolv){
        EmprestPara emprestado = new EmprestPara(codigoUsuario,dataEmprest,dataDevolv);
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
}
