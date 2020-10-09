package spittr.servlets;

import spittr.domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import spittr.services.Service;
import spittr.services.SpitterServiceImpl;
import spittr.config.TrainingConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@WebServlet(name = "register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {

    private Service userService;

    public void init() throws ServletException {
        super.init();

        ApplicationContext context = new AnnotationConfigApplicationContext(TrainingConfig.class);
        userService = context.getBean(SpitterServiceImpl.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get registerForm.jsp request params for save to DB.
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
            // Redirect to failUser.
            RequestDispatcher rs = request.getRequestDispatcher("registerFails.jsp");
            rs.forward(request, response);
        }

        // Redirect to successUser.
        RequestDispatcher rs = request.getRequestDispatcher("registerSuccess.jsp");
        rs.forward(request, response);

    }

}
