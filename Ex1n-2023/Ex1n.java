import java.io.*;

public class Ex1n{
    public static void main(String[] args) throws IOException{
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in)); // declaracao do buffered reader//
        String line; 
        
        System.out.println("Insira uma linha e pressione enter ao fim:");
        line = inData.readLine(); // Le uma linha por vez

        
        int location; char letter;	
        int[] letterCount = new int[26];
        int index;
        String aux = "";

        while (line != null){ // Enquando houver linhas a serem lidas 
            //le e conta o numero de vezes//
            for (location =0; location<line.length(); location++){ 
                letter = line.charAt(location);
                if ((letter  >= 'A' && letter <= 'Z') || (letter  >= 'a' && letter <= 'z')){ 
                    // 2o truque
                index = (int)Character.toUpperCase(letter) - (int) 'A';	
                letterCount[index]++;
                }
            }
            
            //imprime o numero de vezes//
            for (index = 0; index < letterCount.length; index++){
                System.out.println("The total number of "  
                + (char) (index + (int) 'A') + "'s is "  
                + letterCount[index]);
            }

            line = inData.readLine();// Lê a próxima linha
            if(line.equals(aux)){
                break;
            }
        }
    }
}