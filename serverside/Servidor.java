import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import models.User;

public class Servidor{
    public ServerSocket server;
    private ArrayList<User>clientes;

    public Servidor(String ip_bind){
        try{
            clientes = new ArrayList<User>();
            server = new ServerSocket(3000);
            if(ip_bind != null){
                server.bind(new InetSocketAddress(ip_bind, 3000));
            }
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
                t.start();
                System.out.println("quantidade de usuarios ativos: " + qntdClientes());
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

    public void addCliente(String user, PrintStream saida){
        User cliente = new User(user, saida);
        this.clientes.add(cliente);
    }

    public void removeCliente(PrintStream saida){
        for(User cliente : this.clientes){
            if(cliente.getSaida() == saida){
                this.clientes.remove(cliente);
            }
        }
    }

    public void enviarMensagemPrivada(PrintStream remetente, String mensagem){
        String[] tratamento = mensagem.split("#", 4);
        for(User cliente : this.clientes){
            if(cliente.getSaida() != remetente && cliente.getNomeUsuario().equals(tratamento[2])){
                cliente.enviarMensagem(mensagem);
            }
        }
    }
    
    public void enviarParaTodos(PrintStream remetente, String mensagem){
        for(User cliente : this.clientes){
            if(cliente.getSaida() != remetente){
                cliente.enviarMensagem(mensagem);
            }
        }
    }

    public int qntdClientes(){
        return this.clientes.size();
    }
}

