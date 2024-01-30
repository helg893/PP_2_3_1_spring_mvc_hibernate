package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.model.User;
import web.service.UserService;

import java.util.NoSuchElementException;

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

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit")
    public String edit(@RequestParam String id, Model model) {
        try {
            model.addAttribute("user", userService.find(Long.parseLong(id)).orElseThrow());
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Пользователь c id=%s не найден", id));
        }
        return "edit";
    }

    private static final String ERROR_MSG_USER_ID_NOT_FOUND = "Пользователь c id=%s не найден";

    @PatchMapping(value = "/users")
    public String update(@RequestParam String id, @ModelAttribute("user") User user) {
        try {
            userService.update(Long.parseLong(id), user);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ERROR_MSG_USER_ID_NOT_FOUND, id));
        }
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users")
    public String delete(@RequestParam String id) {
        try {
            userService.remove(Long.parseLong(id));
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ERROR_MSG_USER_ID_NOT_FOUND, id));
        }
        return "redirect:/users";
    }
}
