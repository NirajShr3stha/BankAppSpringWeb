package com.mycompany.bankappspringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niraj Shrestha
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String helloWorld() {
        return "hello";
    }
}
