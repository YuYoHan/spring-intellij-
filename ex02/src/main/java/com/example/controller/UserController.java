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
import javax.servlet.http.HttpSession;

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
    // 자연스럽게 날라온 응답객체를 addCookie로 보내주기 위해서 매개변수로 받는다.
    public String join(UserDTO user, HttpServletResponse resp) {
        if(service.join(user)) {
            Cookie joinId = new Cookie("joinId", user.getUserId());
            // 쿠키 종료
            // 쿠키 expiration 타임
            joinId.setMaxAge(300);
            // 쿠키 저장
            resp.addCookie(joinId);
        }
        // 그냥 return "이름"을 하면 이름에 해당하는 view를 보여주는 것이고
        // return "redirect:/"을 하면 redirect: 오른쪽 주소로 URL요청을 다시 하는 것입니다.
        // 그로 인해 주소가 바뀌고 해당 URL에 속하는 컨트롤러의 함수가 한번 더 호출이 되는 것이다.
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String userId, String userPw, HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserDTO loginUser = service.login(userId, userPw);
        if(loginUser != null) {
            session.setAttribute("loginUser", loginUser.getUserId());
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        // 삭제
        req.getSession().invalidate();
        return "index";
    }
}
