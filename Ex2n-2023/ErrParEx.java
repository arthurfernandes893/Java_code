public class ErrParEx extends Exception{
    int a;
    int b;
    String operacao;
    public ErrParEx(int a, int b, String operacao){
        this.a = a;
        this.b =b;
        this.operacao = operacao;
    }
    public String toString(){
        return "ErrParEx Exception nos parametros " + a + " e "+ b + " e na operacao " + operacao;
    }
}
