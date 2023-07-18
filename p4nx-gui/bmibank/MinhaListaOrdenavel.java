package bmibank;

import java.io.*;
import java.util.*;

public class MinhaListaOrdenavel{
    //criar arraylist de pessoaimc pois eh a superclasse comum aos dois//
    public ArrayList<PessoaIMC> pessoas = new ArrayList<>();
    public MinhaListaOrdenavel(){}

    //metod add e get necessarios por conta do polimorfismo//
    public void add(PessoaIMC p){
        pessoas.add(p);
    }

    public PessoaIMC get(int index){
        return pessoas.get(index);
    }

    //definicao dos sorts usando lambda expressions, por isso o metodo comparing//
    public void compara(int chave){
        switch (chave) {
            case 1:
                Collections.sort(pessoas, Comparator.comparing(PessoaIMC::getnome));        
                //return pessoas;
                break;
            case 2:
                Collections.sort(pessoas, Comparator.comparing(PessoaIMC::getnome).reversed());
                //return pessoas;
                break;
            
            case 3:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getPeso));        
                //return pessoas;
                break;
            case 4:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getPeso).reversed());
                //return pessoas;
                break;
            case 5:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getAltura));        
                //return pessoas;
                break;
            case 6:
                Collections.sort(pessoas,generoc);
                //return pessoas;
                break;   
            case 7:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::resultIMC));
                break;
            default:
                //return pessoas;
                break;
        }
    }

    /*sort de genero definido usando um comparator a parte  
    e sobrescrevendo o metodo compare de generoc 
    para operar com os generos*/
    public Comparator generoc = new Comparator() {
        public int compare(Object a, Object b){
            //comparar baseado no instaceof e retornar -1,0,1//
            if(((a instanceof Homem) && (b instanceof Homem)) || 
               ((a instanceof Mulher) && (b instanceof Mulher))){ //sao iguais//
                return 0;
            }
            else{
                if((a instanceof Homem) && (b instanceof Mulher)){ 
                    return 1;
                }
                else{ 
                    return -1;
                }
            }
        }
    };

    //metodo pra criar o preset//
    public void cirapreset(int i){
        String[] nomes = {"ana","claudio","maria","tereza","fernando","jose","antonio","alex","claudio","tereza"};
        String[] sobrenomes = {"fernandes","menezes","cruz","cardoso","luiz","cruz","batista","teixeira","jose","lucia"};
        int[] ano ={1995,2005,2003,1994,2007,1989,1984,2000,2004,2001};
        int[] mes ={1,2,3,4,5,6,7,8,9,10};
        int[] dia ={1,2,3,4,5,6,7,8,9,10};
        double[] peso = {67.6,55.6,49.8,78.6,88.6,56.4,77.5,65.9,90.3,100.35};
        double[] altura = {1.56,1.71,1.89,1.90,1.56,1.78,2.01,1.74,1.57,1.90};
        int[] genero = {1,2,1,1,2,2,2,2,2,1}; //1-feminino,2-masculino//
        if(genero[i] == 1){
            GregorianCalendar data = new GregorianCalendar(ano[i],mes[i], dia[i]);
            PessoaIMC wm = new Mulher(nomes[i], sobrenomes[i],data, peso[i], altura[i]);
            add(wm);
        }
        else{
            GregorianCalendar data = new GregorianCalendar(ano[i],mes[i], dia[i]);
            PessoaIMC wm = new Homem(nomes[i], sobrenomes[i],data, peso[i], altura[i]);
            add(wm);
        }
    } 
    public static String listaPessoas(ArrayList<PessoaIMC> pessoas){
        Homem h; Mulher m;
        String listagem ="";
        for(PessoaIMC a : pessoas){
            if(a instanceof Homem){
                h = (Homem) a;
                
                listagem +=h+"\n";
            }
            else{
                m = (Mulher) a;
                listagem+=m+"\n";
            }
        }
        System.out.println("ordenação feita com sucesso");
        return listagem;
    }
    public ArrayList<PessoaIMC> getpessoas(){
        return pessoas;
    }
}   
