import java.util.GregorianCalendar;

public class EmprestPara {
    private int codigoUsuario;
    GregorianCalendar dataEmprest;
    GregorianCalendar dataDevolv;
    
    public EmprestPara(int codigoUsuario, GregorianCalendar dataEmprest,GregorianCalendar dataDevolv){
        this.codigoUsuario = codigoUsuario;
        this.dataEmprest = dataEmprest;
        this.dataDevolv = dataDevolv;
    }
    
}
