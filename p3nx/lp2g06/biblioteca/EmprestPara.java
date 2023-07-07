package lp2g06.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
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

}
