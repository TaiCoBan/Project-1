package project.project1.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.project1.menu.service.AccountService;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/secured")
    private String secured() {
        return "secured";
    }
}
