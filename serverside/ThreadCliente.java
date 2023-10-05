import java.net.Socket;

import models.Mensagem;
import utils.criarData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ThreadCliente extends Thread{
    private Socket cliente;
    private InputStreamReader entrada;
    private BufferedReader entradaTexto;
    private Servidor server;
    private OutputStreamWriter saida;
    private BufferedWriter saidaTexto;

    public ThreadCliente(Socket cliente, Servidor server){
        try{
            this.cliente = cliente;
            this.server = server;
            this.entrada = new InputStreamReader(this.cliente.getInputStream());
            this.entradaTexto = new BufferedReader(entrada);
            this.saida = new OutputStreamWriter(this.cliente.getOutputStream());
            this.saidaTexto = new BufferedWriter(saida);
            this.server.addCliente(this.saidaTexto);
            System.out.println("quantidade de usuarios ativos: " + this.server.getClientes().size());
            
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
                this.server.enviarParaTodos(this.saidaTexto, conteudo);
            }
        }catch(IOException e){
            System.out.println(e);
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saidaTexto);  
        }catch(Error e){
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saidaTexto);        }
    }
}
