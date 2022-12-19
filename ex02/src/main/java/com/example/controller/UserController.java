package com.example.controller;

import com.example.domain.UserDTO;
import com.example.service.UserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {
    @Setter(onMethod_ = @Autowired)
    UserService service;
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
    public String join(UserDTO user, HttpServletResponse resp) {
        if(service.join(user)) {
            Cookie joinId = new Cookie("joinId", user.getUserId());
            // 쿠키종료
            // 쿠키 expiration 타임
            joinId.setMaxAge(300);
            resp.addCookie(joinId);
        }
        return "";
    }
}
