import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Write {
    
    public static void write(Socket cliente, String mensagem){
        try{
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println(mensagem);
            saida.flush();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
