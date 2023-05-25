import java.io.*;
import java.util.*;

public class P1nX{
    public static String empty = ""; //constante string vazia//
   
    
    public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                ehnum = false;
            }
        }
        return ehnum;
    }
    public static void listaPessoas(Pessoa[] pessoas){
        int numH = 0; int numM = 0; Homem h; Mulher m;
        for(Pessoa a : pessoas){
            if(a instanceof Homem){
                numH+=1;
                h = (Homem) a;
            }
            else{
                numM += 1;
                m = (Mulher) a;
            }
            System.out.println(a);
        }
        //impressao do numero de homens e de mulheres//
        System.out.println(" Numero de homens:" + numH + "|| Numero de mulheres: " + numM);
    }
    public static void main(String[] args) throws IOException{
        String masc = "masculino"; String fem ="feminino"; //strings auxiliares pra categorizar o genero//
        GregorianCalendar data; //campo auxiliar de data//

        //declaracao do buffered reader e da String line//
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in)); // declaracao do buffered reader//
        String line;
        int numCadastros;
        
        //criacao do primeiro elemento 
        //0 = nome; 1 = sobrenome; 2 = cpf; 3 = nascimento; 4= genero; 5 = idade; 6 = peso; 7 = altura; --> o que fugir disso o programa pula pro loop de insercao e ignora o array args[]//
            //critica das entradas//
            if(args[0].equals(empty) || args[1].equals(empty) || !ValidaCPF.isCPF(ValidaCPF.limpaCPF(args[2])) 
            || args[3].length() != 8 || (!args[4].equals(masc) && !args[4].equals(fem)) || !checkString(args[5]))
            {   
                System.out.println("informacoes incorretas");
            }
            else{
                //conversao da data de String para Gregorian Calendar//
                int [] data1 = ValidaData.criadata1(args[3]);
                data = new GregorianCalendar(data1[2],data1[1],data1[0]);
            
                //se o elemento de args que contem o genero for tal, cria o objeto tal, senao, cria o outro//
                if(args[4].equals(masc)){
                    Pessoa men = new Homem(args[0],args[1],args[2],data,Float.parseFloat(args[6]),Float.parseFloat(args[7]),Integer.parseInt(args[5]));
                    System.out.println("\n"+ men);
                
                }
                else{
                    Pessoa woman = new Mulher(args[0],args[1],args[2],data,Float.parseFloat(args[6]),Float.parseFloat(args[7]),Integer.parseInt(args[5]));
                    System.out.println("\n"+woman);
                }
            }

        //quantos cadastros?//
        System.out.println("Quantos usuarios a mais deseja cadastrar?");
        line = inData.readLine();
        while(!checkString(line)){ // garantir que sera passado uma string de numero inteiro, sem ./* //
            if(line.equals(empty)){//em caso de enter pressionado, programa encerra//
                System.out.println("tecla enter pressionada sem nada digitado. Programa encerrado");
                System.exit(3);
            }
            line = inData.readLine();
        }
        numCadastros = Integer.parseInt(line);
        if(numCadastros  == 0){
            System.exit(1);
        }
        
        
        //criacao do array p/ armazenar os objetos criados alocando o espaco adicional para o primeiro elemento criado//
        Pessoa[] pessoas = new Pessoa[numCadastros]; 
        
    //leitura dos dados e criacao dos objetos//
        //campos auxiiares//
        String nome = ""; String sobrenome;
        int[] data_partes = new int[3];
        String cpf;
        float peso, altura;  
        String genero;
        int idade;
        
        for(int i = 0; i<numCadastros; i++){
            //ler infos e checar os valores, garantindo com while e metodos do CPF//
            System.out.println("Insira o nome:");
            line = inData.readLine();
            if(line.equals(empty)){ //se nao desejar mais inserir, basta encerrar no proximo loop//
                System.out.println("nao deseja incluir mais usuarios. programa encerrado");
                System.exit(4);
            }
            else{
            nome = line;
            }

            System.out.println("Insira o Sobrenome");
            line = inData.readLine();
            sobrenome = line;

            System.out.println("Insira a data de nascimento:");
                System.out.println("Dia:");
                line = inData.readLine();
                while (!ValidaData.isDay(Integer.parseInt(line))){ // garantir consistencia//
                    System.out.println("Dia inserido de forma errada, insira um numero entre 1 e 31:");
                    line = inData.readLine();
                }
                data_partes[0] = Integer.parseInt(line);
                
                System.out.println("Mes:");
                line = inData.readLine();
                while (!ValidaData.isMonth(Integer.parseInt(line))){
                    System.out.println("Mes inserido de forma errada, insira um numero entre 1 e 12:");
                    line = inData.readLine();
                }
                data_partes[1] = Integer.parseInt(line);
                
                System.out.println("Ano:");
                line = inData.readLine();
                while (!ValidaData.isYear(Integer.parseInt(line))){
                    System.out.println("Ano inserido de forma errada, insira um numero entre 1920 e 2023:");
                    line = inData.readLine();
                }
                data_partes[2] = Integer.parseInt(line);
                data = new GregorianCalendar(data_partes[2], data_partes[1], data_partes[0]);
                
            System.out.println("CPF:");
            line = inData.readLine();
            if(line.equals(empty)){
                cpf = empty;
            }
            else{
                while(!ValidaCPF.isCPF(ValidaCPF.limpaCPF(line))){
                System.out.println("CPF inserido de forma invalida. insira na forma abc.def.ghi-jk");
                line = inData.readLine();
                }
                cpf = ValidaCPF.limpaCPF(line);
            }
            System.out.println("Peso (em Kg):");
            line = inData.readLine();
            if(line.equals(empty)){
                peso =0;
            }
            else{ peso = Float.parseFloat(line);}
            
            System.out.println("Altura (em metros):");
            line = inData.readLine();
            if(line.equals(empty)){
                altura =0;
            }
            else{altura = Float.parseFloat(line);}
            
            System.out.println("Idade:");
            line = inData.readLine();
            if(line.equals(empty)){
                idade = 0;
            }
            else{
                while(Integer.parseInt(line) < 0 ){
                    System.out.println("Idade:");
                    line = inData.readLine();
                }
                idade = Integer.parseInt(line);
            }
      
            
           
            //ver qual o genero e instanciar o objeto correto//
            System.out.println("Genero (masculino ou feminino):");
            line = inData.readLine();
            genero = line;
            while(genero.equals(masc) == false && genero.equals(fem) == false){ //enquanto nao for nenhum dos dois// 
                System.out.println("Impossivel identificar Genero - insira novamente (masculino ou feminino):");
                line = inData.readLine();
                genero =line;
            }
            if(genero.equals(masc)){
                if(peso!=0 || altura!=0 || !cpf.equals(empty)){
                    Pessoa cidadao = new Homem(nome,sobrenome,cpf,data,peso,altura,idade); 
                    pessoas[i] = cidadao; 
                }
                else{
                    Pessoa cidadao = new Homem(nome,sobrenome,data,idade);
                    pessoas[i] = cidadao; 
                }
            }
            else{
                if(peso!=0 || altura!=0 || !cpf.equals(empty)){
                    Pessoa cidada = new Mulher(nome,sobrenome,cpf,data,peso,altura,idade); 
                    pessoas[i] = cidada;
                }
                else{
                    Pessoa cidada = new Mulher(nome,sobrenome,data,idade);
                }   
                
            }
        }
        
        //contagem do numero de homens e de mulheres e impressao dos cadastros//
        listaPessoas(pessoas);
    
    }
}