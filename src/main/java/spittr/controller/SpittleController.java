package spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spittr.domain.Spitter;
import spittr.domain.Spittle;
import spittr.services.SpittleServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spittle")
public class SpittleController {

    private SpittleServiceImpl spittleService;

    // Constructor injection of SpittleServiceImpl.
    @Autowired
    public void DashboardController(SpittleServiceImpl spittleService) {
        this.spittleService = spittleService;
    }

    /*
    It is required to place the Model interface in the controller part of the application. The object of
    HttpServletRequest reads the information provided by the user and pass it to the Model interface. Now, a view page
    easily accesses the data from the model part.
     */

    @GetMapping(value="/dashboard")
    public ModelAndView dashboard(Model model) {

        List<Spittle> allTweets = new ArrayList<>();

        try {

            allTweets = spittleService.getAll();

            if (allTweets.contains(null)){
                throw new SQLException();
            }

        } catch (SQLException  e) {
            // MUST BE OTHER PAGE...
            return  new ModelAndView("registerFails");
        }

        ModelAndView dashView = new ModelAndView("dashboard");
        model.addAttribute("spittleList", allTweets);
        return dashView;
    }

}
