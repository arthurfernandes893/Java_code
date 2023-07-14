package lp2g06.biblioteca;

import java.io.Serializable;
import java.util.Calendar;
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

    public String toString(){
        if(dataDevolv!=null){
             return "CODIGO: "+codigoLivro+" || EM: "+dataEmprest.get(Calendar.DATE) +"/"+
        dataEmprest.get(Calendar.MONTH)+"/"+dataEmprest.get(Calendar.YEAR);
        }
        else{
             return "CODIGO: "+codigoLivro+" || EM: "+dataEmprest.get(Calendar.DATE) +"/"+
        dataEmprest.get(Calendar.MONTH)+"/"+dataEmprest.get(Calendar.YEAR)+" || DEVOLDIVO EM: "+dataDevolv.get(Calendar.DATE) +"/"+
        dataDevolv.get(Calendar.MONTH)+"/"+dataDevolv.get(Calendar.YEAR);
        }
       
    }
}
