package company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    public  Connection connection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String userName = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
