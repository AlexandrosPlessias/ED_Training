import domain.Spitter;
import domain.Spittle;
import repo.DBConnection;
import services.Service;
import services.SpitterServiceImpl;
import services.SpittleServiceImpl;

import java.sql.SQLException;
import java.sql.Date;


public class main {


    public static void main(String[] args) {

        try {

            testEra();

        } catch (SQLException | ClassNotFoundException throwable) {
            System.err.println(throwable);
            throwable.printStackTrace();
        }

    }


    public static void testEra() throws SQLException, ClassNotFoundException {

        // User creation.
        Spitter tempUser = new Spitter("Nikos_mvp","a&12345678", "mail@gmail.com", "Vasilis","NIkodimos","Hello f Splitter.");
        //User's services check.
        Service userService = new SpitterServiceImpl();
        userService.create(tempUser);
        userService.read(tempUser);
        userService.update(tempUser, "The new updated description.");
        userService.delete(tempUser);

        System.out.println();

        // Tweet creation with date.
        Date date=Date.valueOf("2020-05-09");
        Spittle tempTweet = new Spittle("Hellos world 1",date,123456.0000,654321.0000);
        //Tweet's services check.
        Service tweetService = new SpittleServiceImpl();
        tweetService.create(tempTweet);
        tweetService.read(tempTweet);
        tweetService.update(tempTweet, "Hello new world");
        tweetService.delete(tempTweet);

        // Database closings.
        System.out.println("Statement closed...");
        DBConnection.getInstance().getStmt().close();
        System.out.println("Connection closed...");
        DBConnection.getInstance().getConn().close();

    }

}