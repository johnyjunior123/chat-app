public class tratarMensagem {
    public static String formatarMinha(String mensagem){
        mensagem = criarData.criar().toString() + "#" + mensagem;
        String[] tratada = mensagem.split("#",2);
        return String.format("\n[ %s ] Eu: %s", tratada[0], tratada[1]);
    }

    public static String formatarRecebidoDeOutros(String mensagem){
        String[] tratada = mensagem.split("#",3);
        return String.format("\n[ %s ] %s: %s", tratada[0], tratada[1], tratada[2]);
    }

    public static String formatarParaEnviar(String nomeUsuario, String mensagem){
        mensagem = criarData.criar().toString() + "#" + nomeUsuario + "#" + mensagem;
        return mensagem;
    }
}
