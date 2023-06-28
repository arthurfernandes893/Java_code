import java.util.*;
public class Pessoa{
    //declaracao de campos
    private String nome;
    private String sobrenome;
    private GregorianCalendar dataNasc; 
    
    //construtor para caso ideal com todas as infos passadas
    public Pessoa(String nomelido,String sobrenomelido, GregorianCalendar datalida){
        nome = nomelido;
        sobrenome = sobrenomelido;
        dataNasc = datalida;
       
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
    
    //metodo toString//
    public String toString(){
        return "nome:"+ nome +" || sobrenome: "+sobrenome+" || nascimento:"+dataNasc.get(Calendar.DATE) +"/"+
        dataNasc.get(Calendar.MONTH)+"/"+dataNasc.get(Calendar.YEAR);
    }
    
    }
