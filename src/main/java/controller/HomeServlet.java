package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// [V]iew the webapp jsp files.
// [M]odel = business logic = Services.
// [C]ontroller the servlet objects, invoking Model and sending data to View.

/* Servlet implementation class HomeServlet*/
@WebServlet(name = "home", urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {


   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // in the index.jsp i will have 2 links for register & dashboard.


    }

}
