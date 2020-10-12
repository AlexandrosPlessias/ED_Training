
//import spittr.config.TrainingConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spittr.config.JPAconfig;
import spittr.domain.Spitter;
import spittr.domain.Spittle;
import spittr.repositories.SpitterRepository;
import spittr.services.Service;
import spittr.services.SpitterServiceImpl;
import spittr.services.SpittleServiceImpl;


import java.sql.Date;
import java.sql.SQLException;

public class main {



    public static void main(String[] args)  {


        // Disable Autocommit SQL's switch from TRUE (individual SQL STATEMENT committed auto)
        // to False for Education and Transaction pattern implementation (ACID aka ALL or NOTHING)
        // statement1 -> statement2 -> statement3 commit together as ONE in the end?
        //DBConnection.getInstance().getConn().setAutoCommit(false);

        //ApplicationContext context = new AnnotationConfigApplicationContext(TrainingConfig.class);

        //testUser();
        //System.out.println();
        //testTweets();

        //DBConnection.getInstance().closeAll();

    }


    public static void testUser()  {

        // -------------User creation.---------
        //Spitter tempUser = new Spitter("AlexplJPA2","alex12340056", "JPA2@gmail.com","al0ex","ple0s","Spring JPA DATA ONLY");

        //User's services check.
       //Service userService = context.getBean(SpitterServiceImpl.class);

        Service userService = new SpitterServiceImpl();


        // User's CRUD testing.
        //userService.create(tempUser); // JPA OK.

        //Spitter tempSpitter= (Spitter) userService.read(26L);
        //if (tempSpitter != null){ System.out.println(tempSpitter.toString()); }  //JPA OK.



        //userService.update(02L, "The new jpa updated description."); // JPA OK.
        //System.out.println(userService.delete(15L));

    }


    public static void testTweets(/*ApplicationContext context*/)  {

        //----------------Tweet creation with date.---------------
        //Date date=Date.valueOf("2020-10-02");
        //Spittle tempTweet = new Spittle("Hello JPA Repository.",date,158.53,6547.09, 55L);

        //Tweet's services check.
        //Service tweetService = context.getBean(SpittleServiceImpl.class);
        Service tweetService = new SpittleServiceImpl();


        // Tweet's CRUD testing.

        //tweetService.create(tempTweet);
        //Spittle readTweet = (Spittle) tweetService.read(20L);
        //if (readTweet != null) System.out.println(readTweet.toString());
        //tweetService.update(17L, "Hello new JPA Repo world");
        System.out.println(tweetService.delete(16L));

    }


}
