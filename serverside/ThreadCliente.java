import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ThreadCliente extends Thread{
    private Servidor server;
    private Socket cliente;
    private InputStreamReader entrada;
    private BufferedReader entradaTexto;
    private PrintStream saida;

    public ThreadCliente(Socket cliente, Servidor server){
        try{
            this.cliente = cliente;
            this.server = server;
            this.entrada = new InputStreamReader(this.cliente.getInputStream());
            this.entradaTexto = new BufferedReader(entrada);
            this.saida = new PrintStream(this.cliente.getOutputStream());
            String nomeUsuario = this.entradaTexto.readLine();
            this.server.addCliente(nomeUsuario, this.saida);
            System.out.println(nomeUsuario + " conectado");
            
        }catch(IOException e){
            System.out.println(e);
        }
    }

    
    public void run(){
        try{
            String conteudo = "";
            while(!"Sair".equalsIgnoreCase(conteudo) && conteudo != null){
                conteudo = this.entradaTexto.readLine();
                System.out.println(conteudo);
                if(conteudo.startsWith("!")){
                    System.out.println(conteudo);
                    this.server.enviarMensagemPrivada(saida, conteudo);
                }else{
                    this.server.enviarParaTodos(this.saida, conteudo);
                }
            }
        }catch(IOException e){
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saida);  
        }catch(Error e){
            System.out.println("cliente desconectado");
            this.server.removeCliente(this.saida);
        }
    }
}
