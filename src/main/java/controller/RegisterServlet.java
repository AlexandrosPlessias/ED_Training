package controller;

import domain.Spitter;
import services.Service;
import services.SpitterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get register.jsp request params for save to DB.
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String desc = request.getParameter("desc");

        Spitter newUser = new Spitter(name,password,email,firstName,lastName,desc);
        Service userService = new SpitterServiceImpl();
        try {
            userService.create(newUser);
            // Success message.



        } catch (SQLException e) {
            e.printStackTrace();
            // Not success message.
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

    }


}
