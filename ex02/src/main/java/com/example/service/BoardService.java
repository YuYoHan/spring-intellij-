package com.example.service;

import com.example.domain.BoardDTO;
import com.example.domain.Criteria;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList(Criteria cri);

    public void regist(BoardDTO board);
    public BoardDTO get(Long boardNum);
    public boolean modify(BoardDTO board);
    public boolean remove(Long boardNum);

    public int getMaxBoardNum(String userId);

    public int count(Criteria cri);
}
