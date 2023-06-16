import java.util.GregorianCalendar;

public class Homem extends PessoaIMC{

    public Homem(String nomelido,String sobrenomelido, GregorianCalendar datalida,double peso, double altura){
        super(nomelido, sobrenomelido, datalida,peso,altura);
    }

    public String resultIMC(){
        if(calculaIMC()<20.7){
            return " || Abaixo do peso ideal ";
        }
        else{
            if(calculaIMC()>=20.7 && calculaIMC()<=26.4){
                return " || Peso Ideal ";
            }
            else{
                return " || Acima do peso Ideal ";
            }
        }
    }
    public String toString(){
        return super.toString()+" || IMC: "+calculaIMC()+ resultIMC() +"|| genero: masculino";
    }
}