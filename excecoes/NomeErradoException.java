import java.io.*;

public class NomeErradoException extends IOException {
    String m;String word;

    public NomeErradoException(String m){
        this.m = m;
    }

    public  Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) >= '0' || (arg.charAt(location)) <= '9'){
                ehnum = false;
            }
        }
        return ehnum;
    }

    public void ledireito(String line) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        
        while(line.equals("") || (checkString(line)==true)){//assegurar a continuidade ou interrupcao do loop//
            System.out.println(line+" nao eh uma informacao valida para esse campo\nInsira novamente");
            line = inData.readLine();
        }            

    }
    public String toString(){
        return m+ "nao eh uma informacao valida para esse campo\nInsira novamente";
    }
}

