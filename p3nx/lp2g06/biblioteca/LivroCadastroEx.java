import java.io.*;
public class LivroCadastroEx extends Exception{
    String m;String word;

    public LivroCadastroEx(String m){
        this.m = m;
    }

    public void ledireito(String line) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        
        while(line.equals("") || !((line.trim()).matches("\\d+"))){//assegurar a continuidade ou interrupcao do loop//
            System.out.println(line+" nao eh uma informacao valida para esse campo\nInsira novamente");
            line = inData.readLine();
        }            

    }
    public String toString(){
        return m+ "nao eh uma informacao valida para esse campo\nInsira novamente";
    }
}    

