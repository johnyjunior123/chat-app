public class App {
    public static void main(String[] args) {
        Servidor s = new Servidor(null);
        while(true){
            s.listen();
        }   
    }
}
