public class ValidaData{ //porque esta errado??//
        // metodos recebendo a data como int//
        public static Boolean isDay(int day){
            if(day>31 && day <1){
                return false;
            }
            else{
            return true;
            }
        }
        
        public static Boolean isMonth(int month){
            if(month>12 && month<1){
                return false;
            }
            else{                    
                return true;
            }
        }
            
        public static Boolean isYear(int year){
            if(year<1920 && year>2023){ //o limite eh o ano corrente?//
                return false;
            }
            else{
                return true;
                }
        }

        public static int[] criadata1(String sdata){
            int[] datacerta = new int[3];
            String partes = "";
            char[] charaux = sdata.toCharArray();
            partes = String.copyValueOf(charaux,0,2); //usa String. no começom pelo msm motivo dos parses. sao metodos static das classes String,Integer, etc//
            datacerta[0] = Integer.parseInt(partes);
                
            partes = String.copyValueOf(charaux,3,2);
            datacerta[1] = Integer.parseInt(partes);
                
            partes = String.copyValueOf(charaux,5,4);
            datacerta[2] = Integer.parseInt(partes);

            return datacerta;
            }
    }

