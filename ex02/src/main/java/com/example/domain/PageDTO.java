package com.example.domain;

// 페이징처리를 위한 DTO
public class PageDTO {
    private int startPage;
    private int endPage;
    private int realEnd;
    private int total;
    private boolean prev, next;
    private int pageNum;

    public PageDTO() {

    }

    public PageDTO(int total, int pageNum) {
        this.total = total;
        this.pageNum = pageNum;

        this.endPage = (int)Math.ceil(pageNum/10.0)*10;
        this.startPage = this.endPage - 9;

        this.realEnd = (int)Math.ceil(total * 1.0/10);

    }
}
