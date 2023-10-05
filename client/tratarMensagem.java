import java.util.ArrayList;

public class tratarMensagem {
    public static String formatar(String mensagem){
        Mensagem m = new Mensagem(criarData.criar(), mensagem);
        mensagem = m.toString();
        String[] tratada = mensagem.split("#",3);
        String mensagemTratada = "\n["+ tratada[0] + "] Eu: " + tratada[2];
        return mensagemTratada;
    }
}
