package lp2g06.biblioteca;

public class UsuarioNaoCadastradoEx extends Exception{
    String cod;

    public UsuarioNaoCadastradoEx(String cod){
        this.cod = cod;
    }

    public String toString(){
        return "Erro: o codigo "+cod+" nao esta relacionado a nenhum usuario cadastrado";
    }
}
