package models;

import java.sql.Date;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(Date data, String content){  
        this.content = content;
        this.data = data;
    }
    
}
