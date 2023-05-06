public class Pessoa{
//declaracao de campos
   private String nome;
   private String sobrenome;
   private GregorianCalendar dataNasc; //importar//
   private int numCPF;
   
   public float peso;
   public float altura;

//construtor para caso ideal com todas as infos passadas
   Public Pessoa(String nomelido,String sobrenomelido,GregorianCalendar datalida,int numcpflido, float pesolido, float alturalida){
    nome = nomelido;
    sobrenome = sobrenomelido;
    data = datalida;
    /* ou
    data.year = datalida.year;
    data.month = datalida.month;
    data.dayOfMonth = datalida.dayOfMonth
    */
    numCPF = numcpflido;
    peso = pesolido;
    altura = alturalida;
}

//metodos getter para informacoes sensiveis
public String getnome(){
    return nome;
}
public String getsobrenome(){
    return sobrenome;
}
public GregorianCalendar getdataNasc(){
    return dataNasc;
}
public int getnumCPF(){
    return numCPF;
}

//metodo toString//
public toString(){
    return "nome:"+ nome +"\nsobrenome:"+sobrenome+"\nnascimento:"+dataNasc+"\ncpf:"+ numCPF;
}

}