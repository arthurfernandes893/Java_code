import java.io.*;
import java.util.*;

public class P1nX{
    public static String empty = "";
    public static String masc = "masculino"; public static String fem ="feminino";
    
    public static Boolean checkString(String arg){
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                ehnum = false;
            }
        }
        return ehnum;
    }
   
    public static void main(String[] args){
        //declaracao do buffered reader e da String line//
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in)); // declaracao do buffered reader//
        String line;
        int numCadastros;
        
        

        //criacao do primeiro elemento - COLOCAR EM UM METODO//
            //critica das entradas//
            while(args[0].equals(empty)){       
                System.out.println("primeiro elemento - nome - nao foi inserido, tente novamwente:");
                args[0] = inData.readLine();
            }
            while(args[1].equals(empty)){       
                System.out.println("segundo elemento - sobrenome - nao foi inserido, tente novamwente:");
                args[1] = inData.readLine();
            }
            while(!ValidaCPF.isCPF(args[2])){
                System.out.println("Terceiro elemento - CPF - inserido errado. tente novamente:");
                args[2] = inData.readLine();
            }
            while(args[3].length() != 8){
                System.out.println("DATA inserida de forma ERRADA. tente novamente adicionando na forma ddmmaaaa, sem espacos nem demais caracteres:");
                args[3] = inData.readLine();
            }
            while(!args[4].equals(masc) || !args[4].equals(fem)){
                System.out.println("Genero errado. tente novamente (masculino ou feminino):");
                args[4] = inData.readLine();
            }
            while(!checkString(args[5])){
                System.out.println("IDADE inserida de forma errada. tente novamente inserido apenas caracteres numericos:");
                args[5] = inData.readLine();
            }

        //conversao da data de String para Gregorian Calendar//
        int [] data1 = ValidaData.criadata1(args[3]);
        GregorianCalendar data = new GregorianCalendar(data1[2],data1[1],data1[0]);
            
        //se o elemento de args que contem o genero for tal, cria o objeto tal, senao, cria o outro//
        if(args[4].equals(masc)){
            Homem men = new Homem(args[0],args[1],args[2],data,Float.parseFloat(args[6]),Float.parseFloat(args[7]),Integer.parseInt(args[5]));
        }
        else{
            Mulher woman = new Mulher(args[0],args[1],args[2],data,Float.parseFloat(args[6]),Float.parseFloat(args[7]),Integer.parseInt(args[5]));
        }

        //quantos cadastros?//
        System.out.println("Quantos usuarios a mais deseja cadastrar?");
        line = inData.readLine();
        numCadastros = Integer.parseInt(line);
        while(!checkString(line)){ // garantir que sera passado um numero inteiro, sem ./* //
            line = inData.readLine();
        }
        if(numCadastros  == 0){
            System.exit(1);
        }
        
        //criacao do array p/ armazenar os objetos criados alocando o espaco adicional para o primeiro elemento criado//
        Pessoa[] pessoas = new Pessoa[numCadastros+1]; 
        
        //inclusao do primeiro elemento passado por linha de comando://


        //leitura dos dados e criacao dos objetos//
        String nome; String sobrenome;
        int[] data_partes = new int[3];
        String cpf;
        float peso, altura;  
        String genero,masc,fem;
        int idade;
        

        for(int i = 0; i<(pessoas.length-1); i++){
            //ler infos e checar os valores, garantindo com while e metodos do CPF//
            System.out.println("Insira o nome:");
            line = inData.readLine();
            nome = line;

            System.out.println("Insira o Sobrenome");
            line = inData.readLine();
            sobrenome = line;

            System.out.println("Insira a data de nascimento:");
                System.out.println("Dia:");
                line = inData.readLine();
                data_partes[0] = Integer.parseInt(line);
                
                System.out.println("Mes:");
                line = inData.readLine();
                data_partes[1] = Integer.parseInt(line);
                
                System.out.println("Ano:");
                line = inData.readLine();
                data_partes[2] = Integer.parseInt(line);

                data = new GregorianCalendar(data_partes[2], data_partes[1], data_partes[0]);
                
            
            System.out.println("CPF:");
            line = inData.readLine();
            if(line.isCPF()){
                cpf = line;
            }

            System.out.println("Peso:");
            line = inData.readLine();
            peso = Float.parseFloat(line);
            
            System.out.println("Altura:");
            line = inData.readLine();
            altura = Float.parseFloat(line);
            
            System.out.println("Idade:");
            line = inData.readLine();
            idade = Integer.parseInt(line);

            //ver qual o genero e instanciar o objeto correto//
            System.out.println("Genero (masculino ou feminino):");
            line = inData.readLine();
            while(!genero.equals(masc) || !genero.equals(fem)){
            System.out.println("Genero (masculino ou feminino):");
            line = inData.readLine();
            }
        
            if(genero.equals(masc)){
                Homem cidadao = new Homem(nome,sobrenome,cpf,data,peso,altura,idade); //falta data dps do sobrenome//
                
            }
            else{
                Mulher cidadao = new Mulher(nome,sobrenome,cpf,data,peso,altura,idade); //falta data dps do sobrenome//
                   
            }

            //inclusao no array//

        }

    }
}