import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor{
    public ServerSocket server;
    private ArrayList<PrintStream>clientes;

    public Servidor(){
        try{
            clientes = new ArrayList<PrintStream>();
            server = new ServerSocket(3000);
            System.out.println("Configurado porta:3000");
            InetAddress inet = this.server.getInetAddress();
            System.out.println(inet.getHostName());
            System.out.println(inet.getHostAddress());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void listen(){
        try{
            
            while(true){
                Socket cliente = this.server.accept();
                Thread t = new ThreadCliente(cliente, this);
                t.run();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            System.out.println("Encerrando servidor..."); 
            server.close();      
            System.out.println("Servidor encerrado");
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void addCliente(PrintStream saida){
        this.clientes.add(saida);
    }

    public void removeCliente(PrintStream saida){
        this.clientes.remove(saida);
    }
    
    public void enviarParaTodos(PrintStream remetente, String mensagem){
        for(PrintStream cliente : this.clientes){
            if(cliente != remetente){
                cliente.println(mensagem);
            }
        }
    }

    public int qntdClientes(){
        return this.clientes.size();
    }
}

