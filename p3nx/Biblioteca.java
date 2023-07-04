import java.io.*;
import java.util.*;
public class Biblioteca {
    Hashtable<String,Usuario> usuarios_tb;
    Hashtable<String,Livro> livros_tb;

    //CONSTRUTORES//
    public Biblioteca(){
        this.usuarios_tb = new Hashtable<String,Usuario>(100);
        this.livros_tb = new Hashtable<String,Livro>(200);
    }
    public Biblioteca(String nome1, String nome2) throws ClassNotFoundException,IOException,FileNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome1));
        ObjectInputStream inb = new ObjectInputStream(new FileInputStream(nome2)); 
        Object aux = in.readObject();
        Object aux2 = inb.readObject();
        
        this.usuarios_tb =  (Hashtable<String,Usuario>) aux;
        
        this.livros_tb =  (Hashtable<String,Livro>) aux2;
        in.close();
        inb.close();
        
    }

 
    //metodos//
    public void cadastraUsuario(Usuario user){
        usuarios_tb.put(user.getcoduser(), user);
    }

    public void cadastraLivro(Livro book){
        livros_tb.put(book.getcodlivro(), book);
    }

     public void salvaUsuario(Hashtable<String,Usuario> tb,String file) throws IOException,NullPointerException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)); 
        out.writeObject(tb);
        out.flush();
        out.close();
        //adicionar try catch no metodo de cima//
    }
    public void salvaLivro(Hashtable<String,Livro> tb,String file) throws IOException,NullPointerException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)); 
        out.writeObject(tb);
        out.flush();
        out.close();
        //adicionar try catch no metodo de cima//
    }

    public void leArquivo(String file_name) throws ClassNotFoundException,IOException,FileNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file_name)); 
        Object aux = in.readObject();
        if(aux instanceof Hashtable<String,Usuario>){
            this.usuarios_tb =  (Hashtable<String,Usuario>) aux;
        }
        else{
            this.livros_tb =  (Hashtable<String,Livro>) aux;
        }
       
    }

    public void emprestaLivro(Usuario user,Livro book){
        book.empresta();
        user.addLivroHist(new GregorianCalendar(), book.codigoLivro);
    }
    
    public void devolveLivro(Usuario user, Livro book) { //throws DevolucaoAtrasadaEx//
        try{book.devolve();}
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
        }
        GregorianCalendar devolucao = new GregorianCalendar();
        
        /* varrer os arraylists procurando por um par de valores iguais com codigo de ususario
         * e de livro. 
         * As datas de devolução devem estar, tambem, vazias
         */
        for (Emprest e : user.gethist()) {
            for(EmprestPara p : book.gethist()){
                if(user.getcoduser() == p.getcoduser()){
                    if(e.dataEmprest.compareTo(p.dataEmprest) == 0){
                        if((e.dataDevolv.compareTo(p.dataDevolv) == 0) && e.dataDevolv.equals(null)){
                            e.dataDevolv = devolucao;
                            p.dataDevolv = devolucao;
                            //adicionar multa//
                        }
                    }
                }
            }
        }
    }

    //metodos de impressao das listas de livros e de usuarios//
    public String imprimeLivros(Hashtable<String,Livro> livrostb){
        //Collections.sort(livrostb, Comparator.comparing(Livro::gettitulo));
        String livros ="";
        for (String cod : livrostb.keySet()) {
            Livro book = livrostb.get(cod);
            livros+=book.toString();
        }
        return livros;
    }

      public String imprimeUsuarios(Hashtable<String,Usuario> usuariostb){
        //Collections.sort(livrostb, Comparator.comparing(Livro::gettitulo));
        String users ="";
        for (String cod : usuariostb.keySet()) {
            Usuario usuario = usuariostb.get(cod);
            users+=usuario.toString();
        }
        return users;
    }
   
    //metodos get livro e get usuario jogando excecoes caso nao achem//
    public Usuario getuser(String cod) throws UsuarioNaoCadastradoEx{
        Usuario u;
        try{u = (Usuario) usuarios_tb.get(cod);}
        catch(NullPointerException ex){
            throw new UsuarioNaoCadastradoEx(cod);
        }
        return u;
    }

    public Livro getbook(String cod)throws LivroNaocadastradoEx{
        Livro b;
        try{b = (Livro) livros_tb.get(cod);}
        catch(NullPointerException ex){
            throw new LivroNaocadastradoEx(cod);
        }
        return b;
    }
}
