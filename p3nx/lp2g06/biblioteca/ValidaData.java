package lp2g06.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

public class ValidaData{ //porque esta errado??//
        // metodos recebendo a data como int//
        public static Boolean isDay(int day){
            if(day>31 || day <1){
                return false;
            }
            else{
            return true;
            }
        }
        public static Boolean isDay(String d){
            int dia = Integer.parseInt(d);
            if(dia>31 || dia <1){
                return false;
            }
            else{
            return true;
            }
        }

        public static Boolean isMonth(int month){
            if(month>12 || month<1){
                return false;
            }
            else{                    
                return true;
            }
        }
        public static Boolean isMonth(String month){
            int mes = Integer.parseInt(month);
            if(mes>12 || mes<1){
                return false;
            }
            else{                    
                return true;
            }
        }
        
        public static Boolean isYear(int year){
            if(year<1920 || year>2023){ //o limite eh o ano corrente?//
                return false;
            }
            else{
                return true;
                }
        }
        public static Boolean isYear(String year){
            int ano = Integer.parseInt(year);
            if(ano<1920 || ano>2023){ //o limite eh o ano corrente?//
                return false;
            }
            else{
                return true;
                }
        }

        public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                ehnum = false;
            }
        }
        return ehnum;
        }

        public static GregorianCalendar criadata1(String sdata){
            int[] datacerta = new int[3];
            String partes = "";
            char[] charaux = sdata.toCharArray();
            partes = String.copyValueOf(charaux,0,2); //usa String. no começo pelo msm motivo dos parses. sao metodos static das classes String,Integer, etc//
            datacerta[0] = Integer.parseInt(partes);
                
            partes = String.copyValueOf(charaux,2,2);

            datacerta[1] = Integer.parseInt(partes);
                
            partes = String.copyValueOf(charaux,4,4);
            datacerta[2] = Integer.parseInt(partes);

            return new GregorianCalendar(datacerta[2],datacerta[1],datacerta[0]);
            }

        public static GregorianCalendar criadatacerta(String line) throws IOException{
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
            while (line.length()>4 || !ValidaData.isYear(Integer.parseInt(line))){
                System.out.println("Ano inserido de forma errada, insira um numero entre 1920 e 2023:");
                line = inData.readLine();
            }
            data_partes[2] = Integer.parseInt(line);
            GregorianCalendar data = new GregorianCalendar(data_partes[2], data_partes[1], data_partes[0]);
            return data;
        } 
    }

