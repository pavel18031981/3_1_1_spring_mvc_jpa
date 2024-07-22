package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserService;
import web.services.UserServiceImp;

@Controller
@RequestMapping("/users")
public class   UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping("/one")
    public String getOneUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("oneUser", userService.findOne(id));
            return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.findOne(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user,@RequestParam("id") int id) {
        user.setId(id);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user,@RequestParam("id") int id) {
        user = new User();
        user.setId(id);
        userService.save(user);
        return "redirect:/users";

    }
}
