import java.util.Hashtable;
public class Biblioteca {
    Hashtable<Integer,Usuario> usuarios_tb;
    Hashtable<Integer,Livro> livros_tb;

    //CONSTRUTORES//
    public Biblioteca(){
        this.usuarios_tb = new Hashtable<Integer,Usuario>(100);
        this.livros_tb = new Hashtable<Integer,Livro>(200);
    }

    //metodos//
    public void cadastraUsuario(Usuario user){}
    public void cadastraLivro(Livro book){}
    public void salvaArquivo(Hashtable<Integer,Usuario> tb,String file){}
    public void salvaArquivo(Hashtable<Integer,Livro> tb,String file){}
    public void leArquivo(String file){}


}
