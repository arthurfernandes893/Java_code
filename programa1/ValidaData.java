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
        
            public static Boolean checkMonth(int month){
                if(month>12 && month<1){
                    return false;
                }
                else{
                    return true;
                    }
            }
            public static Boolean checkYear(int year){
                if(year<1920 && year>2023){ //o limite eh o ano corrente?//
                    return false;
                }
                else{
                    return true;
                    }
            
            }
        }

