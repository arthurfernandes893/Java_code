import java.io.*;
import java.util.*;
public class testestring{
	public static void main(String[] args) throws IOException{
		/*String aux = "123.456..789--80";
		
		String print ="";
		String recebe = aux.replace('.','-') ;
		String array[] = recebe.split("-");
		
		System.out.println("recebe: "+ recebe);
		System.out.println("array[0]: " + array[0]);
		for(String s : array){
			System.out.println("item do array: " + s);
			print = print +s;
		}
		System.out.println(print);*/

//		GregorianCalendar data = new GregorianCalendar(2003,05,1);
//		System.out.println(data.get(Calendar.DATE) +"/"+data.get(Calendar.MONTH)+"/"+data.get(Calendar.YEAR));
		String masc = "masculino"; String fem ="feminino";
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		String line = inData.readLine();
		while(line.equals(masc) == false && line.equals(fem) == false){ //enquanto nao for nenhum dos dois// 
			System.out.println("Impossivel identificar Genero - insira novamente (masculino ou feminino):");
			line = inData.readLine();
			
		}
	}
}