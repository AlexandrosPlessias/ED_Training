import services.MyQueryExecuter;
import domain.Spitter;
import domain.Spittle;

import java.sql.*;
import java.text.DateFormat;

public class main {


    // TRANSATIONS SERVICES....
    // change service.....

    public static void main(String[] args) {


        try {

            // Create and establish connection.
            String sql= "SELECT * FROM Spitter";
            MyQueryExecuter myQueryExecuter = new MyQueryExecuter(sql);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException ce){
            ce.printStackTrace();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }


        Spitter tempUser = new Spitter("Vasilis_ssd","a^&12345678", "mail@gmail.com", "Vasilis","NIkodimos","Hello f Splitter.");

        Spittle tempTweet = new Spittle("Hello temp",new Date(2020,07,13),123456.00,654321.00);

        





        // == DAY 2 ==
        // DriverManager.getConnection()
        // Service use DOA for CRUD.


    }

}
