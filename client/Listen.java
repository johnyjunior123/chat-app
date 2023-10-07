import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Listen extends Thread{
    private Socket cliente;
    private InputStreamReader entrada;
    private BufferedReader entradaTexto;
    private telaCliente tela;

    public Listen(Socket cliente, telaCliente tela){
        try{
            this.cliente = cliente;
            this.entrada = new InputStreamReader(this.cliente.getInputStream());
            this.entradaTexto = new BufferedReader(entrada);
            this.tela = tela;
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
                    tela.renderizarOutrasMensagensPrivadas(conteudo);
                }else{
                    tela.renderizarOutrasMensagens(conteudo);
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
