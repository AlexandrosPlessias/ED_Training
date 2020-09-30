package services;

import java.sql.DriverManager;
import java.sql.*;

public class QueryExecuter {

    // JDBC driver name and database URL
    static final String  JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spittr_db";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "ALEX123456";

    Connection conn = null;
    Statement stmt = null;

    public QueryExecuter() throws SQLException,ClassNotFoundException {
        // STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
    }

    public Statement getStmt() {
        return stmt;
    }

    public void closing() throws SQLException {
        stmt.close();
        conn.close();
    }
}
