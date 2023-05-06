import Pessoa; // assim ou usa o comando package???//

public class P1nX{
    public class Homem extends Pessoa{
        public String genero;
        public int idade;

        public Homem(String nomelido,String sobrenomelido,GregorianCalendar datalida,int numcpflido, float pesolido, float alturalida, String genero, int idade){
            super(nomelido, sobrenomelido, datalida, numcpflido, pesolido, alturalida);
            this.genero = genero;
            this.idade = idade;
        }
    }
    public class Mulher extends Pessoa{
        public String genero;
        public int idade;

        public Homem(String nomelido,String sobrenomelido,GregorianCalendar datalida,int numcpflido, float pesolido, float alturalida, String genero, int idade){
            super(nomelido, sobrenomelido, datalida, numcpflido, pesolido, alturalida);
            this.genero = genero;
            this.idade = idade;
        }
    }
    public static void main(String[] args){
        
    }
}