package lp2g06.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Emprest implements Serializable{
    public GregorianCalendar dataEmprest;
    public GregorianCalendar dataDevolv;
    String codigoLivro;

    public Emprest(GregorianCalendar dataEmprest, String codigoLivro){
        this.dataEmprest = dataEmprest;
        this.codigoLivro = codigoLivro;
        this.dataDevolv = null;
    }
}
