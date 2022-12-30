package com.koreait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyDTO;

public interface ReplyMapper {
	int insert(ReplyDTO reply);
	int delete(Long replynum);
	int update(ReplyDTO reply);
	
	List<ReplyDTO> getList(@Param("cri")Criteria cri, @Param("boardnum")Long boardnum);
	int getTotal(Long boardnum);
	int getNum(String userid);
}
