package com.example.domain;

import lombok.Data;

@Data
public class BoardDTO {
    private Long boardNum;
    private String boardTitle;
    private String boardContents;
    private String userId;
    private String regDate;
    private String updateDate;
}
