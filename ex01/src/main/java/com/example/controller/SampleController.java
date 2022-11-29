package com.example.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
