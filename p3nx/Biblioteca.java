import java.io.*;
import java.util.*;
import lp2g06.biblioteca.*;
public class Biblioteca {
    Hashtable<String,Usuario> usuarios_tb;
    Hashtable<String,Livro> livros_tb;
    private String user_tb_file;
    private String book_tb_file;

    //CONSTRUTORES//
    public Biblioteca(){
        this.usuarios_tb = new Hashtable<String,Usuario>(100);
        this.livros_tb = new Hashtable<String,Livro>(200);
        this.user_tb_file = "firstversion_users_tb.dat";
        this.book_tb_file = "firstversion_books_tb.dat";
    }
    public Biblioteca(String nome1, String nome2) throws IOException{
        try{    
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome1));
            ObjectInputStream inb = new ObjectInputStream(new FileInputStream(nome2)); 
            Object aux = in.readObject();
            Object aux2 = inb.readObject();
            this.usuarios_tb =  (Hashtable<String,Usuario>) aux;
            this.livros_tb =  (Hashtable<String,Livro>) aux2;
            in.close();
            inb.close();
        }
        catch(ClassNotFoundException ex){
            System.out.print(ex);
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        
    }
    
    //metodos de cadastro//
    public void cadastraUsuario(Usuario user){
        usuarios_tb.put(user.getcoduser(), user);
    }

    public void cadastraLivro(Livro book){
        livros_tb.put(book.getcodlivro(), book);
    }

    //metodos de salvamento//
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

    //conjunto modularizado de métodos para ler as bases de dados//
    public void leArquivo(String file_name, int escolha) throws IOException, FileNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file_name));

        if(escolha ==1){
            try{
                leUser(file_name, in);
            }
            catch(TabelaNaoEncontradaEx ex){
                System.out.println(ex);
                in.close();
            }
            in.close();
        }
        else{
            if(escolha ==2){
            try{
                leLivro(file_name, in);
            }
            catch(TabelaNaoEncontradaEx ex){
                System.out.println(ex);
                in.close();
            }
            in.close();
            }
        }
        
    }
    public void leUser(String file_name, ObjectInputStream in)throws TabelaNaoEncontradaEx{
      //  ObjectInputStream in = new ObjectInputStream(new FileInputStream(file_name));  
        try{
            this.usuarios_tb = (Hashtable<String,Usuario>) in.readObject();
        }
        catch(ClassNotFoundException ex){
            throw new TabelaNaoEncontradaEx(file_name);
        }
        catch(IOException ex){
            throw new TabelaNaoEncontradaEx(file_name);
        }
       
    }
     public void leLivro(String file_name, ObjectInputStream in)throws TabelaNaoEncontradaEx{  
        try{
            this.livros_tb = (Hashtable<String,Livro>) in.readObject();
        }
        catch(ClassNotFoundException ex){
            throw new TabelaNaoEncontradaEx(file_name);
        }
        catch(IOException ex){
            throw new TabelaNaoEncontradaEx(file_name);
        }
       
    }

    //metodos de emprestimo e devolucao//
    public void emprestaLivro(Usuario user,Livro book){
        try{book.empresta();}
        catch(CopiaNaoDisponivelEx ex){
           // BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(ex);
        }
        user.addLivroHist(new GregorianCalendar(), book.getcodlivro());
    }
    
    public void devolveLivro(Usuario user, Livro book) {
        try{book.devolve();}
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
        }
        GregorianCalendar devolucao = new GregorianCalendar();
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

    /*metodos de impressao utilizando a 
     * tecnica do TREEMAP que permite 
     * ordenacao */
    public String imprimeLivros(Hashtable<String,Livro> livrostb){
        //definicao dos comparators usando a mesma estrategia do P2nX
        Comparator<Livro> bookcomparator = Comparator.comparing(Livro::gettitulo);
       
        //definicao dos treemaps//
        TreeMap<String,Livro> sortedbooks = new TreeMap(bookcomparator);
        
        //alocacao no treemap//
        sortedbooks.putAll(livrostb);
        
      String livros ="";
        for (Map.Entry<String,Livro> book : sortedbooks.entrySet()) {
            livros+=book.toString()+"\n";
        }
        return livros;
    }

    public String imprimeUsuarios() throws UsuarioNaoCadastradoEx{
        String users = "";
        Hashtable<String,Usuario> usuarios = this.usuarios_tb;
        for(String key : this.usuarios_tb.keySet()){
         users += getuser(key).toString()+"\n";
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

    //metodos auxiliares//
    public Livro getbook(String cod)throws LivroNaoCadastradoEx{
        Livro b;
        try{b = (Livro) livros_tb.get(cod);}
        catch(NullPointerException ex){
            throw new LivroNaoCadastradoEx(cod);
        }
        return b;
    }
    public String getbookfilename(){
        return book_tb_file;
    }
    public String getuserfilename(){
        return user_tb_file;
    }
    public void setuserfilename() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        System.out.println("Entre com o novo nome do arquivo de usuarios:");
        while(aux.equals("")){
            System.out.println("Entre com o novo nome do arquivo usuarios:");
            aux = inData.readLine();
        }
        user_tb_file = aux;
    }
    public void setbooksfilename() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        System.out.println("Entre com o novo nome do arquivo de livros:");
        while(aux.equals("")){
            System.out.println("Entre com o novo nome do arquivo de livros:");
            aux = inData.readLine();
        }
        book_tb_file = aux;
    }

    public static Usuario criauser() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
                System.out.println("NOME: ");            
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String nome = aux;

            try{
                System.out.println("SOBRENOME:");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String sobrenome = aux;
            
            try{
                System.out.println("NASCIMENTO:");
                aux = inData.readLine();
                if(aux.equals("") || !(ValidaData.checkString(aux)) || aux.length()<8){
                    throw new DataErradaException(aux.length(),false);
                }
            }
            catch(DataErradaException ex){
                System.out.println(ex);
                GregorianCalendar data = ex.criadatacerta(aux);
            }
            GregorianCalendar data = ValidaData.criadata1(aux);

            try{
                System.out.println("ENDERECO");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String endereco = aux;
            
            try{
                System.out.println("CODIGO DO USUARIO:");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);

            }
            String codigo = aux;
            
            return new Usuario(nome, sobrenome, data, endereco, codigo);
    }
    public String getcode() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
                System.out.println("CODIGO:");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(NomeErradoException ex){
                System.out.println(ex);
                ex.ledireito(aux);
                return aux;

            }
            catch(IOException ex){
                
            }
           
        return aux;
    }
    public static Livro crialivro() throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
                System.out.println("TITULO:");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new LivroCadastroEx(aux);
                }
                }
                catch(LivroCadastroEx ex){
                    System.out.println(ex);
                    ex.ledireito(aux);

                }
                String titulo = aux;

                try{
                System.out.println("CATEGORIA");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new LivroCadastroEx(aux);
                }
                }
                catch(LivroCadastroEx ex){
                    System.out.println(ex);
                    ex.ledireito(aux);

                }
                String categoria = aux;

                try{
                System.out.println("CODIGO DO LIVRO");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new LivroCadastroEx(aux);
                }
                }
                catch(LivroCadastroEx ex){
                    System.out.println(ex);
                    ex.ledireito(aux);

                }
                String codigo = aux;

                try{
                System.out.println("QUANTIDADE");
                aux = inData.readLine();
                if(aux.equals("") || !((aux.trim()).matches("\\d+"))){
                    throw new LivroCadastroEx(aux);
                }
                }
                catch(LivroCadastroEx ex){
                    System.out.println(ex);
                    ex.ledireito(aux);

                }
                int quant = Integer.parseInt(aux);
            return new Livro(codigo, titulo, categoria, quant);
    }


}
