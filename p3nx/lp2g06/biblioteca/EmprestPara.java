package lp2g06.biblioteca;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmprestPara implements Serializable{
    private String codigoUsuario;
    public GregorianCalendar dataEmprest;
    public GregorianCalendar dataDevolv;
    
    public EmprestPara(String codigoUsuario, GregorianCalendar dataEmprest){
        this.codigoUsuario = codigoUsuario;
        this.dataEmprest = dataEmprest;
        this.dataDevolv =null;
    }
    
    public String getcoduser(){return codigoUsuario;}

    public String toString(){
        if(dataDevolv!=null){
             return "EMPRESTADO PARA: "+codigoUsuario+" || EM: "+dataEmprest.get(Calendar.DATE) +"/"+
        dataEmprest.get(Calendar.MONTH)+"/"+dataEmprest.get(Calendar.YEAR);
        }
        else{
             return "EMPRESTADO PARA: "+codigoUsuario+" || EM: "+dataEmprest.get(Calendar.DATE) +"/"+
        dataEmprest.get(Calendar.MONTH)+"/"+dataEmprest.get(Calendar.YEAR)+" || DEVOLDIVO EM: "+dataDevolv.get(Calendar.DATE) +"/"+
        dataDevolv.get(Calendar.MONTH)+"/"+dataDevolv.get(Calendar.YEAR);
        }
       
    }

}
