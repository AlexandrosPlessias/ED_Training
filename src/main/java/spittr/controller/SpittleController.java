package spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spittr.domain.Spittle;
import spittr.services.SpittleServiceImpl;

import javax.xml.ws.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/spittle")
public class SpittleController {

    private List<Spittle> allTweets;
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
    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public String dashboard(Model model) {

        allTweets = new ArrayList<>();

        try {
            allTweets.add(spittleService.read(12L));
            allTweets.add(spittleService.read(13L));
            allTweets.add(spittleService.read(16L));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "registerFails";
        }

        model.addAttribute("spittleList", allTweets);

        return "dashboard";
    }
}
