package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model modle) {
        modle.addAttribute("name", "imooc");
        return "index";
    }

    @GetMapping("/404")
    @ResponseBody
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    @ResponseBody
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    @ResponseBody
    public String internalError() {
        return "500";
    }

    @GetMapping("/logout/page")
    @ResponseBody
    public String logout() {
        return "logout";
    }
}
