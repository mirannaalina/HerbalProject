package ro.herb.herbalproject.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.herb.herbalproject.model.User;
import ro.herb.herbalproject.persistence.user.UserEntity;
import ro.herb.herbalproject.persistence.user.UserRepository;
import ro.herb.herbalproject.service.user.UserService;
import ro.herb.herbalproject.service.user.UserServiceInt;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController  {

    @Autowired
    private UserServiceInt userServiceInt;



    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration.html";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto , BindingResult result){
        UserEntity existing = userServiceInt.findByEmail(userDto.getEmail());
        if(existing!=null){
            result.rejectValue("email",null,"There is already an account registered with that email");
        }
        if(result.hasErrors()){
            return "registration.html";
        }

        //if user doesn;t exist, create->
        userServiceInt.save((userDto));
        return "redirect:/registration?success";
    }



}
