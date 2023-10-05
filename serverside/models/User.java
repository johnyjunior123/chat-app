package models;

import java.io.PrintStream;
import java.util.ArrayList;

public class User {
    private String nomeUsuario;
    private PrintStream saida;

    public User(String nomeUsuario, PrintStream saida){
        this.nomeUsuario = nomeUsuario;
        this.saida = saida;
    }
    
}
