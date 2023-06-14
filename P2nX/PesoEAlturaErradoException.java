import java.io.*;

public class PesoEAlturaErradoException extends NumberFormatException{
    String campo;
    
    public PesoEAlturaErradoException(String campo){
        this.campo = campo;
    }

    public float criapesocerto(String line) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        float aux = 0;
        while(line.equals(P2nX.empty) || !P2nX.checkString(line) || aux<1 || aux>200){
            System.out.println("Peso fora dos padroes de caractere ou campo vazio.");
            line = inData.readLine();
            aux = Float.parseFloat(line);
        }
        return aux;
    }

    public float criaalturacerta(String line) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        float aux = 0;
        while(line.equals(P2nX.empty) || !P2nX.checkString(line) || aux<0.5 || aux>3){
            System.out.println("Peso fora dos padroes de caractere ou campo vazio.");
            line = inData.readLine();
            aux = Float.parseFloat(line);
        }
        return aux;

    }

    public String toString(){
        return "ERRO NO "+campo;
    }
}
