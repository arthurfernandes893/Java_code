import java.io.Serializable;
import java.util.GregorianCalendar;

public class Emprest implements Serializable{
    GregorianCalendar dataEmprest;
    GregorianCalendar dataDevolv;
    String codigoLivro;

    public Emprest(GregorianCalendar dataEmprest, String codigoLivro){
        this.dataEmprest = dataEmprest;
        this.codigoLivro = codigoLivro;
    }
}
