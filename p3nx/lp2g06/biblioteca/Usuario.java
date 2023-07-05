import java.io.*;
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

    public static Usuario criauser() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String nome = aux;

            try{
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String sobrenome = aux;
            
            try{
                aux = inData.readLine();
                if(aux.equals("") || !(ValidaData.checkString(aux))){
                    throw new DataErradaException(aux.length(),false);
                }
            }
            catch(DataErradaException ex){
                System.out.println(ex);
                GregorianCalendar data = ex.criadatacerta(aux);
            }
            GregorianCalendar data = ValidaData.criadata1(aux);

            try{
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String endereco = aux;
            
            try{
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String codigo = aux;
            
            return new Usuario(nome, sobrenome, data, endereco, codigo);
    }
}