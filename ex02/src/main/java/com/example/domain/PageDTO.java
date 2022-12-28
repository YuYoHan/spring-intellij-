package com.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// 페이징처리를 위한 DTO
public class PageDTO {
    private int startPage;
    private int endPage;
    private int realEnd;
    private int total;
    private boolean prev, next;
    private int pageNum;


    public PageDTO(int total, Criteria cri) {
        int pageNum = cri.getPageNum();
        this.total = total;
        this.pageNum = pageNum;

        this.endPage = (int)Math.ceil(pageNum/10.0)*10;
        this.startPage = this.endPage - (cri.getAmount() -1);

        this.realEnd = (int)Math.ceil(total * 1.0/10);
        endPage = endPage > realEnd ? realEnd : endPage;

        this.prev = this.startPage > 1;
        this.next = this.endPage < this.realEnd;
    }
}
