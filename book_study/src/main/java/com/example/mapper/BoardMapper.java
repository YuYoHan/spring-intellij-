package com.example.mapper;

import com.example.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    @Select("select * from board where boardNum >0")
    public List<BoardVO> getList();
}
