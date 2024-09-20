package web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.entity.User;
import web.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "user";
    }

    @GetMapping("/")
    public String main() {
        return "redirect:/users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String addUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {

        User existingUser = service.getUser(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        service.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        service.remove(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "edit_user";
    }
}
