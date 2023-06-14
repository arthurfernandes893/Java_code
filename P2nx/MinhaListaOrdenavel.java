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
    public PessoaIMC criapessoa() throws NomeErrado,DataErrada,PesoEAlturaErrado{
        //criar buffer fora do try/catch //
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        // definir parametros de checagem e exceções jogadas//
        String nome = ""; String sobrenome; String line; String empty = "";
        int[] data_partes = new int[3];
        float peso, altura;  
        String genero;
        GregorianCalendar data;
          
        try{
        System.out.println("Se desejar encerrar a execução, pressione enter\nInsira o nome:");
        line = inData.readLine();
        if(line.equals(empty)){
            throw new NomeErrado("campo vazio. deseja continuar inserindo ou encerrar?\t[Y] ou [N]");
        }
        }
        catch(NomeErrado e){
            System.out.println(e);
            line = inData.readLine();
            String aux = e.ledireito(line); 
            if ((aux).equals(P2nX.empty)){
                System.exit(1);
            }
            else{
                nome = aux;
            }

        }

        System.out.println("Insira o Sobrenome");
        line = inData.readLine();
        sobrenome = line;

        try{
        System.out.println("Insira a data de nascimento na forma ddmmaaaa - SEM BARRA:");
        line = inData.readLine();
        if(!P2nX.checkString(line) || line.length() > 8 || line.length() < 8){
            throw new DataErrada(line.length(),P2nX.checkString(line));
        }
        }
        catch(DataErrada d){
            System.out.println(d);
            data = d.criadatacerta(line);
        }

        try{        
        System.out.println("Peso (em Kg):");
        line = inData.readLine();
        if(!P2nX.checkString(line) || Float.parseFloat(line) < 1 || Float.parseFloat(line) > 200){
            throw new PesoEAlturaErrado("peso");
        }
        }    
        catch(PesoEAlturaErrado p){
            System.out.println(p);
            peso = p.criapesocerto(line);
        }
        /*if(line.equals(empty)){
                peso =0;
            }
            else{ peso = Float.parseFloat(line);}
            */
            
            
            try{        
                System.out.println("Altura (em metros):");
                line = inData.readLine();
                if(!P2nX.checkString(line) || Float.parseFloat(line) < 0.5 || Float.parseFloat(line) > 3){
                    throw new PesoEAlturaErrado("altura");
                }
                }    
                catch(PesoEAlturaErrado p){
                    System.out.println(p);
                    altura = p.criaalturacerta(line);
                }
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
