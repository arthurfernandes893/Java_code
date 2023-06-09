import java.util.ArrayList;

public class MinhaListaOrdenavel {
    //criar arraylist de pessoaimc pois eh a superclasse comum aos dois//
    ArrayList<PessoaIMC> pessoas = new ArrayList<>();
    public MinhaListaOrdenavel(){}

    //metod add e get necessarios por conta do polimorfismo//
    public void add(Homem p){
        PessoaIMC m = (PessoaIMC) p;
        pessoas.add(m);
    }
    public void add(Mulher p){
        PessoaIMC m = (PessoaIMC) p;
        pessoas.add(m);
    }

    public Homem getHomem(int i){
        if(pessoas.get(i) instanceof Homem){
            Homem m = (Homem) pessoas.get(i);
            return m;
        }   
    }
    public Mulher GetMulher(int i){
        if(pessoas.get(i) instanceof Mulher){
            Mulher m = (Mulher) pessoas.get(i);
            return m;
        }
    }

    //ordenacao//
}
