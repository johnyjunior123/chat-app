package models;
import java.sql.Date;

public abstract class Mensagem{
    protected Date data;
    protected String content = null;
    
    public Date getData(){
        return this.data;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String toString(){
        // data/conteudo/arquivo
        return String.format("%s#%s", this.data.toString(), this.content);
    }
}
