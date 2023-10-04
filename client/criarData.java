import java.sql.Date;

public class criarData {
    public static Date criar(){
        Date data = new Date(System.currentTimeMillis());
        return data;
    }
}
