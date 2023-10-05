import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor{
    public ServerSocket server;
    private ArrayList<BufferedWriter>clientes;

    public Servidor(){
        try{
            clientes = new ArrayList<BufferedWriter>();
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

    public void addCliente(BufferedWriter bfw){
        this.clientes.add(bfw);
    }

    public void removeCliente(BufferedWriter bfw){
        this.clientes.remove(bfw);
    }
    
    public void enviarParaTodos(BufferedWriter remetente, String mensagem){
        for(BufferedWriter cliente : this.clientes){
            try{
                cliente.write(mensagem);
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }

    public 

    public ArrayList<BufferedWriter> getClientes(){
        return this.clientes;
    }
}

