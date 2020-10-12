package com.example.zero.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @RequestMapping("/sign-in")
    public String getSignHtml() {
        return "sign-in";
    }


    @GetMapping("/user/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Model model) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "登录失败");
            return "redirect:/sign-in";
        }
        return "index";

    }
}
