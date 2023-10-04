import java.io.IOException;
import java.net.Socket;

public class initServer {
    public static void main(String[] args) {
        Servidor s = new Servidor();
        while(true){
            try{
                Socket cliente = s.server.accept();
                Thread t = new ThreadCliente(cliente, s);
                t.start();
            }catch(IOException e){
                System.out.println(e);
            }
        }   
    }
}
