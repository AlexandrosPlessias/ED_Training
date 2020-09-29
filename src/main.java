import DomainClasses.Spitter;
import DomainClasses.Spittle;
import Service.Service;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
public class main {

    // JDBC driver name and database URL
    static final String  JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/spittr_db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ALEX123456";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {

            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Spitter";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("idSpitter");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", username: " + username);
                System.out.print(", password: " + password);
                System.out.print(", email: " + email);
                System.out.print(", firstName: " + firstName);
                System.out.print(", lastName: " + lastName + "\n");

            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        /* Test obj OK
        Spitter user1 = new Spitter("Alexpl","a12345678", "mail@gmail.com", "Alexandros","Plessias","Hello Splitter.");

        Spittle tweet1 = new Spittle("Hello 1",new Date(1992,7, 13),123456.00,654321.00);
        ArrayList<Spittle> tweets = new ArrayList<>();
        msg.add(tweet1);

        user1.setSpittleList(tweets);
        
        //Service.getInstance().createSpitter(add data);

        */



        // == DAY 2 ==
        // DriverManager.getConnection()
        // Service use DOA for CRUD.


    }

}
