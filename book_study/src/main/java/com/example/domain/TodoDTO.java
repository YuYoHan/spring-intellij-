package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {
//    private String title;
//    private Date dueDate;

    private String title;

    // 이 어노테이션을 사용하면 @InitBinder을 안써도 된다.
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;
}
