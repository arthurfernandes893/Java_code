public class ValidaCPF{
    //validacao e formatacao 

    //eh convertivel em cpf?
    public static boolean isCPF(String scpf){
        /*if(){
        return true;
        }
        else{
            return false;
        }*/
        return false;
    }

    public static int toIntCPF(String scpf){
        int icpf;
        //percorrer a string vendo se ha pontos ou espacos e juntando tudo pra ter so numero//
        //converter
        icpf = Integer.parseInt(scpf);
        return icpf;

    }

    
    public static String limpaCPF(String scpf){ //usar replaceall()//
        String newcpf;
        //codigo pra limpar a String//
        return newcpf;
    
    }

    
}
