

import models.MensagemDirecionada;
import utilidades.criarData;

public class tratarMensagem {
    public static String formatarMinha(String mensagem){
        mensagem = criarData.criar().toString() + "#" + mensagem;
        String[] tratada = mensagem.split("#",2);
        return String.format("\n[ %s ] Eu: %s", tratada[0], tratada[1]);
    }

    public static String formatarMinhaPrivado(MensagemDirecionada mensagem){
        String m = mensagem.toString();
        String[] tratada = m.split("#",4);
        return String.format("\n[ %s ] # Para: %s # Eu: %s", tratada[0], tratada[2], tratada[3]);
    }

    public static String formatarRecebidoDeOutros(String mensagem){
        String[] tratada = mensagem.split("#",3);
        return String.format("\n[ %s ] %s: %s", tratada[0], tratada[1], tratada[2]);
    }

    public static String formatarParaEnviar(String nomeUsuario, String mensagem){
        mensagem = criarData.criar().toString() + "#" + nomeUsuario + "#" + mensagem;
        return mensagem;
    }

    public static String formatarRecebidoPrivado(String mensagem){
        String[] tratada = mensagem.split("#",4);
        return String.format("\n[ %s ]# Privado # %s: %s", tratada[0], tratada[1], tratada[3]);
    }
}
