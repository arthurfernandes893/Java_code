import java.util.GregorianCalendar;

public class Mulher extends PessoaIMC{
    public Mulher(String nomelido,String sobrenomelido, GregorianCalendar datalida,float peso, float altura){
        super(nomelido, sobrenomelido, datalida,peso,altura);
    }

    public String resultIMC(){ 
        if(calculaIMC()<19){
            return "\nAbaixo do peso ideal";
        }
        else{
            if(calculaIMC()>=19 && calculaIMC()<=25.8){
                return "\nPeso Ideal";
            }
            else{
                return "\nAcima do peso Ideal";
            }
        }
    }
    public String toString(){
        return super.toString()+resultIMC() + "\ngenero: feminino";
    }
}
