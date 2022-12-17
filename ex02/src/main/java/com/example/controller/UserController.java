package com.example.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {
    // a태그이니까 GetMapping
    @GetMapping("/join")
    public void join() {

    }
}
