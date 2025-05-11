import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConnection {

    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/tarefas_db";
            String user = "root";
            String password = "F&lipe87";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas_db", "root", "F&lipe87")) {
                System.out.println("Conexão com MySQL feita com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
