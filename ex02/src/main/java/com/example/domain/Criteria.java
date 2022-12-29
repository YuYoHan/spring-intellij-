package com.example.domain;

import lombok.Data;

@Data
public class Criteria {
    private int pageNum;
    private int amount;
    private int startrow;

    public Criteria() {
        // this() : 현재 클래스의 생성자
        this(1,10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.startrow = 0;

    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.startrow = (this.pageNum -1 ) * this.amount;
    }
}
