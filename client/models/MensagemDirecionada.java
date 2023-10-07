package models;

import java.sql.Date;

public class MensagemDirecionada extends Mensagem{
    private String remetente;
    private String destinatario;

    public MensagemDirecionada(Date data, String content,String remetente, String destinatario){  
        this.content = content;
        this.data = data;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String getRemetente(){
        return this.remetente;
    }

    public String getDestinatario(){
        return this.destinatario;
    }

    @Override
    public String toString(){
        // data/conteudo/arquivo
        return String.format("!%s#%s#%s#%s", this.data.toString(), this.remetente, this.destinatario,this.content);
    }
}
