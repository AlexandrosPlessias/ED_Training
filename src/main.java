import domain.Spitter;
import domain.Spittle;
import repo.DBConnection;
import services.Service;
import services.SpitterServiceImpl;
import services.SpittleServiceImpl;

import java.sql.SQLException;
import java.sql.Date;


public class main {


    public static void main(String[] args)  {

        try {
            // Disable Autocommit SQL's switch from TRUE (individual SQL STATEMENT committed auto)
            // to False for Education and Transaction pattern implementation (ACID aka ALL or NOTHING)
            // statement1 -> statement2 -> statement3 commit together as ONE in the end?
            DBConnection.getInstance().getConn().setAutoCommit(false);

            testEra();
        } catch (SQLException e) {
            System.err.print(e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.print(e);
            e.printStackTrace();
        }


    }


    public static void testEra() throws SQLException, ClassNotFoundException {

        // User creation.
        Spitter tempUser = new Spitter("Nikos_mvp","a&12345678", "mail@gmail.com", "Vasilis","NIkodimos","Hello f Splitter.");
        //User's services check.
        Service userService = new SpitterServiceImpl();
        userService.create(tempUser);
        //userService.read(tempUser);
        //userService.update(tempUser, "The new updated description.");
        //userService.delete(tempUser);

        DBConnection.getInstance().getConn().commit();

        System.out.println();

        // Tweet creation with date.
        Date date=Date.valueOf("2020-05-09");
        Spittle tempTweet = new Spittle("Hellos world 1",date,123456.0000,654321.0000);
        //Tweet's services check.
        Service tweetService = new SpittleServiceImpl();
        tweetService.create(tempTweet);
        //tweetService.read(tempTweet);
        //tweetService.update(tempTweet, "Hello new world");
        //tweetService.delete(tempTweet);

        // Database closings.
        System.out.println("Statement closed...");
        DBConnection.getInstance().getStmt().close();
        System.out.println("Connection closed...");
        DBConnection.getInstance().getConn().close();

    }

}

    /*[A]tomicity means either all successful or none.
      [C]onsistency ensures bringing the database from one consistent state to another consistent state.
      [I]solation ensures that transaction is isolated from other transaction.
      [D]urability means once a transaction has been committed, it will remain so, even in the event of errors, power loss etc.
     */