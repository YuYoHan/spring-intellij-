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
}
