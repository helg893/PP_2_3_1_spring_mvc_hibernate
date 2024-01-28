package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
        userService.add(new User("Chuck", "Norris", "chuck@norr.is"));
        userService.add(new User("Bruce", "Lee", "bruce@l.ee"));
        userService.add(new User("Евгений Ваганович", "Петросян", "eugen@petrosy.an"));
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

}
