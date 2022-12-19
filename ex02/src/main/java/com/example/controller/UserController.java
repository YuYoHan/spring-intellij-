package com.example.controller;

import com.example.domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {
    // a태그이니까 GetMapping
//    @GetMapping("/join")
//    public void join() {
//    }
//
//    @GetMapping("/login")
//    public void login() {
//    }

    // 배열로 묶어놓은 것
    @GetMapping({"/join","/login"})
    public void replace() {}

    @PostMapping("/join")
    public String join(UserDTO user, HttpServletRequest req) {

    }
}
