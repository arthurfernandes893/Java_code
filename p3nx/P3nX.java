import java.io.*;
import java.util.*;
public class P3nX {
    //relatorio//
     
    //emprestimo// //try{emprestar e getlivro get usuario}catch exceptions{perguntar conitnuar ou desistir}
    //manutencao//
    public void manutencao(){

    }
    //cadastro//
    public void cadastro(Biblioteca lib)throws NomeErradoException, IOException,LivroCadastroEx,DataErradaException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; String aux = "";
        while(opcao.equals("") || !(opcao.equals("1")) || 
            !(opcao.equals("2")) || !(opcao.equals("3")) || 
            !(opcao.equals("4"))){
                opcao = inData.readLine();
                System.out.println("OPCOES DE CADASTRO:\n[1].cadastrar Usuario\n[2].Cadastrar Livro\n[3].Salvar\n[4].Voltar");
            }
        
        if(opcao.equals("1")){
            lib.cadastraUsuario(Usuario.criauser());
        }

        else{
            if(opcao.equals("2")){
                lib.cadastraLivro(Livro.crialivro());
            }
            else{
                if(opcao.equals("3")){
                    System.out.println("Qual acervo registro deseja salvar?\n[1].USUARIOS\n[2].LIVROS");
                    while(opcao.equals("") || !(opcao.equals("1")) || !(opcao.equals("2"))){
                        opcao = inData.readLine();
                        System.out.println("tente novamente\nQual acervo registro deseja salvar?\n[1].USUARIOS\n[2].LIVROS");
                    }
                    if(opcao.equals("1")){
                        System.out.println("Deseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                        while(opcao.equals("") || !(opcao.equals("1")) || !(opcao.equals("2"))){
                        opcao = inData.readLine();
                        System.out.println("tente novamente\nDeseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                    }
                        if(opcao.equals("1")){
                            lib.setuserfilename();
                            lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
                        }
                        else{
                            lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
                        }
                    }
                    else{
                        System.out.println("Deseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                        while(opcao.equals("") || !(opcao.equals("1")) || !(opcao.equals("2"))){
                        opcao = inData.readLine();
                        System.out.println("tente novamente\nDeseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
                    }
                        if(opcao.equals("1")){
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
    public void menu(){

    }
    public static void main(String[] args){

    }    
}
