package services;

import java.sql.DriverManager;
import java.sql.*;

public class MyQueryExecuter {

    // JDBC driver name and database URL
    static final String  JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spittr_db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ALEX123456";

    Connection conn = null;
    Statement stmt = null;

    // from costructor to method anr run method return resultset.
    public MyQueryExecuter(String sql) throws SQLException,ClassNotFoundException {
        // STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        this.stmt = this.conn.createStatement();

        ResultSet results = this.stmt.executeQuery(sql);

        // STEP 5: Extract data from result set
        while(results.next()){
            //Retrieve by column name
            String desc  = results.getString("description");
            String user = results.getString("username");

            //Display values
            System.out.print("user: " + user);
            System.out.print(", desc: " + desc + "\n");
        }
        results.close();
        stmt.close();
        conn.close();

    }


}
