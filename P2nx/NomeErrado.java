import java.io.*;

public class NomeErrado extends IOException {
    String m;String word;

    public NomeErrado(String m){
        this.m = m;
    }

public String ledireito(String line) throws IOException{
    BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
    
    while(line.equals(P2nX.empty)){//assegurar a continuidade ou interrupcao do loop//
        System.out.println(m);
        line = inData.readLine();
    }
    if(line.equals("Y") || line.equals("y")){
        System.out.println("Nome:");
        line = inData.readLine();
        while(line.equals(P2nX.empty)){
            System.out.println(m);
            line = inData.readLine();
        }
        return line;
    }
    else{
        return "";
        
    }
   }
}

