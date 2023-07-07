package lp2g06.biblioteca;
public class NenhumaCopiaEmprestadaEx extends Exception {
    int emprestados;
    int quant;

    public NenhumaCopiaEmprestadaEx(int emprestados, int quant){
        this.emprestados = emprestados;
        this. quant = quant;
    }

    public String toString(){
        return "Erro: "+emprestados+" Livros emprestados e "+quant+" livros em estoque.\nNENHUMA COPIA EMPRESTADA.\nImpossivel concluir acao";
    }
}
