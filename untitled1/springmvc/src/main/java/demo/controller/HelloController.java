package demo.controller;

import demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(User user){
        System.out.println(user);
        return "hh";
    }
}
