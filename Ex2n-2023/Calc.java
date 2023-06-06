
public class Calc implements CalcInter{
    int a;
    int b;
    public Calc(int a, int b){
        this.a = a;
        this.b = b;
    }


    public   int soma(int a, int b) throws ErrParEx{
        if((a<1 || a>20) || (b<1 || b>20)){
            throw new ErrParEx(a,b,"soma");
        }
        else{
            return a+b;
        }
        
    }

    public int sub(int a, int b) throws ErrParEx {
        if((a<1 || a>20) || (b<1 || b>20)){
            throw new ErrParEx(a,b,"substracao");
        }
        else{
            return a-b;
        }
        
    }

    public double mult(double a, double b){
        return a*b;
    }

    public double div(double a, double b) throws Div0Ex{
        if(b == 0){
            throw new Div0Ex();
        }
        else{
            return a/b;
        }
        
    }

        

}