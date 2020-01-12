package ro.herb.herbalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("herbal")
public class MainController {

    //when a user is loggin on, the data from that user to be displayed.
    @GetMapping("/{user)")
    public String list(){
        return "list.html";
    }

    //shows a login form
    @GetMapping("/login")
    public String login(Model model){

        return "login.html";
    }

    //shows a registration form
    @GetMapping("/registration")
    public String registration(){
        return "registation.html";
    }
}
