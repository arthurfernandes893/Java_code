import java.io.*;
import java.util.*;

public class MinhaListaOrdenavel{
    //criar arraylist de pessoaimc pois eh a superclasse comum aos dois//
    ArrayList<PessoaIMC> pessoas = new ArrayList<>();
    public MinhaListaOrdenavel(){}

    //metod add e get necessarios por conta do polimorfismo//

    public void add(PessoaIMC p){
        pessoas.add(p);
    }

    public PessoaIMC get(int index){
        return pessoas.get(index);
    }
    //metodo que cria a pessoa//
 
    //definicao dos sorts usando lambda expressions, por isso o metodo comparing//
    public ArrayList<PessoaIMC> compara(int chave){
        switch (chave) {
            case 1:
                Collections.sort(pessoas, Comparator.comparing(PessoaIMC::getnome));        
                return pessoas;
                break;
            case 2:
                Collections.sort(pessoas, Comparator.comparing(PessoaIMC::getnome).reversed());
                return pessoas;
                break;
            
            case 3:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getPeso));        
                return pessoas;
                break;
            case 4:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getPeso).reversed());
                return pessoas;
                break;
            case 5:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::getAltura));        
                return pessoas;
                break;
            case 6:
                Collections.sort(pessoas,generoc);
                return pessoas;
                break;   
            case 7:
                Collections.sort(pessoas,Comparator.comparing(PessoaIMC::resultIMC));
                break;
            default:
                return pessoas;
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

}
    
