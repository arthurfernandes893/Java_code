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

    //METODO PRA VER SE É + METODOS PRA FAZER O POLIMORFISMO//
    //GET COM INDEX//
    public void get(int index){
        Homem men;
        Mulher wm;        
        if(pessoas.get(index) instanceof Homem){
            men = (Homem) pessoas.get(index);
            System.out.println(men);
        }
        else{
            wm = (Mulher) pessoas.get(index);
            System.out.println(wm);
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
