import java.util.*;
import java.io.*;
import bmibank.*;
public class P4nX{
    public static final String empty = "";
    public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9'){
                ehnum = false;
                if((arg.charAt(location)) == '.' && location<(arg.length()-1)){ //se for o caracter de ponto, volta a ser verdadeiro, pois indica um float//
                    ehnum = true;
                }
            }
        }
        return ehnum;
    }
   

    public static void main(String[] args){
        //criacao do arraylist//
        MinhaListaOrdenavel array = new MinhaListaOrdenavel();
        for(int i = 0;i<10;i++){
            array.cirapreset(i);
        }
        MLOGui screen = new MLOGui(array);

    }
}