package com.koreait.domain;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long replynum;
	private String userid;
    private String replycontents;
    private String regdate;
    private String updatedate;
    private Long boardnum;
}
