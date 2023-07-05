public class LivroNaoCadastradoEx extends Exception {
    String cod;

    public LivroNaoCadastradoEx(String cod){
        this.cod = cod;
    }

    public String toString(){
        return "Erro: O livro com o codigo: "+cod+" nao esta relacionado a nenhum livro da base de dados.";
    }
}
