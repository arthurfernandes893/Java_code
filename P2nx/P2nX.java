import java.util.*;
import java.io.*;
public class P2nX{
    public static final String empty = "";
    public static Boolean checkString(String arg){ // metodo pra verificar strings como idade e cpf se estão apenas com caractefes numericos//
        arg = arg.trim();
        Boolean ehnum = true;
        for(int location = 0; location<arg.length();location++){
            if((arg.charAt(location)) < '0' || (arg.charAt(location)) > '9' || (arg.charAt(location))!= '.'){
                ehnum = false;
            }
        }
        return ehnum;
    }
    public static void main(String[] args){

    }
}