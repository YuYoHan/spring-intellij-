package com.example.controller;

import com.example.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    // 메소드명으로 찾는 것이 아니라
    // RequestMapping() 여기 가로 안에 써준 것을 찾는 것이다.
    @RequestMapping("basic1")
    public void basic1(int age) {
        log.info("============basic1============");
        log.info(age);
    }

    @GetMapping("basic2")
    public void basicGet() {
        log.info("=============get방식 요청==============");
    }

    @PostMapping("basic3")
    public void basicPost() {
        log.info("=============post방식 요청============");
    }

    @RequestMapping(value = "basic4", method = {RequestMethod.GET, RequestMethod.POST})
    public void basic() {
        log.info("=============get, post방식으로 요청==============");
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

    @GetMapping("ex02")
    public String ex02(@RequestParam("data1") String name, @RequestParam("data2") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "sample/ex02";
    }

    @GetMapping("ex03")
    public void ex03(@RequestParam("data") String[] datas, Model model) {
        model.addAttribute("datas", datas);
    }

    @GetMapping("ex04")
    public void ex04(@RequestParam("data")ArrayList<Integer> datas, Model model) {
        int sum = 0;
        for(int data : datas) {
            sum += data;
        }
        model.addAttribute("datas", datas);
        model.addAttribute("sum", sum);
    }
}
