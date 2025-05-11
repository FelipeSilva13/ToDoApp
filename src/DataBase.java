
import java.sql.*;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/tarefas_db";
    private static final String USER = "root";
    private static final String PASSWORD = "F&lipe87"; // substitua aqui

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addTask(String description) {
        String sql = "INSERT INTO tasks (description, is_done) VALUES (?, false)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listTasks() {
        String sql = "SELECT id, description, is_done FROM tasks";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String status = rs.getBoolean("is_done") ? "[X]" : "[ ]";
                System.out.printf("%d. %s %s%n", rs.getInt("id"), status, rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void markTaskDone(int id) {
        String sql = "UPDATE tasks SET is_done = true WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
