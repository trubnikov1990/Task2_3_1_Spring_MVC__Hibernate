package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping ("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String allUsers(Model model) {
    model.addAttribute("users" , userService.listUsers());
    return "index";
  }

  @GetMapping ("/new")
  public String addUser (@ModelAttribute ("user") User user) {
    return "new";
  }

  @PostMapping
  public String createUser (@ModelAttribute ("user") User user){
    userService.addUser(user);
    return "redirect:/users";
  }

  @GetMapping("/edit")
  public String printEditForm(@RequestParam("id") int id, Model model) {
    model.addAttribute("user", userService.showUser(id));
    return "edit";
  }

  @PostMapping("/edit")
  public String edit(@ModelAttribute("user") User user, @RequestParam("id") int id) {
    userService.updateUser(id, user);
    return "redirect:/users";
  }
  @PostMapping("/delete")
  public String remove(@RequestParam("id") int id) {
    userService.deleteUser(id);
    return "redirect:/users";
  }
}
