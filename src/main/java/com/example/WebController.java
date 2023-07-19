package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping("/index")
    public String home(){
        return "index";
    }
}
