import java.util.GregorianCalendar;

public abstract class PessoaIMC extends Pessoa{
    private double peso;
    private double altura;

    public PessoaIMC(String nomelido,String sobrenomelido, GregorianCalendar datalida,double peso, double altura){
           super(nomelido, sobrenomelido, datalida);
           this.peso = peso;
           this.altura = altura;
    }
    //calculo do IMC//
    public double calculaIMC(){
        return peso/(altura*altura);
    }

    //metodo abstrato//
    public abstract String resultIMC();

    //metodos getter//
    public double getPeso(){
        return peso;
    }
    public double getAltura(){
        return altura;
    }

    public String toString(){
        return super.toString() + " || peso: "+peso + " || altura: "+altura;
    }
}
