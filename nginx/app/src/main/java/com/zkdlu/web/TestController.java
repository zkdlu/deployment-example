package com.zkdlu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TestController {
    @GetMapping("/")
    public String index(Map model) {
        System.out.println("Hello world");
        model.put("message", "Test");
        return "index";
    }
}
