import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class InitClient {
    public static void main(String[] args) {
        try{
            Socket cliente = new Socket("127.0.0.1", 3000);
            telaCliente tela = new telaCliente(cliente);
            Thread t = new Listen(cliente, tela);
            t.start();
            tela.setVisible(true);
        }catch(IOException e){
            System.out.println(e);
        }
    }   
}
