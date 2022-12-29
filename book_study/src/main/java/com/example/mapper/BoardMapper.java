package com.example.mapper;

import com.example.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(long boardNum);

    public  int delete(long boardNum);

    public int update(BoardVO board);
}
