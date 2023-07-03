import java.util.GregorianCalendar;

public class EmprestPara {
    private String codigoUsuario;
    GregorianCalendar dataEmprest;
    GregorianCalendar dataDevolv;
    
    public EmprestPara(String codigoUsuario, GregorianCalendar dataEmprest,GregorianCalendar dataDevolv){
        this.codigoUsuario = codigoUsuario;
        this.dataEmprest = dataEmprest;
        this.dataDevolv = dataDevolv;
    }
    
}
