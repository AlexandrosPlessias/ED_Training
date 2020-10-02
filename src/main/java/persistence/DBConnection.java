package persistence;

import java.sql.DriverManager;
import java.sql.*;

public class DBConnection {

    // Singleton declare.
    private static DBConnection dbConnection;

    // JDBC driver name and database URL
    static final String  JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // old val for other "com.mysql.jdbc.Driver".
    static final String DB_URL = "jdbc:mysql://localhost:3306/spittr_db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "ALEX123456";

    Connection conn = null;
    Statement stmt = null;

    //private constructor.
    private DBConnection() throws SQLException,ClassNotFoundException {
        // STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection == null){ //if there is no instance available... create new one
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    // Get statement for requests and closing.
    public Statement getStmt() {
        return stmt;
    }

    // Get connection for closing.
    public Connection getConn() {return conn;}

    // Database closings.
    public void closeAll() throws SQLException {
        System.out.println("Statement closed...");
        stmt.close();
        System.out.println("Connection closed...");
        conn.close();
    }

}

    /* TRANSACTION:

        [A]tomicity means either all successful or none.
        [C]onsistency ensures bringing the database from one consistent state to another consistent state.
        [I]solation ensures that transaction is isolated from other transaction.
        [D]urability means once a transaction has been committed, it will remain so, even in the event of errors, power loss etc.
     */