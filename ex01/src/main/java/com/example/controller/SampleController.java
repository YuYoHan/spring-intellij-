package com.example.controller;

import com.example.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
//    @RequestMapping("")
//    public String basic() {
//        log.info("----------basic-----------");
//        return "a";
//    }

    // 메소드명으로 찾는 것이 아니라
    // RequestMapping() 여기 가로 안에 써준 것을 찾는 것이다.
    @RequestMapping("basic1")
    public void basic2(int age) {
        log.info("=============basic1===========");
        log.info(age);
    }

    @GetMapping("basic")
    public void basicGet() {
        log.info("============Get방식으로 요청===========");
    }

    @PostMapping("basic")
    public void basicPost(int age) {
        log.info("=============Post방식으로 요청==========");
        log.info(age);
    }

    @RequestMapping(value = "basic2", method = {RequestMethod.GET, RequestMethod.POST})
    public void basic2() {
        log.info("===========get, post 방식으로 요청=================");
    }

    // Controller 파라미터 수집 방법

    // DTO 객체로 수집하기
    @GetMapping("ex01")
    public String ex01(SampleDTO dto, Model model) {
        log.info(dto);
        model.addAttribute("dto", dto);
        // WEB-INF/views/sample/ex01.jsp
        return "/sample/ex01";
    }
    // 파라미터 명과 담을 변수명이 다른 경우 수집 방법
    @GetMapping("ex02")
    public String ex02(@RequestParam("data1") String name, @RequestParam("data2") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "sample/ex02";
    }
}
