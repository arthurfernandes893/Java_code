import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario extends Pessoa{
    private String endereco;
    private int codigoUsuario;
    public ArrayList<Emprest> Hist;
    
    public Usuario(String nomelido,String sobrenomelido, GregorianCalendar datalida,String endereco, int codigo){
           super(nomelido, sobrenomelido, datalida);
           this.endereco = endereco;
           this.codigoUsuario = codigo;
           Hist = new ArrayList<Emprest>();
    }

    public String getendereco(){
        return endereco;
    }
    public int getcoduser(){
        return codigoUsuario;
    }

    public void addLivroHist(GregorianCalendar dataLoc, int codigoLivro){
        Emprest emprestimo = new Emprest(dataLoc,codigoLivro);
        Hist.add(emprestimo);
    }

}