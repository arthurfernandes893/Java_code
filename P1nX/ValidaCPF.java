public class ValidaCPF{
    //validacao e formatacao 

    //eh convertivel em cpf
    public static boolean isCPF(String scpf){ //assumir que esta sendo passado um cpf "limpo"//
        int i = 10; int somaaux =0; int soma = 0; //i-peso, soma-acumulavalores, somaaux-valor da rodada pra ser acumulado em soma//
        int location = 0;
        char firstdigit; char seconddigit; //10* e 11* digitos//
        if(scpf.equals("11111111111") || scpf.equals("22222222222") || scpf.equals("33333333333") 
        || scpf.equals("44444444444") || scpf.equals("55555555555") || scpf.equals("66666666666") 
        || scpf.equals("77777777777") || scpf.equals("88888888888") || scpf.equals("99999999999") 
        || scpf.equals("00000000000")|| scpf.length()!=11){
            return false;
        }
        else{
            //primeiro digito verificador//
            while(i>1){ 
            somaaux = ((scpf.charAt(location)-'0')*i);  // usando charAt pra já operar os valores inteiros dos caracteres//
            soma += somaaux;
            location += 1;
            i -= 1;
            }
            int digit1 = 11 - (soma%11);

            //verificacao de qual sera o digito verificador//
            if(digit1 == 10 || digit1 == 11){
                firstdigit = '0';
            }
            else{
                firstdigit = (char) (digit1 + '0');
            }


            //refazer o processo para o segundo digito verificador//
            location = 0;
            i = 11;
            soma = 0;
            while(i>1){ 
                somaaux = ((scpf.charAt(location)-'0')*i);
                soma += somaaux;
                location += 1;
                i -= 1;
            }
            int digit2 = 11 - (soma%11);

            //verificacao de qual sera o digito verificador//
            if(digit2 == 10 || digit2 == 11){
                seconddigit = '0';
            }
            else{
                seconddigit = (char) (digit2 + '0');
            }


            //posicoes 9 e 10 pq eh visto como array de char, logo, comeca de zero//
            if((firstdigit == scpf.charAt(9)) && (seconddigit == scpf.charAt(10))){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static long toIntCPF(String scpf){ //supor que sera passado uma string "limpa"//
        long intcpf;     
        if(scpf.equals("")){
            intcpf = 0;
        }
        else{  
            intcpf = Long.parseLong(scpf);
        }
       
        return intcpf;

    }

    
    public static String limpaCPF(String scpf){ 		
		String cleancpf="";
		String auxcpf = scpf.trim(); //eliminar espacos laterais//
        auxcpf = auxcpf.replaceAll("[\\s,.*]+", "-"); // substituir sinais de . por -//
        String cpf_parte[] = auxcpf.split("-"); //tokenizacao dos valores//
		
		for(String s : cpf_parte){ //criacao da string cpf so com valores dos digitos tokenizados//
			cleancpf = cleancpf +s;
		}
		
        return cleancpf; //retorna um cpf com 11 digitos//
    }

    
}
