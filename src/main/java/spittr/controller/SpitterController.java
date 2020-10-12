package spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spittr.domain.Spitter;
import spittr.services.SpitterServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterServiceImpl userService;
    private Spitter newUser;

    @Autowired
    public SpitterController(SpitterServiceImpl spitterService) {
        userService = spitterService;
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView showRegistration() {
        return new ModelAndView("registerForm");
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView saveSpitter(Model model, HttpServletRequest request) {

        newUser = new Spitter();
        // Get registerForm.jsp request params for save to DB.
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setDescription(request.getParameter("desc"));

        System.out.print(newUser.toString());

        try {
            Spitter tempUser = userService.create(newUser);
            model.addAttribute("username", newUser.getUsername());

            if ( tempUser == null){
                throw new SQLIntegrityConstraintViolationException();
            }

        } catch (Exception e) {
            return new ModelAndView("redirect:/spitter/registerFails");
        }

        return new ModelAndView("redirect:/spitter/registerSuccess");
        //return "redirect:/spitter/registerSuccess";
    }

    @RequestMapping(value="/registerFails", method=RequestMethod.GET)
    public ModelAndView showRegistrationFails() {

        return new ModelAndView("registerFails");
        //return "registerFails";
    }

    @RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
    public ModelAndView showRegistrationSuccess(Model model) {

        model.addAttribute("id", newUser.getId());
        model.addAttribute("username", newUser.getUsername());
        model.addAttribute("firstName", newUser.getFirstName());
        model.addAttribute("lastName", newUser.getLastName());
        model.addAttribute("desc", newUser.getLastName());

        return new ModelAndView("registerSuccess");

        //return "registerSuccess";
    }

    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public ModelAndView showProfile(@PathVariable String username, Model model){

        Spitter user = userService.findByUsername(username);

        model.addAttribute("spitter", user);
        return new ModelAndView("profile");
        //return "profile";

    }

}
