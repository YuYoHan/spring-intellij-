package com.example.controller;

import com.example.domain.SampleDTO;
import com.example.domain.SampleDTOList;
import com.example.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info(("-------basic--------"));
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicTest() {
        log.info("--------get, post---------");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO sample) {
        log.info("" + sample);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name")String name, @RequestParam("age")int age) {
        log.info("name : " + name);
        log.info("age : " + age);
        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03List(@RequestParam("list")ArrayList<String> list) {
        log.info(list);

        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(@RequestParam("list")String[] lists) {
        log.info(Arrays.toString(lists));
        return "ex04";
    }

    @GetMapping("/ex05")
    public String ex05(SampleDTOList list) {
        log.info(list);
        return "ex05";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(java.util.Date.class, new CustomBooleanEditor(dateFormat, false));
//    }


    @GetMapping("/ex06")
    public String ex06(TodoDTO todo) {
        log.info("todo : " + todo);
        return "ex06";
    }

    @GetMapping("/ex07")
    public String ex07(SampleDTO dto, int page) {
        log.info("dto : " + dto);
        log.info(("page : " + page));
        return "/sample/ex07";
    }

    @GetMapping("/ex08")
    public String ex08(SampleDTO dto, int page, Model model) {
        log.info(dto);
        model.addAttribute("dto", dto);
        model.addAttribute("page", page);
        return "/sample/ex08";
    }

    @GetMapping("/ex09")
    public String ex09(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto : " +dto);
        log.info("page : " + page);
        return "/sample/ex09";
    }

    @GetMapping("/ex10")
    public String ex10(@RequestParam("name")String name, @RequestParam("age") int age, RedirectAttributes rttr) {
        rttr.addFlashAttribute("name", "apple");
        rttr.addFlashAttribute("age", 18);
        return "/sample/ex10";
    }

    @GetMapping("/ex11")
    public String ex11(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        String name = "apple";
        session.setAttribute("sessionId", name);
        return "/sample/ex11";
    }

    @GetMapping("/ex12")
    public String ex12(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("sessionId");

        log.info("===================");
        log.info("세션에 저장되어 있는 변수 : " + name);
        log.info("===================");

        name = "banana";
        session.setAttribute("sessionId", name);
        return "/sample/ex12";
    }

    @GetMapping("/ex13")
    public String ex13(HttpServletRequest req) {
        req.getSession().invalidate();
        return "/sample/ex13";
    }

    @GetMapping("/ex14")
    public String ex14(@CookieValue("id") String idValue) {
        log.info(idValue);
        return "/sample/ex14";
    }

    @GetMapping("/ex15")
    public @ResponseBody SampleDTO ex15() {
        log.info("/ex15............");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }
}
