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
        Spitter tempUser = new Spitter("kghkjh","a&kghjghkh", "yahoo123@gmail.com", "fanis","lamp","Splitter gdfgfd");

        //User's services check.
        Service userService = new SpitterServiceImpl();
        //userService.create(tempUser);
        Spitter readedUser = (Spitter) userService.read(14L);
        if (readedUser != null) System.out.println(readedUser.toString());
        //userService.update(14L, "The new updated2 description.");
        //System.out.println(userService.delete(100L));
        //tempUser.toString();

        //System.out.println();

        //Tweet creation with date.
        Date date=Date.valueOf("2020-10-01");
        Spittle tempTweet = new Spittle("Hellos jhg 18546",date,158.53,6547.09, 14L);

        //Tweet's services check.
        Service tweetService = new SpittleServiceImpl();

        //tweetService.create(tempTweet);
        Spittle readedTweer = (Spittle) tweetService.read(10L);
        if (readedTweer != null) System.out.println(readedTweer.toString());
        //tweetService.update(14L, "Hello new world");
        //System.out.println(tweetService.delete(14L);
        //tempTweet.toString();

    }

}
