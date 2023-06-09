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
 /*TEMPLATE
 public Comparator pesoC = new Comparator () {
 public int compare (Object p1, Object p2){ // recebe objetos PessoaIMC como Object
 double pf1, pf2;
 pf2 = (PessoaIMC) p2.getPeso();
 pf1 = (PessoaIMC) p1.getPeso();
 return (int)Math.round (pf2 – pf1);
 }
};
 */
}
