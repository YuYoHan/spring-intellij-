package com.example.mapper;

import com.example.domain.BoardDTO;

import java.util.List;

public interface BoardMapper {
    List<BoardDTO> getList();
    void insert(BoardDTO board);
    int getMaxBoardNum(String userId);

    BoardDTO getDetail(Long boardNum);
}
