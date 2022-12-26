package com.example.service;

import com.example.domain.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();

    public void regist(BoardDTO board);
    public BoardDTO get(Long boardNum);
    public boolean modify(BoardDTO board);
    public boolean remove(Long boardNum);

    public int getMaxBoardNum(String userId);
}
