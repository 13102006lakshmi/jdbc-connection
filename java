import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcConnectionDemo {
 public static void main(String[] args) {
 String url = "jdbc:mysql://localhost:3306/college";
 String user = "root";
 String password = "your_password";
 String sql = "SELECT id, name, department FROM student";
 try (Connection con =
 DriverManager.getConnection(url, user, password);
Statement st = con.createStatement();
 ResultSet rs = st.executeQuery(sql)) {
 System.out.println("Connected to database.");
 while (rs.next()) {
 System.out.println(
 rs.getInt("id") + " " +
 rs.getString("name") + " " +
 rs.getString("department"));
 }
 } catch (Exception e) {
 System.out.println("Database error: " + e.getMessage());
 }
 }
}
