import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MinhaListaOrdenavel {
    //criar arraylist de pessoaimc pois eh a superclasse comum aos dois//
    ArrayList<PessoaIMC> pessoas = new ArrayList<>();
    public MinhaListaOrdenavel(){}

    //metod add e get necessarios por conta do polimorfismo//

    public void add(PessoaIMC p){
        pessoas.add(p);
    }

    public PessoaIMC get(int index){
        return pessoas.get(index);
    }
    public PessoaIMC criapessoa() throws IOException,NumberFormatException{
        //criar buffer fora do try/catch //
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        // definir parametros de checagem e exceções jogadas//
        String nome = ""; String sobrenome; String line;
        int[] data_partes = new int[3];
        float peso, altura;  
        String genero;

          
        System.out.println("Se desejar encerrar a execução, pressione enter\nInsira o nome:");
        line = inData.readLine();
        /*     if(line.equals(empty)){ //se nao desejar mais inserir, basta encerrar no proximo loop//
                System.out.println("nao deseja incluir mais usuarios. programa encerrado");
                
            }
            else{
            nome = line;
            }
*/
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
                
           
            System.out.println("Peso (em Kg):");
            line = inData.readLine();
            /*if(line.equals(empty)){
                peso =0;
            }
            else{ peso = Float.parseFloat(line);}
            */
            System.out.println("Altura (em metros):");
            line = inData.readLine();
            /*if(line.equals(empty)){
                altura =0;
            }
            else{altura = Float.parseFloat(line);}
            */
            }
            
    }
    
    

    //ordenacao//
 /*TEMPLATE
 public Comparator pesoC = new Comparator () {
 public int compare (Object p1, Object p2){ // recebe objetos PessoaIMC como Object
 double pf1, pf2;
 pf2 = (PessoaIMC) p2.getPeso();
 pf1 = (PessoaIMC) p1.getPeso();
 return (int)Math.round (pf2 – pf1);
 }
};
 */

/*
 public ArrayList ordena (int critério) {
...switch (critério) {
 case PESO: 
 Collections.sort(this.[ArrayList encapsulado] , pesoC); 
 // passamos o próprio ArrayList encapusado dentro de MinhaListaOrdenavel
 // e o Comparator correspondente ao critério
 case PESO_REVERSO: 
 Collections.sort(this.[ArrayList encapsulado] , pesoC.reversed());
 // observe que a única diferença é a chamada a reversed()
...
 return this.[ArrayList encapsulado];
}
*/
}
