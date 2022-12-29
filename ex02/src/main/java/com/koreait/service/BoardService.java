package com.koreait.service;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);
	
	public void regist(BoardDTO board);
	
	public BoardDTO get(Long boardnum);
	
	public boolean modify(BoardDTO board);
	
	public boolean remove(Long boardnum);
	
	public int getMaxBoardnum(String userid);

	public int count(Criteria cri);
}
