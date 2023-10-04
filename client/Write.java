import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Write {
    
    public static void write(Socket cliente){
        try{
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            // Mensagem msg = new Mensagem(criarData.criar(), "ola tudo bem?");
            // saida.print(msg);
            Scanner escritor = new Scanner(System.in);
            while(escritor.hasNextLine()){
                saida.println(escritor.nextLine());
            }
            escritor.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
