package com.example.domain;

import lombok.Data;

@Data
public class Criteria {
    private int pageNum;
    private int amount;

    public Criteria() {
        // this() : 현재 클래스의 생성자
        this(1,10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
