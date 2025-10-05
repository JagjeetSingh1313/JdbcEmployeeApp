import java.sql.*;

public class JdbcReadEmployee {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your DB name
        String username = "your_username"; // Replace with MySQL username
        String password = "your_password"; // Replace with MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database.");

            String sql = "SELECT * FROM Employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("EmpID\tName\t\tSalary");
            System.out.println("-----\t--------\t------");
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");

                System.out.printf("%d\t%s\t\t%.2f\n", id, name, salary);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }
}
