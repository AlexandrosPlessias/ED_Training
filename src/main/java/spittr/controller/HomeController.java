package spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
* @RestController indicates that the data returned by each method will be written straight into the response body
* instead of rendering a template. We have routes for each operations (@GetMapping, @PostMapping, @PutMapping and
* @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls).
* */


import static org.springframework.web.bind.annotation.RequestMethod.GET;

// Home controller declaration
@RestController
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @GetMapping
    public ModelAndView showHome(Model model) {

        ModelAndView homeView = new ModelAndView("home");
        model.addAttribute("message", "Welcome to Spittr...");

        //return "home";
        return homeView ;
    }

}
