package com.example.service;

import com.example.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public void register(BoardVO board);

    public BoardVO get(long boardNum);
    public boolean modify(BoardVO board);
    public boolean remove(long boardNum);
    public List<BoardVO> getList();
}
