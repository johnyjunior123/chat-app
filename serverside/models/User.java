package models;

import java.io.PrintStream;

public class User {
    private String nomeUsuario;
    private PrintStream saida;

    public User(String nomeUsuario, PrintStream saida){
        this.nomeUsuario = nomeUsuario;
        this.saida = saida;
    }

    
    public void enviarMensagem(String mensagem){
        this.saida.println(mensagem);
    }
    
    public PrintStream getSaida(){
        return this.saida;
    }
    public String getNomeUsuario(){
        return this.nomeUsuario;
    }
    
}
