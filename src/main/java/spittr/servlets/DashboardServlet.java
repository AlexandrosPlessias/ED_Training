package spittr.servlets;

import spittr.domain.Spittle;
import spittr.persistence.SpittleDAOHibernateImpl;
import spittr.services.Service;
import spittr.services.SpittleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dashboard", urlPatterns={"/dashboard"})
public class DashboardServlet extends HttpServlet {

    private Service tweetService;


    public void init() throws ServletException {
        super.init();
        //ApplicationContext context = new FileSystemXmlApplicationContext("spring-config.xml");
        //DAO spittleDAOHibernate = (SpittleDAOHibernateImpl) context.getBean("spittleDAOHibernate");
        //SpittleDAOHibernateImpl spittleDAOHibernate = new SpittleDAOHibernateImpl();
        tweetService = new SpittleServiceImpl(/*(SpittleDAOHibernateImpl) spittleDAOHibernate*/);
        //tweetService = new SpitterServiceImpl();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get all Tweets.
        // Step 1: Get the request dispatcher
        // Step 2: forward the request and response

        List<Spittle> allTweets = new ArrayList<>();

        allTweets.add((Spittle) tweetService.read(12L));
        allTweets.add((Spittle) tweetService.read(13L));
        allTweets.add((Spittle) tweetService.read(16L));
        allTweets.add((Spittle) tweetService.read(17L));

        req.setAttribute("data", allTweets);



    }

}