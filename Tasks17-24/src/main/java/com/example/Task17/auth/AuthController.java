package com.example.Task17.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class AuthController {
    private ApplicationUserService applicationUserService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login2.html";
    }

    @GetMapping("")
    public String getIndexPage() {
        return "index.html";
    }

    @GetMapping("registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration2.html";
    }

    @PostMapping("registration")
    public String signUpUser(@ModelAttribute("user") User user) {
        return applicationUserService.signUpUser(user);
    }
}