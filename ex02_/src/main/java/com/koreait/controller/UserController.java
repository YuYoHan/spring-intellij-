package com.koreait.controller;

import com.koreait.domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Log4j
@Controller
@RequestMapping("/user/*")
public class UserController {


    @GetMapping({"/join", "/login"})
    public void replace() {}

    @PostMapping("/join")
    public String join(UserDTO user, HttpServletResponse resp) {
        // join은 cookie로 처리

    }
}
