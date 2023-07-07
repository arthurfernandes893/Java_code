package lp2g06.biblioteca;

import java.util.*;
import java.io.*;
public class DataErradaException extends NumberFormatException{
    boolean check;
    int len;
    public DataErradaException(int len, boolean check){
        this.len = len;
        this.check = check;
    }

    
    
    public GregorianCalendar criadatacerta(String line) throws IOException{
        int[] data_partes = new int[3];
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Dia:");
        line = inData.readLine();
        while (!ValidaData.isDay(Integer.parseInt(line))){ // garantir consistencia//
            System.out.println("Dia inserido de forma errada, insira um numero entre 1 e 31:");
            line = inData.readLine();
        }
        data_partes[0] = Integer.parseInt(line);
                
        System.out.println("Mes:");
        line = inData.readLine();
        while (!ValidaData.isMonth(Integer.parseInt(line))){
            System.out.println("Mes inserido de forma errada, insira um numero entre 1 e 12:");
            line = inData.readLine();
        }
        data_partes[1] = Integer.parseInt(line);
                
        System.out.println("Ano:");
        line = inData.readLine();
        while (!ValidaData.isYear(Integer.parseInt(line))){
            System.out.println("Ano inserido de forma errada, insira um numero entre 1920 e 2023:");
            line = inData.readLine();
        }
        data_partes[2] = Integer.parseInt(line);
        GregorianCalendar data = new GregorianCalendar(data_partes[2], data_partes[1], data_partes[0]);
        return data;
    }

    public String toString() {
        return "ERRO NA DATA!  "+"tamanho: "+len+" e checagem de caracteres: "+check;
    }
}
