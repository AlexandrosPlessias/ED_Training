package controller;

import domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import persistence.DAO;
import persistence.SpitterDAOHibernateImpl;
import services.Service;
import services.SpitterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {

    private Service userService;

    public void init() throws ServletException {
        super.init();
        //ApplicationContext context = new FileSystemXmlApplicationContext("spring-config.xml");
        //DAO spitterDAOHibernate = (SpitterDAOHibernateImpl) context.getBean("spitterDAOHibernate");
        DAO spitterDAOHibernate = new SpitterDAOHibernateImpl();
        userService = new SpitterServiceImpl((SpitterDAOHibernateImpl) spitterDAOHibernate);
        //userService = new SpitterServiceImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get register.jsp request params for save to DB.
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String desc = request.getParameter("desc");

        Spitter newUser = new Spitter(name,password,email,firstName,lastName,desc);
        try {

            if (userService.create(newUser) == null){
                throw new SQLException();
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException  e) {
            // Redirect to successUser.
            RequestDispatcher rs = request.getRequestDispatcher("registrationfails.jsp");
            rs.forward(request, response);
        }

        // Redirect to successUser.
        RequestDispatcher rs = request.getRequestDispatcher("successuser.jsp");
        rs.forward(request, response);

    }

}
