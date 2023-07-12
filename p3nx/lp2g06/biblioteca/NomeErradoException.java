package lp2g06.biblioteca;
import java.io.*;

public class NomeErradoException extends IOException {
    String m;String word;

    public NomeErradoException(String m){
        this.m = m;
    }

    
}

