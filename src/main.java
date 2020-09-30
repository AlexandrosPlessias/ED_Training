import domain.Spitter;
import domain.Spittle;
import repo.DBConnection;
import services.Service;
import services.SpitterServiceImpl;
import services.SpittleServiceImpl;

import java.sql.SQLException;
import java.sql.Date;


public class main {

    //TODO:
    // generics used removed Object----> [OK]
    // service check not Null  ---> [OK]
    // commit rollback ---> [OK]
    // db relation by ids ???? ask... (logika id manipulate by domain & tweet add owner.)

    public static void main(String[] args)  {

        try {
            // Disable Autocommit SQL's switch from TRUE (individual SQL STATEMENT committed auto)
            // to False for Education and Transaction pattern implementation (ACID aka ALL or NOTHING)
            // statement1 -> statement2 -> statement3 commit together as ONE in the end?
            DBConnection.getInstance().getConn().setAutoCommit(false);

            testEra();

            DBConnection.getInstance().closeAll();

        } catch (SQLException e) {
            System.err.print(e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.print(e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.print(e);
            e.printStackTrace();
        }


    }


    public static void testEra() throws SQLException, ClassNotFoundException, IllegalAccessException {

        // User creation.
        Spitter tempUser = new Spitter(8, "Alexdddas","a&12da345678", "maisl1@gmail.com", "Alex","fsd","Hello1 f Splitter.");

        //User's services check.
        Service userService = new SpitterServiceImpl();
        userService.create(tempUser);
        userService.read(tempUser);
        //userService.update(tempUser, "The new updated description.");
        //userService.delete(tempUser);

        System.out.println();

        // Tweet creation with date.
        Date date=Date.valueOf("2020-09-30");
        Spittle tempTweet = new Spittle(8, "Hellos world 176",date,156456.0534,654321.0897);
        //Tweet's services check.
        Service tweetService = new SpittleServiceImpl();
        tweetService.create(tempTweet);
        tweetService.read(tempTweet);
        //tweetService.update(tempTweet, "Hello new world");
        //tweetService.delete(tempTweet);

    }

}

    /*[A]tomicity means either all successful or none.
      [C]onsistency ensures bringing the database from one consistent state to another consistent state.
      [I]solation ensures that transaction is isolated from other transaction.
      [D]urability means once a transaction has been committed, it will remain so, even in the event of errors, power loss etc.
     */