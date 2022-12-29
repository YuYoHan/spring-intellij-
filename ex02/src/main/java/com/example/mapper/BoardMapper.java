package com.example.mapper;

import com.example.domain.BoardDTO;
import com.example.domain.Criteria;

import java.util.List;

public interface BoardMapper {
    List<BoardDTO> getList(Criteria cri);
    void insert(BoardDTO board);
    int getMaxBoardNum(String userId);

    BoardDTO getDetail(Long boardNum);

    int getTotal(Criteria cri);
}
