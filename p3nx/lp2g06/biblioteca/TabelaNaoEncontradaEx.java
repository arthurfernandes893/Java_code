package lp2g06.biblioteca;

public class TabelaNaoEncontradaEx extends Exception{
    String filename;

    public TabelaNaoEncontradaEx(String file_name){
        this.filename = file_name;
    }

    public String toString(){
        return "Nao foi possivel abrir base de dados selecionada\n"+"NOME:"+filename;
    }
}
