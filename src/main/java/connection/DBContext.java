package context;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    protected Connection connection;

    private final String servername = "localhost";
    private final String dbName = "bookingProject";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "duyhai037";

    public Connection getConnection() throws Exception {
        try {
            String url = "jdbc:sqlserver://" + servername + ":" + portNumber + "\\" + instance + ";databaseName="
                    + dbName + ";encrypt=true;trustServerCertificate=true";
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + servername + ":" + portNumber + ";databaseName=" + dbName
                        + ";encrypt=true;trustServerCertificate=true";
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
