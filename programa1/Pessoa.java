import java.util.*;

public class Pessoa{
    //declaracao de campos
    private String nome;
    private String sobrenome;
    private GregorianCalendar dataNasc; 
    private String numCPF;
    private long intCPF;
    
    public float peso;
    public float altura;
    
    //construtor para caso ideal com todas as infos passadas
    public Pessoa(String nomelido,String sobrenomelido,String numcpflido, GregorianCalendar datalida, float pesolido, float alturalida){
        nome = nomelido;
        sobrenome = sobrenomelido;
        dataNasc = datalida;
        numCPF = numcpflido;
        peso = pesolido;
        altura = alturalida;
        intCPF = ValidaCPF.toIntCPF(numcpflido); //definicao do cpf inteiro usando o metodo da classe ValidaCPF//
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
    public String getnumCPF(){
        return numCPF;
    }
    public long getintCPF(){
        return intCPF;
    }

    //metodo toString//
    public String toString(){
        return "nome:"+ nome +" sobrenome:"+sobrenome+" nascimento:"+dataNasc.get(Calendar.DATE) +"/"+
        dataNasc.get(Calendar.MONTH)+"/"+dataNasc.get(Calendar.YEAR)+" cpf:"+ numCPF;
    }
    
    }
