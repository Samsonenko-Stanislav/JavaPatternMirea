package ru.mirea.Task14.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.stereotype.Controller
public class HomeController {
    @GetMapping("/home")
    public String getTestPage() {
        return "index.html";
    }
}