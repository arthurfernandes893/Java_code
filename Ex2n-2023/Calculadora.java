public class Calculadora{

    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);        
        int b = Integer.parseInt(args[1]);
        //criacao do objeto com os metodos de operacao//
        Calc conta = new Calc(a,b);

        //bloco try com os metodos e respectivos catch//

        try{
            System.out.println("teste com todas as operacoes num try soh \n soma: "+ conta.soma(conta.a, conta.b));
            System.out.println("substracao: " + conta.sub(conta.a, conta.b));
            System.out.println("multiplicacao: " + conta.mult(conta.a, conta.a));
            System.out.println("divisao: " + conta.div(conta.a, conta.b));
        }
        catch(ErrParEx err){ //excecao eh a classe, preciso de uma variavel p armazenar essa excecao passada//
            System.out.println(err); //nao ha tratamento de erro, mas poderia, ja que err possui os parametros necessarios//
        }
        catch(Div0Ex err){
            System.out.println("ERRO DIVISAO POR ZERO" + err);
        }
       
        //_____________________________________________________________//
       
        System.out.println("\n____teste com cada operacao num try separado:____");
        try{
            System.out.println("soma: "+ conta.soma(conta.a, conta.b));
        }
        catch(ErrParEx err){ //excecao eh a classe, preciso de uma variavel p armazenar essa excecao passada//
            System.out.println(err); //nao ha tratamento de erro, mas poderia, ja que err possui os parametros necessarios//
        }

        try{
            System.out.println("substracao: " + conta.sub(conta.a, conta.b));
        }
        catch(ErrParEx err){ //excecao eh a classe, preciso de uma variavel p armazenar essa excecao passada//
            System.out.println(err); //nao ha tratamento de erro, mas poderia, ja que err possui os parametros necessarios//
        }

            System.out.println("multiplicacao: " + conta.mult(conta.a, conta.a));

        try{
            System.out.println("divisao: " + conta.div(conta.a, conta.b));
        }
        catch(Div0Ex err){
            System.out.println("ERRO DIVISAO POR ZERO" + err);
        }

    }
}