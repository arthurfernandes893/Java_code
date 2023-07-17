import java.util.*;
import java.io.*;
public class P2nX{
    public static final String empty = "";
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
    public static void listaPessoas(ArrayList<PessoaIMC> pessoas){
        Homem h; Mulher m;
        for(PessoaIMC a : pessoas){
            if(a instanceof Homem){
                h = (Homem) a;
                System.out.println(h);
            }
            else{
                m = (Mulher) a;
                System.out.println(m);
            }
        }
    }

    public static void menu(MinhaListaOrdenavel array) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int chave;
        int saida =0;
        while(saida ==0){
        System.out.println("\nEscolha seu modo de ordenacao:\n1.Alfabetica (A-Z)\n2.Alfabetica (Z-A)\n3.Menor Peso\n4.Maior Peso\n5.Altura\n6.genero\n7.IMC\n8.Sair   ");
            line = inData.readLine();
            while(Integer.parseInt(line)>8 ||Integer.parseInt(line)<1 ){
                System.out.println("\nEscolha seu modo de ordenacao:\n1.Alfabetica (A-Z)\n2.Alfabetica (Z-A)\n3.Menor Peso\n4.Maior Peso\n5.Altura\n6.genero\n7.IMC\n8.Sair  ");
                line = inData.readLine();
            }
            chave = Integer.parseInt(line);
            if(chave == 8){ //se 8, encerra o programa senao, executa a ordenacao e imprime
                saida++;
            }
            else{
                array.compara(chave);
                listaPessoas(array.pessoas);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //criacao do arraylist//
        MinhaListaOrdenavel array = new MinhaListaOrdenavel();
        for(int i = 0;i<10;i++){
            array.cirapreset(i);
        }

        //menu
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String line; int chave;
        System.out.println("1.Imprimir Lista\n2.Sair");
        line = inData.readLine(); 
        line.trim(); 
        chave = Integer.parseInt(line); //alterar checkstring e criar outra versao pra float//
        while(line.equals(empty) || !checkString(line) || chave>2 || chave<1){
            System.out.println("1.Imprimir Lista\n2.Sair");
            line = inData.readLine(); 
            line.trim();
            chave = Integer.parseInt(line);
        }

        if(chave == 2){System.exit(1);} //se 2, encerra o programa, senao, apresenta opcoes//
        else{
            menu(array);
        }
    }
}