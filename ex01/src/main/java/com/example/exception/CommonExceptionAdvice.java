package com.example.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model) {
        log.error("==============Exception============");
        log.error(e.getMessage());
        model.addAttribute("exception", e);
        return "error_page";
    }
}
