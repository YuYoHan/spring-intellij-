package com.example.service;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register....." + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(long boardNum) {
        return mapper.read(boardNum);
    }

    @Override
    public boolean modify(BoardVO board) {
        return false;
    }

    @Override
    public boolean remove(long boardNum) {
        return false;
    }

    @Override
    public List<BoardVO> getList() {
        return mapper.getList();
    }
}
