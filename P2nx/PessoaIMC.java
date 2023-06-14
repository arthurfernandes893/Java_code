import java.util.GregorianCalendar;

public class PessoaIMC extends Pessoa{
    private float peso;
    private float altura;

    public PessoaIMC(String nomelido,String sobrenomelido, GregorianCalendar datalida,float peso, float altura){
           super(nomelido, sobrenomelido, datalida);
           this.peso = peso;
           this.altura = altura;
    }
    //calculo do IMC//
    public double calculaIMC(){
        return peso/(altura*altura);
    }

    //metodo abstrato//
    public String resultIMC();

    //metodos getter//
    public double getPeso(){
        return peso;
    }
    public double getAltura(){
        return altura;
    }

    public String toString(){
        return super.toString() + "\npeso: "+peso + "\naltura: "+altura;
    }
}
