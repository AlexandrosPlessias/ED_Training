package spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

// Home controller declaration
@RestController
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping( method=GET)
    public ModelAndView home(Model model) {

        ModelAndView homeView = new ModelAndView("home");
        model.addAttribute("message", "Welcome to Spittr...");

        //return "home";
        return homeView ;
    }

}
