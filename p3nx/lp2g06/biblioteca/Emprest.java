import java.util.GregorianCalendar;

public class Emprest {
    GregorianCalendar dataEmprest;
    GregorianCalendar dataDevolv;
    String codigoLivro;

    public Emprest(GregorianCalendar dataEmprest, String codigoLivro){
        this.dataEmprest = dataEmprest;
        this.codigoLivro = codigoLivro;
    }
}
