import java.util.GregorianCalendar;

public class Homem extends Pessoa{
    public int idade;

    public Homem(String nomelido,String sobrenomelido,String numcpflido, GregorianCalendar datalida, float pesolido, float alturalida, int idade){
        super(nomelido, sobrenomelido, numcpflido, datalida, pesolido, alturalida);
        this.idade = idade;
    }

    public String toString(){
        return super.toString() + " Idade:"+idade;
    }
}