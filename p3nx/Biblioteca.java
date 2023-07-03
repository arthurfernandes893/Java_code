
import java.util.*;
public class Biblioteca {
    Hashtable<String,Usuario> usuarios_tb;
    Hashtable<String,Livro> livros_tb;

    //CONSTRUTORES//
    public Biblioteca(){
        this.usuarios_tb = new Hashtable<String,Usuario>(100);
        this.livros_tb = new Hashtable<String,Livro>(200);
    }
    public Biblioteca(Hashtable<String,Usuario> usuarios_tb, Hashtable<String,Livro> livros_tb){ 
        this.usuarios_tb = usuarios_tb;
        this.livros_tb = livros_tb;
    }
    /* Dependendo da opção do usuario sera criada uma nova biblioteca ou acionada a ja existente
     * sendo esses parametros os resultados dos metodos que buscam na memoria, ou seja, os objetos retornados
    */

    //metodos//
    public void cadastraUsuario(Usuario user){
        usuarios_tb.put(user.getcoduser(), user);
    }
    public void cadastraLivro(Livro book){
        livros_tb.put(book.codigoLivro, book);
    }
    public void salvaUser(Hashtable<String,Usuario> tb,String file){}
    public void salvaLivro(Hashtable<String,Livro> tb,String file){}
    public void leArquivo(String file){}

    public void emprestaLivro(Usuario user,Livro book){
        book.empresta();
        user.addLivroHist(new GregorianCalendar(), book.codigoLivro);
    }
    public void devolveLivro(Usuario user, Livro book){
        try{book.devolve();}
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
            //resolver o problema!!!!!!!!!!!!//
        }
        GregorianCalendar devolucao = new GregorianCalendar();
        
    }
    public String imprimeLivros(Hashtable<String,Livro> livrostb){
        Collections.sort(livrostb, Comparator.comparing(Livro::gettitulo));
    }

    //metodos get livro e get usuario jogando exceos caso nao achem//
}
