package spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.domain.Spitter;
import spittr.services.SpitterServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterServiceImpl userService;
    private Spitter newUser;

    @Autowired
    public SpitterController(SpitterServiceImpl spitterService) {
        userService = spitterService;
    }


    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String showRegistration() {
        return "registerForm";
    }


    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String saveSpitter(HttpServletRequest request) {

        newUser = new Spitter();
        // Get registerForm.jsp request params for save to DB.
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setDescription(request.getParameter("desc"));
        System.out.println(newUser.toString());
        try {
            Spitter tempUser = userService.create(newUser);

            if ( tempUser== null){
                throw new SQLException();
            }

        } catch (SQLException | ClassNotFoundException  e) {
            // Redirect to failUser.
            return "registerFails";
        }

        return "redirect:/spitter/registerSuccess";
    }


    @RequestMapping(value="/registerFails", method=RequestMethod.GET)
    public String showRegistrationFails() {
        return "registerFails";
    }

    @RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
    public String showRegistrationSuccess(Model model) {

        System.out.println(newUser.toString());

        model.addAttribute("id", newUser.getId());
        model.addAttribute("username", newUser.getUsername());
        model.addAttribute("firstName", newUser.getFirstName());
        model.addAttribute("lastName", newUser.getLastName());
        model.addAttribute("desc", newUser.getLastName());

        return "registerSuccess";
    }

}
