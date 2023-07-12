import java.io.*;
import java.util.*;
import lp2g06.biblioteca.*;
public class P3nX {
    public static void main(String[] args){
        P3nX prog = new P3nX();
        try{
            Biblioteca lib = new Biblioteca("firstversion_users_tb.dat","firstversion_books_tb.dat");
            prog.relatorio(lib);
        }
        catch(ErroNaAberturaEx ex){
            System.out.println(ex);
        }
    }
    //metodos auxiliares//
    public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        String empty = "";
        if(arg.equals(empty)){
             Boolean ehnum = false;
             return ehnum;
        }
        else{
            arg = arg.trim();
            Boolean ehnum = true;
            for(int location = 0; location<arg.length();location++){
                if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                    System.out.println(ehnum);
                    ehnum = false;
                }
            }
            return ehnum;
        }
    }
    public String crianomes(String n){
        String aux = "";
        System.out.println("Entre com o novo nome do arquivo:");
        while(aux.equals("")){
            System.out.println("Entre com o novo nome do arquivo:");
            Biblioteca.ledireito(aux);
        }
        n = aux;
        return n;
    }
    //relatorio//
     public void relatorio(Biblioteca lib){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        System.out.println("OPCOES DE RELATORIO:\n[1].EXIBIR USUARIOS\n[2].EXIBIR LIVROS\n[3].HISTORICO DE EMPRESTIMO [USUARIO]\n[4].HISTORICO DE EMPRESTIMO [LIVRO]\n[5].voltar");
       
        //garantir que uma opcao seja selecionada 
        try{
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        catch(IOException  ex){ 
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                System.out.println("OPCOES DE RELATORIO:\n[1].EXIBIR USUARIOS\n[2].EXIBIR LIVROS\n[3].HISTORICO DE EMPRESTIMO [USUARIO]\n[4].HISTORICO DE EMPRESTIMO [LIVRO]\n[5].voltar");
                Biblioteca.ledireito(opcao);
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        while(saida == 0){
            if(chave == 5){
                saida +=1;
            }
            else{
                if(chave == 1){
                //    System.out.println("BASE DE DADOS DOS USUARIOS:\n"+lib.imprimeUsuarios());
                }
                else{
                    if(chave == 2){
                    //    System.out.println("BASE DE DADOS DOS LIVROS:\n"+lib.imprimeLivros(lib.livros_tb));
                    }
                    else{
                        if(chave ==3){
                            String code = "";
                            System.out.println("Insira o codigo do usuario:");
                            code = lib.getcode();
                            while(code.equals(empty)){
                                System.out.println("tente novamente");
                                System.out.println("Insira o codigo do usuario:");
                                code= lib.getcode();
                            }
                            try{
                                lib.getuser(code).imprimehist();                            
                            }
                            catch(UsuarioNaoCadastradoEx ex){
                                System.out.println(ex);
                            }
                        }
                        else{
                            if(chave ==4){
                                String code = "";
                                System.out.println("Insira o codigo do livro:");
                                code = lib.getcode();
                                System.out.println("\n"+code);
                                while(code.equals(empty)){
                                    System.out.println("tente novamente");
                                    System.out.println("Insira o codigo do livro:");
                                    code= lib.getcode();
                                }
                                try{
                                    
                                    lib.getbook(code).imprimehist();                            
                                }
                                catch(LivroNaoCadastradoEx ex){
                                    System.out.println(ex);
                                }
                            }
                        }
                    }
                }
            }
            
             opcao =""; chave =0;
            while(opcao.equals(empty) || checkString(opcao)==false || chave<1 || chave>5){
                System.out.println("OPCOES DE RELATORIO:\n[1].EXIBIR USUARIOS\n[2].EXIBIR LIVROS\n[3].HISTORICO DE EMPRESTIMO [USUARIO]\n[4].HISTORICO DE EMPRESTIMO [LIVRO]\n[5].voltar");
                Biblioteca.ledireito(opcao);
                System.out.println("aaaaa "+ opcao+"-------");
               // opcao.trim();
                System.out.println(opcao+"-------"+checkString(opcao));
                
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
    }
    //emprestimo//
    public void emprestimo(Biblioteca lib){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        
        try{
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>3){
                System.out.println("OPCOES DE EMPRESTIMO:\n[1].EXIBIR CADASTRO DE LIVROS\n[2].FAZER UM EMPRESTIMO\n[3].VOLTAR");
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        catch(IOException ex){
             while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>3){
                System.out.println("OPCOES DE EMPRESTIMO:\n[1].EXIBIR CADASTRO DE LIVROS\n[2].FAZER UM EMPRESTIMO\n[3].VOLTAR");
                Biblioteca.ledireito(opcao);
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        
        while(saida == 0){
            if(chave == 3){
                saida+=1;
            }
            else{
                if(chave ==1){
                //   System.out.println(lib.imprimeLivros(lib.livros_tb));
                }
                else{
                    if(chave ==2){
                        String codeuser = "";
                        System.out.println("Insira o codigo do usuario:");
                        codeuser = lib.getcode();
                        System.out.println("Insira o codigo do livro:");
                        String codebook = lib.getcode();
                        while(codeuser.equals(empty) || codebook.equals(empty)){
                            System.out.println("tente novamente");
                            System.out.println("Insira o codigo do usuario:");
                            codeuser = lib.getcode();
                            System.out.println("Insira o codigo do livro:");
                            codebook = lib.getcode();
                        }

                        try{
                            lib.emprestaLivro(lib.getuser(codebook),lib.getbook(codebook));
                            System.out.println("EMPRESTIMO EFETUADO COM SUCESSO\n"+lib.getuser(codeuser).getnome() + " || "+codeuser+"\n"+lib.getbook(codebook).gettitulo() + " || "+codebook);
                        }
                        catch(UsuarioNaoCadastradoEx ex){
                            System.out.println(ex+"\n nao foi possivel concluir acao");
                        }
                        catch(LivroNaoCadastradoEx ex){
                            System.out.println(ex+"\n nao foi possivel concluir acao");
                        }    
                    }
                }
            }
          
            opcao =""; chave =0;
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>3){
                System.out.println("OPCOES DE EMPRESTIMO:\n[1].EXIBIR CADASTRO DE LIVROS\n[2].FAZER UM EMPRESTIMO\n[3].DEVOLUCAO\n[4].voltar");
                Biblioteca.ledireito(opcao);
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        //salva em arquivo ao fim//
        lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
        lib.salvaLivro(lib.livros_tb, lib.getbookfilename());
    }
    //manutencao//
    public void manutencao(Biblioteca lib){
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        
        /*A opcao de iniciar a biblioteca com arquivos sem ser os predefinidos
         * sera incluida em um metodo usado somente no comeco
         * aqui fica a opcao de usar outra base de dados
         */

        try{
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                System.out.println("OPCOES DE MANUTENCAO:\n[1].INICAR NOVA BASE DE DADOS\n[2].CARREGAR BASE DE DADOS EXISTENTE\n[3].SALVAR BASE DE DADOS\n[4].SALVAR NOVA BASE DE DADOS\n[5].voltar");
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
        catch(IOException ex){
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                System.out.println("OPCOES DE MANUTENCAO:\n[1].INICAR NOVA BASE DE DADOS\n[2].CARREGAR BASE DE DADOS EXISTENTE\n[3].SALVAR BASE DE DADOS\n[4].SALVAR NOVA BASE DE DADOS\n[5].voltar");
                Biblioteca.ledireito(opcao);
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
        }
       
        while(saida ==0){
            if(chave == 5){
                saida+=1;
            }
            else{
                if(chave ==1){ //criar base de dados//
                   /*String nome1 ="";String nome2 ="";
                    System.out.println("INSIRA NOME DA BASE DE USUARIOS\n(!WARNING: por precaucao, mude as tabelas para as suas respectivas duplas,\npara evitar confusao entre os dados e problemas na execução):");
                    crianomes(nome1);
                    System.out.println("INSIRA O NOME DA BASE DE LIVROS");
                    crianomes(nome2);
                    */
                    lib.setuserfilename();
                    lib.setbooksfilename();
                    lib.salvatudo();

                }
                else{
                   if(chave ==2){ //carregar base de dados
                        String nome1 ="";String nome2 ="";
                        System.out.println("INSIRA NOME DA BASE DE USUARIOS:");
                        crianomes(nome1);
                        System.out.println("INSIRA O NOME DA BASE DE LIVROS");
                        crianomes(nome2);
                        lib.leArquivo(nome1,1);
                        lib.leArquivo(nome2,2);
                   }
                   else{ 
                        if(chave ==3){ //salvar na base de dados//
                           lib.salvatudo();
                        }
                        else{ //salvar na base de dados
                            if(chave ==4){
                                lib.setuserfilename();
                                lib.setbooksfilename();
                                lib.salvatudo();
                            }
                        }
                    }
                }
            }
            opcao =""; chave =0;
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                System.out.println("OPCOES DE MANUTENCAO:\n[1].INICAR NOVA BASE DE DADOS\n[2].CARREGAR BASE DE DADOS EXISTENTE\n[3].SALVAR BASE DE DADOS\n[4].SALVAR NOVA BASE DE DADOS\n[5].voltar");
                Biblioteca.ledireito(opcao);
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
            }
           
        }
    }
    //cadastro//
    public void cadastro(Biblioteca lib)throws NomeErradoException, IOException,LivroCadastroEx,DataErradaException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        System.out.println("OPCOES DE CADASTRO:\n[1].cadastrar Usuario\n[2].Cadastrar Livro\n[3].Salvar\n[4].Voltar");
        opcao = inData.readLine();
        opcao.trim();
        chave = Integer.parseInt(opcao);
        while(saida ==0){
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>4){
                
                System.out.println("OPCOES DE CADASTRO:\n[1].cadastrar Usuario\n[2].Cadastrar Livro\n[3].Salvar\n[4].Voltar");
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
                System.out.println(opcao);
            }
            if(chave ==4){
                saida+=1;
            }
            else{
                if((chave ==1)){
                lib.cadastraUsuario(Biblioteca.criauser());
                } 
                else{
                    if(chave == 2){
                        lib.cadastraLivro(Biblioteca.crialivro());
                    }
                    else{
                        if(chave == 3){
                            System.out.println("Qual acervo registro deseja salvar?\n[1].USUARIOS\n[2].LIVROS");
                            while(opcao.equals(empty) || chave<1 || chave >2){
                                System.out.println("tente novamente\nQual acervo registro deseja salvar?\n[1].USUARIOS\n[2].LIVROS");
                                opcao = inData.readLine();
                                opcao.trim();
                                chave = Integer.parseInt(opcao);
                            }
                            if(chave == 1){
                                chave =0; //fator de ajuste das opcoes//
                                while(opcao.equals(empty) || chave<1 || chave >2){
                                    System.out.println("tente novamente\nDeseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                                    opcao = inData.readLine();
                                    opcao.trim();
                                    chave = Integer.parseInt(opcao);
                                }
                                if(chave == 1){
                                    lib.setuserfilename();
                                    lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
                                }
                                else{
                                    lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
                                }
                            }
                            else{
                                while(opcao.equals(empty) || chave<1 || chave >2){
                                    System.out.println("tente novamente\nDeseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                                    opcao = inData.readLine();
                                    opcao.trim();
                                    chave = Integer.parseInt(opcao);
                                }
                                if(chave ==1){
                                    lib.setbooksfilename();;
                                    lib.salvaUsuario(lib.usuarios_tb, lib.getbookfilename());
                                }
                                else{
                                    lib.salvaUsuario(lib.usuarios_tb, lib.getbookfilename());
                                }
                            }
                        }
                    }
                }
            }
        opcao = ""; chave= 0; 
        }
    }      
    //menu//
    public static void menu(P3nX prog, Biblioteca lib) throws IOException, DataErradaException, LivroCadastroEx, UsuarioNaoCadastradoEx{ //usar principio do 2 com while saida 0 e somar 1 pra sair do bloco.
        //primeira acao ao inicar o programa eh carregar a base de dados//
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        System.out.println("OPCOES:\n[1].Carregar base de dados ou cadastrar livro/usuario\n[2].Fazer um emprestimo ou devolucao\n[3].alterar base de dados, iniciar do zero ou salvar\n[4].Imprimir relatorios[5].Encerrar");
        try{
            opcao = inData.readLine();
            opcao.trim();
            if(checkString(opcao)){chave = Integer.parseInt(opcao);}
        }
        catch(IOException  ex){ 
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                System.out.println("OPCOES:\n[1].Carregar base de dados ou cadastrar livro/usuario\n[2].Fazer um emprestimo ou devolucao\n[3].alterar base de dados, iniciar do zero ou salvar\n[4].Imprimir relatorios[5].Encerrar");
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);}
                System.out.println(chave);
            }
        }
        while(saida == 0){
            while(opcao.equals(empty) || !checkString(opcao) || chave<1 || chave>5){
                    System.out.println("OPCOES:\n[1].Carregar base de dados ou cadastrar livro/usuario\n[2].Fazer um emprestimo ou devolucao\n[3].alterar base de dados, iniciar do zero ou salvar\n[4].Imprimir relatorios[5].Encerrar");
                opcao = inData.readLine();
                opcao.trim();
                if(checkString(opcao)){chave = Integer.parseInt(opcao);} 
                System.out.println(chave);
            }

            if(chave == 5){
                lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
                lib.salvaLivro(lib.livros_tb, lib.getbookfilename());
                System.exit(0);
            }

            else{
                if(chave ==1){
                    prog.cadastro(lib);
                }
                else{
                    if(chave ==2){
                        prog.emprestimo(lib);
                    }
                    else{
                        if(chave ==3){
                            prog.manutencao(lib);
                        }
                        else{
                            if(chave ==4){
                                prog.relatorio(lib);
                            }
                        }
                    }
                }
            }

        }


    }
    

}
