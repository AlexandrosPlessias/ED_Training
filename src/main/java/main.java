import spittr.config.SpittrWebAppInitializer;
import spittr.config.TrainingConfig;
import spittr.domain.Spitter;
import spittr.domain.Spittle;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spittr.services.Service;
import spittr.services.SpitterServiceImpl;
import spittr.services.SpittleServiceImpl;


import java.sql.SQLException;


public class main {


    public static void main(String[] args)  {


        try {
            // Disable Autocommit SQL's switch from TRUE (individual SQL STATEMENT committed auto)
            // to False for Education and Transaction pattern implementation (ACID aka ALL or NOTHING)
            // statement1 -> statement2 -> statement3 commit together as ONE in the end?
            //DBConnection.getInstance().getConn().setAutoCommit(false);

            ApplicationContext context = new AnnotationConfigApplicationContext(TrainingConfig.class);

            testUser(context);
            System.out.println();
            testTweets(context);

            //DBConnection.getInstance().closeAll();

            System.exit(0);

        } catch (SQLException sqlException) {
            System.err.print(sqlException);
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.print(classNotFoundException);
            classNotFoundException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            System.err.print(illegalAccessException);
            illegalAccessException.printStackTrace();
        }


    }


    public static void testUser(ApplicationContext context) throws IllegalAccessException, SQLException, ClassNotFoundException {

        // -------------User creation.---------
        //Spitter tempUser = new Spitter("Alexpl","alex123456", "alex@gmail.com","alex","ples","hidernater");

        //User's services check.
        Service userService = context.getBean(SpitterServiceImpl.class);

        // User's CRUD testing.
        //userService.create(tempUser);
        Spitter user14 = (Spitter) userService.read(26L);
        if (user14 != null) System.out.println(user14.toString());
        //userService.update(2L, "The new hibernate updated description.");
        //System.out.println(userService.delete(tempUser));

    }


    public static void testTweets(ApplicationContext context) throws IllegalAccessException, SQLException, ClassNotFoundException {

        //----------------Tweet creation with date.---------------
        //Date date=Date.valueOf("2020-10-02");
        //Spittle tempTweet = new Spittle("Hello Hibernate.",date,158.53,6547.09, 14L);

        //Tweet's services check.
        Service tweetService = context.getBean(SpittleServiceImpl.class);

        // Tweet's CRUD testing.

        //tweetService.create(tempTweet);
        Spittle readedTweer = (Spittle) tweetService.read(20L);
        if (readedTweer != null) System.out.println(readedTweer.toString());
        //tweetService.update(17L, "Hello new world");
        //System.out.println(tweetService.delete(tempTweet));

    }


}
