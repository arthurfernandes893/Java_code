public class CopiaNaoDisponivelEx extends Exception {
    int emprestados;
    int quant;

    public CopiaNaoDisponivelEx(int emprestados, int quant){
        this.emprestados = emprestados;
        this. quant = quant;
    }

    public String toString(){
        return "Erro: "+emprestados+" Livros emprestados e "+quant+" livros em estoque.\nTODAS AS COPIAS EMPRESTADAS.\nImpossivel concluir acao";
    }   
}
