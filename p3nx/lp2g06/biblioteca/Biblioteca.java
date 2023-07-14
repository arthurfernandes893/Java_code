package lp2g06.biblioteca;

import java.io.*;
import java.util.*;
import lp2g06.biblioteca.*;
public class Biblioteca {
    private Hashtable<String,Usuario> usuarios_tb;
    private Hashtable<String,Livro> livros_tb;
    private String user_tb_file;
    private String book_tb_file;

    //CONSTRUTORES//

    /*esse inicia as bases de dados de forma padronizada
    */
    public Biblioteca(){
        this.usuarios_tb = new Hashtable<String,Usuario>(100);
        this.livros_tb = new Hashtable<String,Livro>(200);
        this.user_tb_file = "firstversion_users_tb.dat";
        this.book_tb_file = "firstversion_books_tb.dat";
    }

    /*Qualquer erro na abertura vai jogar a excecao ErroNaAberturaEx 
     * que vai sinalizar o problema e no cliente oferecer a opcao
     * de iniciar com as bases de dados padrao ou de tentar novamente
     */
    public Biblioteca(String nome1, String nome2) throws ErroNaAberturaEx{
        try{    
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome1)); 
            Object aux = in.readObject();
            this.usuarios_tb =  (Hashtable<String,Usuario>) aux;
            this.user_tb_file = nome1;
            in.close();
        }
        catch(ClassNotFoundException ex){
            System.out.print(ex);
            throw new ErroNaAberturaEx();
        }
        catch(FileNotFoundException ex){
           System.out.println(nome1+" NAO FOI ENCONTRADO\n");
           throw new ErroNaAberturaEx();
        }
        catch(IOException ex){
            System.out.println(ex);
             throw new ErroNaAberturaEx();
        }

        try{    
            ObjectInputStream inb = new ObjectInputStream(new FileInputStream(nome2)); 
            Object aux2 = inb.readObject();
            this.livros_tb =  (Hashtable<String,Livro>) aux2;
            this.book_tb_file =nome2;
            inb.close();
        }
        catch(ClassNotFoundException ex){
            System.out.print(ex);
            throw new ErroNaAberturaEx();
        }
        catch(FileNotFoundException ex){
            System.out.println(nome2+" NAO FOI ENCONTRADO\n");
            throw new ErroNaAberturaEx();
        }
        catch(IOException ex){
            throw new ErroNaAberturaEx();
        }
        
    }
    
    //metodos de cadastro//
    public void cadastraUsuario(Usuario user){
        usuarios_tb.put(user.getcoduser(), user);
    }

    public void cadastraLivro(Livro book){
        livros_tb.put(book.getcodlivro(), book);
        System.out.println("\ncerto\n");
    }

    //metodos de salvamento//
    public void salvatudo(){
        salvaUsuario(this.usuarios_tb, getuserfilename());
        salvaLivro(this.livros_tb, getbookfilename());
    }
    
    public void salvaUsuario(Hashtable<String,Usuario> tb,String file){
        try{ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)); 
        out.writeObject(tb);
        out.flush();
        out.close();
        }
        catch(IOException ex){
            System.out.println("NAO FOI POSSIVEL SALVAR "+file);
        }
        
        
        //adicionar try catch no metodo de cima//
    }

    public void salvaLivro(Hashtable<String,Livro> tb,String file){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)); 
            out.writeObject(tb);
            out.flush();
            out.close();
            //adicionar try catch no metodo de cima//
        }
        catch(IOException ex){
              System.out.println("NAO FOI POSSIVEL SALVAR "+file);
        }
    }

    //conjunto modularizado de métodos para ler as bases de dados//
    public void leArquivo(String file_name, int escolha){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file_name));
            if(escolha ==1){
                try{
                    leUser(file_name, in);
                }
                catch(TabelaNaoEncontradaEx ex){
                    System.out.println(ex);
                }
                finally{
                    in.close();
                }
            }
            else{
                if(escolha ==2){
                    try{
                        leLivro(file_name, in);
                    }
                    catch(TabelaNaoEncontradaEx ex){
                        System.out.println(ex);
                    }
                    finally{
                        in.close();
                    }
                }
            }
        }
        catch(IOException ex){
            System.out.println("IMPOSSIVEL CONCLUIR ACAO. Erro na leitura de "+file_name);
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
        GregorianCalendar data = new GregorianCalendar();
        try{
            book.empresta();
            user.addLivroHist(data, book.getcodlivro());
            book.addUsuarioHist(user.getcoduser(),data);
        }
        catch(CopiaNaoDisponivelEx ex){
           // BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(ex);
        }
        
    }
    
    public void devolveLivro(Usuario user, Livro book) {
        try{
            book.devolve();
            GregorianCalendar devolucao = new GregorianCalendar();
            for (Emprest e : user.gethist()) {
                for(EmprestPara p : book.gethist()){
                    if(user.getcoduser() == p.getcoduser()){
                        if(e.dataEmprest.compareTo(p.dataEmprest) == 0){
                            if(!(e.dataDevolv == null) && (e.dataDevolv.compareTo(p.dataDevolv) == 0)){
                                e.dataDevolv = devolucao;
                                p.dataDevolv = devolucao;
                            }
                        }
                    }
                }
            }
        }
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
        }
      
    }

    /*metodos de impressao utilizando a 
     * tecnica do TREEMAP que permite 
     * ordenacao */
    
    public String imprimeLivros(Hashtable<String,Livro> livrostb){
        String livros ="";
        for(String key : livrostb.keySet()){
            livros += livrostb.get(key).toString();
        }
        return livros;
    }

    public String imprimeUsuarios(){
        String users = "";
        Hashtable<String,Usuario> usuarios = this.usuarios_tb;
        try{
        for(String key : usuarios.keySet()){
         users += getuser(key).toString()+"\n";
        }
        }
        catch(UsuarioNaoCadastradoEx ex){}
        return users;
    }
   
    //metodos get livro e get usuario jogando excecoes caso nao achem//
    public Usuario getuser(String cod) throws UsuarioNaoCadastradoEx{
        Usuario u;
        try{
            u = (Usuario) usuarios_tb.get(cod); 
            if(u!=null){
                return u;
            }
            else{
                throw new UsuarioNaoCadastradoEx(cod);
            }
        }
        catch(NullPointerException ex){
            throw new UsuarioNaoCadastradoEx(cod);
        }
        
    }

    //metodos auxiliares//
    public Livro getbook(String cod)throws LivroNaoCadastradoEx{
        Livro b;
        //try{
            b = (Livro) livros_tb.get(cod);
        //}
        //catch(NullPointerException ex){
          if(b == null){
            throw new LivroNaoCadastradoEx(cod);
          }
        //}
        return b;
    }
    public String getbookfilename(){
        return book_tb_file;
    }
    public String getuserfilename(){
        return user_tb_file;
    }
    
    public Hashtable<String,Usuario>getusertable(){
        return this.usuarios_tb;
    }
    public Hashtable<String,Livro>getbooktable(){
        return this.livros_tb;
    }
    
    public void setuserfilename(){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
            while(aux.equals("")){
            System.out.println("Entre com o novo nome do arquivo de usuarios:");
            aux = inData.readLine();
            }
            user_tb_file = aux;
        }
        catch(IOException ex){
            setuserfilename();
        }
    }
    public void setbooksfilename() {
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
            while(aux.equals("")){
            System.out.println("Entre com o novo nome do arquivo de livros:");
            aux = inData.readLine();
            }
            this.book_tb_file = aux;
        }
        catch(IOException ex){
            setbooksfilename();
        }
    }

    public static Usuario criauser(){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
            while(aux.equals("")){
            System.out.println("NOME: ");            
            aux = inData.readLine();
            }
        }
        catch(IOException ex){
            ledireito(aux); 
        }
        String nome = aux;


        try{
            aux = "";
          while(aux.equals("")){
            System.out.println("SOBRENOME: ");            
            aux = inData.readLine();
            }
           
        }
        catch(IOException ex){
            ledireito(aux);
            
        }
        String sobrenome = aux;
        
        
        try{
            aux = "";
            while(aux.equals("") || aux.length()!=8 || !(ValidaData.checkString(aux))){
                System.out.println("NASCIMENTO (ddmmaaaa):");            
                aux = inData.readLine();
            }
        }
        catch(IOException ex){
            System.out.println("ERRO NA LEITURA---tente novamente!\nNASCIMENTO:");
            if(aux.equals("") || !(ValidaData.checkString(aux)) || aux.length()!=8){
                System.out.println("tente novamente!\nNASCIMENTO (ddmmaaa):");
                ledireito(aux);
            }   
        }
        GregorianCalendar data = ValidaData.criadata1(aux);


        try{
            aux = "";
            while(aux.equals("")){
                System.out.println("ENDERECO: ");            
                aux = inData.readLine();
            }
        }
        catch(IOException ex){
            ledireito(aux);
        }
        String endereco = aux;



        try{
            aux = "";
            while(aux.equals("")){
                System.out.println("CODIGO DO USUARIO: ");            
                aux = inData.readLine();
            }
        }
        catch(IOException ex){
            ledireito(aux);
        }
        String codigo = aux;  


        return new Usuario(nome, sobrenome, data, endereco, codigo);
    }
    public String getcode(){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
                System.out.println("CODIGO:");
                aux = inData.readLine();
                if(aux.equals("")){
                    throw new NomeErradoException(aux);
                }
            }
            catch(IOException ex){
                ledireito(aux);
                return aux;
            }
           
           
        return aux;
    }
    public static Livro crialivro(){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String aux = "";
        try{
            System.out.println("TITULO: ");            
            aux = inData.readLine();
        }
        catch(IOException ex){
            ledireito(aux);
        }
        String titulo = aux;

        try{
            System.out.println("CATEGORIA: ");            
            aux = inData.readLine();
        }
        catch(IOException ex){
            ledireito(aux);
        }
        String categoria = aux;

         try{
            System.out.println("CODIGO DO LIVRO: ");            
            aux = inData.readLine();
        }
        catch(IOException ex){
            ledireito(aux);
        }
        String codigo = aux;

        //!((aux.trim()).matches("\\d+"))

        try{
        System.out.println("QUANTIDADE: ");            
        aux = inData.readLine();
        }
        catch(IOException ex){
            ledireito(aux);
        }
        int quant =0;
        if(ValidaData.checkString(aux)){quant = Integer.parseInt(aux);}
        return new Livro(codigo, titulo, categoria, quant);
    }
    public static String ledireito(String line){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        try{
        while(line.equals("")){//assegurar a continuidade ou interrupcao do loop//
            System.out.println("Insira novamente a informação:");
            line = inData.readLine();
            return line;
        }
        
        }
        catch(IOException ex){
            System.out.println("jogou ex no le direito");
            ledireito(line);
        }
        return line;
    }

}
