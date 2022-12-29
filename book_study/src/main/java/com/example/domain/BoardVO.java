package com.example.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long boardNum;
    private String boardTitle;
    private String boardContents;
    private String userId;
    private Date regDate;
    private  Date updateDate;
}
