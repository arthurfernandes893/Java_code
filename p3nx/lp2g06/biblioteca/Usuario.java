package lp2g06.biblioteca;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario extends Pessoa{
    private String endereco;
    private String codigoUsuario;
    private ArrayList<Emprest> Hist;
    
    public Usuario(String nomelido,String sobrenomelido, GregorianCalendar datalida,String endereco, String codigo){
           super(nomelido, sobrenomelido, datalida);
           this.endereco = endereco;
           this.codigoUsuario = codigo;
           Hist = new ArrayList<Emprest>();
    }

    public String getendereco(){
        return endereco;
    }
    public String getcoduser(){
        return codigoUsuario;
    }

    public void addLivroHist(GregorianCalendar dataLoc, String codigoLivro){
        Emprest emprestimo = new Emprest(dataLoc,codigoLivro);
        Hist.add(emprestimo);
    }

    public ArrayList<Emprest> gethist(){return Hist;}


    public void imprimehist(){
        ArrayList<Emprest>hist = Hist;
        for(Emprest em : hist){
            System.out.println(em);
        }
    }

    public String toString(){
        return codigoUsuario + " || " + super.toString() + " || " + endereco;
    }
}