import java.io.BufferedReader;
import java.util.*;

public class P1nX{
    public class Pessoa{
        //declaracao de campos
           private String nome;
           private String sobrenome;
           private GregorianCalendar dataNasc; //importar//
           private int numCPF;
           
           public float peso;
           public float altura;
        
        //construtor para caso ideal com todas as infos passadas
        Public Pessoa(String nomelido,String sobrenomelido,/*GregorianCalendar datalida,*/int numcpflido, float pesolido, float alturalida){
            nome = nomelido;
            sobrenome = sobrenomelido;
            //data = datalida;
            /* ou
            data.year = datalida.year;
            data.month = datalida.month;
            data.dayOfMonth = datalida.dayOfMonth
            */
            numCPF = numcpflido;
            peso = pesolido;
            altura = alturalida;
        }
        
        //metodos getter para informacoes sensiveis
        public String getnome(){
            return nome;
        }
        public String getsobrenome(){
            return sobrenome;
        }
        public GregorianCalendar getdataNasc(){
            return dataNasc;
        }
        public int getnumCPF(){
            return numCPF;
        }
        
        //metodo toString//
        public String toString(){
            return "nome:"+ nome +"\nsobrenome:"+sobrenome+"\nnascimento:"+dataNasc+"\ncpf:"+ numCPF;
        }
        
        }

    public class Homem extends Pessoa{
        public String genero;
        public int idade;

        public Homem(String nomelido,String sobrenomelido,GregorianCalendar datalida,int numcpflido, float pesolido, float alturalida, String genero, int idade){
            super(nomelido, sobrenomelido, datalida, numcpflido, pesolido, alturalida);
            this.genero = genero;
            this.idade = idade;
        }

        public String toString(){
            return "nome:"+ getnome() +"\n sobrenome:"+getsobrenome()+ "\n nascimento:"+dataNasc+ "\n cpf:"+ numCPF+ "\n genero"+genero;
        }
    }
    public class Mulher extends Pessoa{
        public String genero;
        public int idade;

        public Mulher(String nomelido,String sobrenomelido,GregorianCalendar datalida,int numcpflido, float pesolido, float alturalida, String genero, int idade){
            super();
            this.genero = genero;
            this.idade = idade;
        }
    }

    public class ValidaCPF{
        //validacao e formatacao 

        //eh convertivel em cpf?
        public static boolean isCPF(String scpf){
            if()
            return true;
            else{
                return false;
            }
        }

        public static int toIntCPF(String scpf){
            int icpf;
            //percorrer a string vendo se ha pontos ou espacos e juntando tudo pra ter so numero//
            //converter
            icpf = parseInt(scpf);
            return icpf;

        }
    }

    public class ValidaData{ //porque esta errado??//
    // metodos recebendo a data como int//
        public static Boolean isDay(int day){
            if(day>31 && day <1){
                return false;
            }
            else{
            return true;
            }
        }
    
        public static Boolean checkMonth(int month){
            if(month>12 && month<1){
                return false;
            }
            else{
                return true;
                }
        }
        public static Boolean checkYear(int year){
            if(year<1920 && year>2023){ //o limite eh o ano corrente?//
                return false;
            }
            else{
                return true;
                }
        
        }
    }


    public static void main(String[] args){
        //declaracao do buffered reader e da String line//
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in)); // declaracao do buffered reader//
        String line;
        int numCadastros;
        //criacao do primeiro elemento//
            //se o elemento de args que contem o genero for tal, cria o objeto tal, senao, cria o outro//

        //quantos cadastros?//
        System.out.println("Quantos usuarios a mais deseja cadastrar?");
        line = inData.readLine();
        int numCadastros = parseInt(line);
        while(!line.isdigit() || numCadastros<1){ // garantir que sera passado um numero inteiro, sem ./* //
            line = inData.readLine();
        }
        if(numCadastros  == 0){
            System.exit(1);
        }
        
        
        Pessoa[] pessoas = new Pessoa[numCadastros+1]; //criacao do array p/ armazenar os objetos criados alocando o espaco adicional para o primeiro elemento criado//
        
        //leitura dos dados e criacao dos objetos//
        String nome; String sobrenome;
        int[] data_partes = new int[3];
        String cpf;
        float peso, altura;  
        String genero,masc,fem;
        int idade;
        masc = "masculino"; fem ="feminino";
        for(int i = 0; i<pessoas.length; i++){
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
                data_partes[0] = parseInt(line);
                
                System.out.println("Mes:");
                line = inData.readLine();
                data_partes[1] = parseInt(line);
                
                System.out.println("Ano:");
                line = inData.readLine();
                data_partes[2] = parseInt(line);

                //criacao do objeto da data//
                ///////////////////////////
            
            System.out.println("CPF:");
            line = inData.readLine();
            if(line.isCPF){
                cpf = line;
            }

            System.out.println("Peso:");
            line = inData.readLine();
            peso = parseFloat(line);
            
            System.out.println("Altura:");
            line = inData.readLine();
            altura = parseFloat(line);
            
            System.out.println("Idade:");
            line = inData.readLine();
            idade = parseInt(line);

            //ver qual o genero e instanciar o objeto correto//
            System.out.println("Genero (masculino ou feminino):");
            line = inData.readLine();
            while(!genero.equals(masc) || !genero.equals(fem)){
            System.out.println("Genero (masculino ou feminino):");
            line = inData.readLine();
            }
        
            if(genero.equals(masc)){
                Homem cidadao = new Homem(nome,sobrenome,...,cpf,peso,altura,genero,idade); //falta data dps do sobrenome//
                
            }
            else{
                Mulher cidadao = new Mulher(nome,sobrenome,...,cpf,peso,altura,genero,idade); //falta data dps do sobrenome//
                   
            }

            //inclusao no array//

        }

    }
}