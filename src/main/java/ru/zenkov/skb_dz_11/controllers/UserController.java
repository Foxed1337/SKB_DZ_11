package ru.zenkov.skb_dz_11.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user-login")
    public String userLogin() {
        return "redirect:/actuator/metrics/my.user.online";
    }

}
