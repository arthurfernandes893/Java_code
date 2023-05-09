import java.util.GregorianCalendar;

public class Pessoa{
    //declaracao de campos
    private String nome;
    private String sobrenome;
    private GregorianCalendar dataNasc; 
    private String numCPF;

    public float peso;
    public float altura;
    
    //construtor para caso ideal com todas as infos passadas
    public Pessoa(String nomelido,String sobrenomelido, GregorianCalendar datalida,String numcpflido, float pesolido, float alturalida){
        nome = nomelido;
        sobrenome = sobrenomelido;
        dataNasc = datalida;
        numCPF = numcpflido;
        peso = pesolido;
        altura = alturalida;
    }
    
    //metodos getter para informacoes sensiveis
    public String getnome(){
        return nome;
    }
    public String getsobrenome(){
        return sobrenome;
    }
    public GregorianCalendar getdataNasc(){
        return dataNasc;
    }
    public int getnumCPF(){
        return numCPF;
    }
    
    //metodo toString//
    public String toString(){
        return "nome:"+ nome +"\nsobrenome:"+sobrenome+"\nnascimento:"+dataNasc+"\ncpf:"+ numCPF;
    }
    
    }
