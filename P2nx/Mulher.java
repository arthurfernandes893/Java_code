import java.util.GregorianCalendar;

public class Mulher extends PessoaIMC{
    public Mulher(String nomelido,String sobrenomelido, GregorianCalendar datalida,double peso, double altura){
        super(nomelido, sobrenomelido, datalida,peso,altura);
    }

    public String resultIMC(){ 
        if(calculaIMC()<19){
            return " || Abaixo do peso ideal ";
        }
        else{
            if(calculaIMC()>=19 && calculaIMC()<=25.8){
                return " || Peso Ideal ";
            }
            else{
                return " || Acima do peso Ideal ";
            }
        }
    }
    public String toString(){
        return super.toString()+" || IMC: "+calculaIMC()+ resultIMC() + "|| genero: feminino";
    }
}
