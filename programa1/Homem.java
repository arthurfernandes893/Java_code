import java.util.GregorianCalendar;

public class Homem extends Pessoa{
    public int idade;

    public Homem(String nomelido,String sobrenomelido,GregorianCalendar datalida,String numcpflido, float pesolido, float alturalida, int idade){
        super(nomelido, sobrenomelido, datalida, numcpflido, pesolido, alturalida);
        this.idade = idade;
    }

    public String toString(){
        return super.toString() + "\nIdade:"+idade;
    }
}