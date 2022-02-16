package li.sarossill.twitchplays.controllers;

import li.sarossill.twitchplays.services.ChatService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/users")
    public String listOwners(Model model){
        model.addAttribute("users",userService.findAll());
        System.out.println(userService.findAll().size());
        return "users";
    }
}
