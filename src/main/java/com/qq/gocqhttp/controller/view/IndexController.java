package com.qq.gocqhttp.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("msg", "欢迎使用繁星机器人！");
        return "index";
    }
}
