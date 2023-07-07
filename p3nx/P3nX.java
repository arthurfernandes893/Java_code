import java.io.*;
import java.util.*;
import lp2g06.biblioteca.*;
public class P3nX {
    public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                ehnum = false;
                if((arg.charAt(location)) == '.' && location<(arg.length()-1)){ //se for o caracter de ponto, volta a ser verdadeiro, pois indica um float//
                    ehnum = true;
                }
            }
        }
        return ehnum;
    }
    //relatorio//
     
    //emprestimo// //try{emprestar e getlivro get usuario}catch exceptions{perguntar conitnuar ou desistir}
    
    //manutencao//
    public void manutencao(){
         BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String opcao = ""; int chave= 0; String empty = ""; int saida =0;
        System.out.println("OPCOES DE MANUTENCAO:\n[1].INICAR DO ZERO\n[2].CARREGAR BASE DE DADOS\n[3].SALVAR BASE DE DADOS\n[4].Voltar");
        opcao = inData.readLine();
        opcao.trim();
        chave = Integer.parseInt(opcao);
        while(saida ==0){
            



            opcao =""; chave =0;
        }
        //criacao dos arquivos//
        
        //abertura dos arquivos//

        //salvamento dos arquivos//
        
    
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
                        System.out.println("Deseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
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
                        System.out.println("Deseja salvar em outro arquivo?\n[1].Sim\n[2].Nao");
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
    public void menu(){ //usar principio do 2 com while saida 0 e somar 1 pra sair do bloco.

    }
    public static void main(String[] args) throws DataErradaException, NomeErradoException, IOException, LivroCadastroEx, UsuarioNaoCadastradoEx{
       P3nX prog = new P3nX();
        Biblioteca lib = new Biblioteca();
        prog.cadastro(lib);
        lib.salvaUsuario(lib.usuarios_tb, lib.getuserfilename());
        System.out.println(lib.getuser("123456789"));
    }    
}
