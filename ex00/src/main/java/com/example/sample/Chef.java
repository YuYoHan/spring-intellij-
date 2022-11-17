package com.example.sample;

import lombok.Data;
import org.springframework.stereotype.Component;

// 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시
@Component

// Lombok의 setter, getter, 생성자, toString() 등을 자동으로 생성해주는 어노테이션
@Data
public class Chef {
}
