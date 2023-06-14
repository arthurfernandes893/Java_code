import java.util.GregorianCalendar;

public class Homem extends PessoaIMC{

    public Homem(String nomelido,String sobrenomelido, GregorianCalendar datalida,float peso, float altura){
        super(nomelido, sobrenomelido, datalida,peso,altura);
    }

    public String resultIMC(){
        if(calculaIMC()<20.7){
            return "\nAbaixo do peso ideal";
        }
        else{
            if(calculaIMC()>=20.7 && calculaIMC()<=26.4){
                return "\nPeso Ideal";
            }
            else{
                return "\nAcima do peso Ideal";
            }
        }
    }
    public String toString(){
        return super.toString()+resultIMC() +"\ngenero: masculino";
    }
}