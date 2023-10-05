import java.net.Socket;

import models.Mensagem;
import utils.criarData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class ThreadCliente extends Thread{
    private Socket cliente;
    private InputStreamReader entrada;
    private BufferedReader entradaTexto;
    private Servidor server;
    private PrintStream saida;

    public ThreadCliente(Socket cliente, Servidor server){
        try{
            this.cliente = cliente;
            this.server = server;
            this.entrada = new InputStreamReader(this.cliente.getInputStream());
            this.entradaTexto = new BufferedReader(entrada);
            this.saida = new PrintStream(this.cliente.getOutputStream());
            this.server.addCliente(this.saida);
            System.out.println("quantidade de usuarios ativos: " + this.server.qntdClientes());
            
        }catch(IOException e){
            System.out.println(e);
        }
    }

    
    public void run(){
        try{
            String conteudo = "";
            // System.out.println(this.entradaTexto.re  adLine());
            while(!"Sair".equalsIgnoreCase(conteudo) && conteudo != null){
                conteudo = this.entradaTexto.readLine();
                this.server.enviarParaTodos(this.saida, conteudo);
            }
        }catch(IOException e){
            System.out.println(e);
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saida);  
        }catch(Error e){
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saida);        }
    }
}
