import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class InitClient {
    public static void main(String[] args) {
        try{
            Socket cliente = new Socket("127.0.0.1", 3000);
            Write.write(cliente);
            cliente.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }   
}