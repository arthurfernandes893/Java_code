import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EmprestPara implements Serializable{
    private String codigoUsuario;
    GregorianCalendar dataEmprest;
    GregorianCalendar dataDevolv;
    
    public EmprestPara(String codigoUsuario, GregorianCalendar dataEmprest,GregorianCalendar dataDevolv){
        this.codigoUsuario = codigoUsuario;
        this.dataEmprest = dataEmprest;
        this.dataDevolv = dataDevolv;
    }
    
    public String getcoduser(){return codigoUsuario;}

}
