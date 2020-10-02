import domain.Spitter;
import domain.Spittle;
import persistence.DBConnection;
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
            //DBConnection.getInstance().getConn().setAutoCommit(false);

            testEra();

            //DBConnection.getInstance().closeAll();

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

        // -------------User creation.---------
        //Spitter tempUser = new Spitter("Hidernate new entry23","hidernatehjghk32h", "hiderna32te@gmail.com","hidern32ate","hid32ernate2","hidernate32");

        //User's services check.
        //Service userService = new SpitterServiceImpl();

        // User's CRUD testing.

        //userService.create(tempUser);
        //Spitter user14 = (Spitter) userService.read(16L);
        //if (user14 != null) System.out.println(user14.getUsername());
        //userService.update(2L, "The new hibernate updated description.");
        //System.out.println(userService.delete(tempUser));



        //----------------Tweet creation with date.---------------
        Date date=Date.valueOf("2020-10-01");
        Spittle tempTweet = new Spittle("Hellos jhg 18546",date,158.53,6547.09, 14L);

        //Tweet's services check.
        Service tweetService = new SpittleServiceImpl();

        // Tweet's CRUD testing.

        //tweetService.create(tempTweet);
        //Spittle readedTweer = (Spittle) tweetService.read(11L);
        //if (readedTweer != null) System.out.println(readedTweer.toString());
        //tweetService.update(17L, "Hello new world");
        //System.out.println(tweetService.delete(tempTweet));

    }

}
