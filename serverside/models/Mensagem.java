package models;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;

public class Mensagem implements Serializable{
    // atribbuttes
    private Date date;
    private String content = null;
    private InputStream archive = null;

    public Mensagem(Date date, String content, InputStream archive) {
        if(date == null) throw new Error("Mensagem deve ter uma data");
        // if(date.getTime() < System.currentTimeMillis()) throw new Error("data invalida");
        if(content == null && archive == null) throw new Error("Tem que ter um arquivo ou mensagem");
        if(content.length() < 1) throw new Error("Deve possuí uma mensagem");
        this.date = date;
        this.content = content;
        this.archive = archive;
    }

    public Mensagem(Date date, String content) {
        if(date == null) throw new Error("Mensagem deve ter uma data");
        if(content == null || content.length() < 1) throw new Error("Deve possuír uma mensagem");
        this.date = date;
        this.content = content;
    }

    public Mensagem(Date date, InputStream archive) {
        if(date == null) throw new Error("Mensagem deve ter uma data");
        if(archive == null) throw new Error("Tem que ter um arquivo");
        this.date = date;
        this.archive = archive;
    }

    public int ishasarchive(){
        if (this.archive == null) return -1; 
        return 0;
    }

    public String toString(){
        // data/conteudo/arquivo
        return String.format("#%s#\n#%s\n#%s", this.date,this.archive, this.content);
    }
}
