package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardMapper {
	List<BoardDTO> getList(Criteria cri);
	void insert(BoardDTO board);
	int getMaxBoardnum(String userid);
	BoardDTO getDetail(Long boardnum);
	int getTotal(Criteria cri);
	int update(BoardDTO board);
	int delete(Long boardnum);
}
